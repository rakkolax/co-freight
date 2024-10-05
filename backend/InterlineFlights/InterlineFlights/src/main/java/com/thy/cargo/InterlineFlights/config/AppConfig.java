package com.thy.cargo.InterlineFlights.config;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;
import de.escalon.hypermedia.hydra.serialize.JacksonHydraSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Value("${integration.timeout:5000}")
    private String timeout;


    @Bean(name="restTemplate")
    @Primary
    public RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();

        clientHttpReq.setConnectTimeout(Integer.parseInt(timeout));
        clientHttpReq.setReadTimeout(Integer.parseInt(timeout));
        return new RestTemplate(clientHttpReq);
    }

    @Bean("objectMapper")
    @Primary
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(getJacksonHydraSerializerModule());
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);



        return objectMapper;
    }

    SimpleModule getJacksonHydraSerializerModule() {
        return new SimpleModule() {
            @Override
            public void setupModule(SetupContext context) {
                super.setupModule(context);

                context.addBeanSerializerModifier(new XmlBeanSerializerModifier() {
                    @Override
                    public JsonSerializer<?> modifySerializer(
                            SerializationConfig config,
                            BeanDescription beanDesc,
                            JsonSerializer<?> serializer) {
                        if (serializer instanceof BeanSerializerBase) {
                            return new JacksonHydraSerializer((BeanSerializerBase) serializer);
                        } else {
                            return serializer;
                        }
                    }
                });
            }
        };
    }
}

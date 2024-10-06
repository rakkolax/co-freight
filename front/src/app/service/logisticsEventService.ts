import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Injectable} from "@angular/core";
import {Observable} from "rxjs";

export const BASE_URI: string = "http://localhost:8081"

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
    'Access-Control-Allow-Origin': '*'
  })
};

@Injectable({
  providedIn: 'root'
})
export class LogisticsEventService {
  constructor(private httpClient: HttpClient) {
  }

  sendNFD(body: any): Observable<any> {
    return this.httpClient.post<any>(BASE_URI + "/logisticsevent/sendnfd", body, httpOptions);
  }

  sendCCD(body: any): Observable<any> {
    return this.httpClient.post<any>(BASE_URI + "/logisticsevent/sendccd", body, httpOptions);
  }

  sendDLV(body: any): Observable<any> {
    return this.httpClient.post<any>(BASE_URI + "/logisticsevent/senddlv", body, httpOptions);
  }

  getMessageList(): Observable<any> {
    return this.httpClient.post<any>(BASE_URI + "/orms/message", httpOptions);
  }

}

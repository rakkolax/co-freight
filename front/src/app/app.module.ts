import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ButtonModule} from "primeng/button";
import {MenubarModule} from "primeng/menubar";
import {BadgeModule} from "primeng/badge";
import {AvatarModule} from "primeng/avatar";
import {InputTextModule} from "primeng/inputtext";
import {ToastModule} from "primeng/toast";
import {ImageModule} from "primeng/image";
import {CardModule} from "primeng/card";
import {FormsModule} from "@angular/forms";
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {InputNumberModule} from "primeng/inputnumber";
import {CalendarModule} from "primeng/calendar";
import {InputIconModule} from "primeng/inputicon";
import {IconFieldModule} from "primeng/iconfield";
import { ListFlightComponent } from './module/list-flight/list-flight.component';
import { SearchFlightComponent } from './module/search-flight/search-flight.component';
import {DropdownModule} from "primeng/dropdown";
import {FloatLabelModule} from "primeng/floatlabel";
import {DividerModule} from "primeng/divider";
import { BookingHistoryComponent } from './module/booking-history/booking-history.component';
import {StepsModule} from "primeng/steps";
import {PanelModule} from "primeng/panel";
import {TagModule} from "primeng/tag";
import {TableModule} from "primeng/table";
import {DataViewModule} from "primeng/dataview";
import {RatingModule} from "primeng/rating";
import {ToolbarModule} from "primeng/toolbar";
import {FieldsetModule} from "primeng/fieldset";
import { DealerListComponent } from './module/dealer-list/dealer-list.component';
import { CreateAgreementComponent } from './module/create-agreement/create-agreement.component';
import {MultiSelectModule} from "primeng/multiselect";
import {DialogService, DynamicDialogModule} from "primeng/dynamicdialog";
import { AgreementDocComponent } from './module/agreement-doc/agreement-doc.component';
import {EditorModule} from "primeng/editor";
import { AgreementConfirmComponent } from './module/agreement-confirm/agreement-confirm.component';
import {CheckboxModule} from "primeng/checkbox";
import {ConfirmationService, MessageService} from "primeng/api";
import {ConfirmPopupModule} from "primeng/confirmpopup";

@NgModule({
  declarations: [
    AppComponent,
    ListFlightComponent,
    SearchFlightComponent,
    BookingHistoryComponent,
    DealerListComponent,
    CreateAgreementComponent,
    AgreementDocComponent,
    AgreementConfirmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ButtonModule,
    MenubarModule,
    BadgeModule,
    AvatarModule,
    InputTextModule,
    ToastModule,
    ImageModule,
    CardModule,
    FormsModule,
    InputNumberModule,
    CalendarModule,
    InputIconModule,
    IconFieldModule,
    DropdownModule,
    FloatLabelModule,
    DividerModule,
    StepsModule,
    PanelModule,
    TagModule,
    TableModule,
    DataViewModule,
    RatingModule,
    ToolbarModule,
    FieldsetModule,
    MultiSelectModule,
    DynamicDialogModule,
    EditorModule,
    CheckboxModule,
    ConfirmPopupModule

  ],
  providers: [
    provideAnimationsAsync(),
    DialogService,
    ConfirmationService,
    MessageService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

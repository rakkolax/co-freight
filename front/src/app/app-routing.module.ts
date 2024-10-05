import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListFlightComponent} from "./module/list-flight/list-flight.component";
import {SearchFlightComponent} from "./module/search-flight/search-flight.component";
import {BookingHistoryComponent} from "./module/booking-history/booking-history.component";
import {DealerListComponent} from "./module/dealer-list/dealer-list.component";
import {CreateAgreementComponent} from "./module/create-agreement/create-agreement.component";

const routes: Routes = [
  {path: 'list-flight', component: ListFlightComponent},
  {path: '', component: SearchFlightComponent},
  {path: 'booking-history', component: BookingHistoryComponent},
  {path: 'dealer-list', component: DealerListComponent},
  {path: 'create-agreement', component: CreateAgreementComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

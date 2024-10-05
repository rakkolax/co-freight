import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrl: './booking-history.component.scss'
})
export class BookingHistoryComponent implements OnInit {

  steps: MenuItem[] | undefined;
  historyList: any[];
  active: number = 2;


  constructor() {
    this.historyList = [
      {
        step: 'Booking Creation',
        date: '05.10.2024',
        status: 'Done',
        by:'Expeditors',
        origin:"HKG",
        contact:"info@expeditors.com"
      },
      {
        step: 'Shipment Acceptance(ORG)',
        date: '06.10.2024',
        status: 'Done',
        by:'HACTL (GHA)',
        origin:"HKG",
        contact:"info@hactl.com"
      },
      {
        step: 'Flight QR-1250',
        date: '06.10.2024',
        status: 'Progress',
        by:'Qatar Airways',
        origin:"HKG",
        destination:"DOH",
        contact:"info@qatarairways.com"
      },
      {
        step: 'Flight QR-2566',
        date: '',
        status: 'Waiting',
        by:'Qatar Airways',
        origin:"DOH",
        destination:"IST",
        contact:"info@qatarairways.com"
      },
      {
        step: 'Flight TK-1111',
        date: '',
        status: 'Waiting',
        by:'Turkish Airlines',
        origin:"IST",
        destination:"SCL",
        contact:"info@turkishcargo.com"
      },
      {
        step: 'Shipment Acceptance(DES)',
        date: '',
        status: 'Waiting',
        by:'SWISSPORT (GHA)',
        destination:"SCL",
        contact:"info@swissport.com"
      },
      {
        step: 'Shipment Delivery',
        date: '',
        status: 'Waiting',
        by:'Customer',
        destination:"SCL"
      }
    ];
  }

  ngOnInit(): void {
    this.steps = [
      {
        label: 'Booking Creation'
      },
      {
        label: 'Shipment Acceptance(ORG)'
      },
      {
        label: 'Flight QR-1250'
      },
      {
        label: 'Flight QR-2566'
      },
      {
        label: 'Flight TK-1111'
      },
      {
        label: 'Shipment Acceptance(DES)'
      },
      {
        label: 'Shipment Delivery'
      }
    ];
  }

  getSeverity(status: string) {
    switch (status) {
      case 'Done':
        return 'success';
      case 'Progress':
        return 'warning';
      case 'Waiting':
        return 'danger';
      default:
        return 'danger';
    }
  }

}

interface BookingHistory {
  step: string;
  date: string;
  by: string;
  origin: string;
  destination: string | undefined;
  status: string;
}

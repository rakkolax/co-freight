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
        step: 'NFR',
        date: '01.10.2024',
        status: 'Done'
      },
      {
        step: 'TSI',
        date: '02.10.2024',
        status: 'Done'
      },
      {
        step: 'DEP',
        date: '03.10.2024',
        status: 'Progress'
      },
      {
        step: 'ARR',
        date: '',
        status: 'Waiting'
      },
      {
        step: 'RDY',
        date: '',
        status: 'Waiting'
      }
    ];
  }

  ngOnInit(): void {
    this.steps = [
      {
        label: 'NFR'
      },
      {
        label: 'TSI'
      },
      {
        label: 'DEP'
      },
      {
        label: 'ARR'
      },
      {
        label: 'RDY'
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
  status: string;
}

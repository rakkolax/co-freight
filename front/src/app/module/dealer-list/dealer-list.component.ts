import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-dealer-list',
  templateUrl: './dealer-list.component.html',
  styleUrl: './dealer-list.component.scss'
})
export class DealerListComponent implements OnInit {

  dealerList: DealerModel[];
  origin: string = "";
  destination: string = "";
  commodities: DropdownModel[] | undefined;
  selectedCommodity: DropdownModel | undefined;

  weightBreaks: DropdownModel[] | undefined;
  selectedWeightBreak: DropdownModel | undefined;

  constructor(private router: Router) {
    this.dealerList = [
      {
        companyName: 'Turkish Cargo',
        origin: 'IST',
        destination: 'HXZ',
        weight: '1000',
        flightNumber: 'TK-2234',
        contact: 'rkolan@gmail.com',
        status: 1
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 2
      },
      {
        companyName: 'Qatar Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 1
      },
      {
        companyName: 'Lutfansa Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 3
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status:2
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 1
      },
      {
        companyName: 'Qatar Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 2
      },
      {
        companyName: 'Lutfansa Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status:3
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 1
      }
    ];
  }

  ngOnInit(): void {
    this.commodities = [
      {name: 'GEN', code: 'GEN'},
      {name: 'PER', code: 'PER'},
      {name: 'HUM', code: 'HUM'},
      {name: 'VAL', code: 'VAL'},
      {name: 'VUN', code: 'VUN'}
    ];
    this.weightBreaks = [
      {name: '100-500', code: '100-500'},
      {name: '500-1000', code: '500-1000'},
      {name: '1000+', code: '1000+'}
    ];
  }

  getDealerList(){
    this.dealerList = [
      {
        companyName: 'Turkish Cargo',
        origin: 'IST',
        destination: 'HXZ',
        weight: '1000',
        flightNumber: 'TK-2234',
        contact: 'rkolan@gmail.com',
        status: 1
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 2
      },
      {
        companyName: 'Qatar Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 1
      },
      {
        companyName: 'Lutfansa Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 3
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status:2
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 1
      },
      {
        companyName: 'Qatar Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 2
      },
      {
        companyName: 'Lutfansa Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status:3
      },
      {
        companyName: 'Turkish Cargo',
        origin: '',
        destination: '',
        weight: '',
        flightNumber: '',
        contact: '',
        status: 1
      }
    ];
  }

  filterByStatus(status: number) {
    this.getDealerList();
    this.dealerList = this.dealerList.filter(item => item.status == status)
  }

  getSeverity(status: number) {
    if (status == 1) {
      return 'info'
    }
    if (status == 2) {
      return 'warning'
    }
    return 'success'
  }

  routeToNewAgreement() {
    this.router.navigateByUrl("/create-agreement");
  }
}

interface DealerModel {
  companyName: string;
  origin: string;
  destination: string;
  weight: string;
  flightNumber: string;
  contact: string;
  status: number;
}

interface DropdownModel {
  name: string;
  code: string;
}

import {Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrl: './search-flight.component.scss'
})

export class SearchFlightComponent implements OnInit{

  constructor(private router: Router) { }

  origin: string = "";
  checked: boolean= false;
  destination: string = "";
  width: string = "";
  length: string = "";
  weight: string = "";
  height: string = "";
  piece: number = 1;
  bookingID: string = "";
  date: Date | undefined;
  commodities: CommodityCode[] | undefined;
  selectedCommodity: CommodityCode | undefined;

  ngOnInit(): void {
    this.commodities = [
      { name: 'GEN', code: 'GEN' },
      { name: 'PER', code: 'PER' },
      { name: 'VAL', code: 'VAL' },
      { name: 'VUN', code: 'VUN' },
      { name: 'DGR', code: 'DGR' }

    ];

  }

  btnClick() {
    this.router.navigateByUrl('/booking-history');
  };

  listFlight() {
    this.router.navigateByUrl('/list-flight');
  };
}

interface CommodityCode {
  name: string;
  code: string;
}

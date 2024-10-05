import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-flight',
  templateUrl: './list-flight.component.html',
  styleUrl: './list-flight.component.scss'
})
export class ListFlightComponent implements OnInit{

  flightOptions: FlightOption[];
  origin: string = "IST";
  destination: string = "FRA";
  date:string="";

  constructor(private router: Router) {
    this.flightOptions = [
      {
        companyName: 'Turkish Cargo',
        price: 120,
        date: '10.10.2024',
        src:'assets/icons/flightmenu.png'
      },
      {
        companyName: 'Turkish Cargo',
        price: 160,
        date: '11.10.2024',
        src:'assets/icons/flightmenu2.png'
      },
      {
        companyName: 'Qatar Cargo',
        price: 140,
        date: '11.10.2024',
        src:'assets/icons/flightmenu3.png'
      },
      {
        companyName: 'Lutfansa Cargo',
        price: 125,
        date: '11.10.2024',
        src:'assets/icons/flightmenu4.png'
      }
    ];
  }

  ngOnInit(): void {
  }

  getSeverity(item: FlightOption) {
    if (item.price > 120) {
      return 'success';
    }
    return 'warning';
  }

}

interface FlightOption {
  companyName: string;
  price: number;
  date: string;
  src: string;
}

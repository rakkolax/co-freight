import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import Swal from 'sweetalert2'

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
  visible: boolean = false;

  constructor(private messageService: MessageService) {
    this.flightOptions = [
      {
        companyName: 'Turkish Cargo',
        rate: 7,
        price: 3500,
        date: '06.10.2024',
        src:'assets/icons/flightmenu.png',
        duration:'36h 20m',
        emission:'2'
      },
      {
        companyName: 'Turkish Cargo',
        rate: 8,
        price: 4000,
        date: '06.10.2024',
        src:'assets/icons/flightmenu5.png',
        duration:'32h 45m',
        emission:'4'
      },
      {
        companyName: 'Qatar Cargo',
        rate: 11,
        price: 5500,
        date: '06.10.2024',
        src:'assets/icons/flightmenu3.png',
        duration:'33h 40m',
        emission:'3'
      },
      {
        companyName: 'Lutfansa Cargo',
        rate: 8,
        price: 4000,
        date: '06.10.2024',
        src:'assets/icons/flightmenu4.png',
        duration:'32h 45m',
        emission:'4'
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
  onConfirm() {
    this.messageService.clear('confirm');
    this.visible = false;
  }

  onReject() {
    this.messageService.clear('confirm');
    this.visible = false;
  }

  showConfirm() {
    Swal.fire({
      title: "Booking created successfully!",
      text: "Booking ID : HKGSCL23512345678",
      icon: "success"
    });
  }
}

interface FlightOption {
  companyName: string;
  rate: number;
  price: number;
  date: string;
  src: string;
  duration: string;
  emission:string;
}

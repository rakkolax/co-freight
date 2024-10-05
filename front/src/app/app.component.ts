import {Component, OnInit} from '@angular/core';
import {MenuItem} from "primeng/api";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  origin: string = "";
  destination: string = "";
  width: string = "";
  length: string = "";
  weight: string = "";
  height: string = "";
  date: Date | undefined;
  items: MenuItem[] | undefined;
  title = 'interline';

  ngOnInit(): void {
    this.items = [
      {
        label: 'Home',
        icon: 'pi pi-home',
        routerLink: '/'
      },
      {
        label: 'Features',
        icon: 'pi pi-star'
      },
      {
        label: 'Dealer',
        icon: 'pi pi-file-edit',
        routerLink: '/dealer-list'
      }]
  }


}

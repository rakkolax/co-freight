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
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: '',
        icon: 'pi',
        routerLink: '/'
      },
      {
        label: 'Home',
        icon: 'pi pi-home',
        routerLink: '/'
      },
      {
        label: 'Booking',
        icon: 'pi pi-file-edit',
        routerLink: '/'
      },
      {
        label: 'Agreements',
        icon: 'pi pi-copy',
        routerLink: '/dealer-list'
      },
      {
        label: 'About Us',
        icon: 'pi pi-user',
        routerLink: '/'
      },
      {
        label: 'FAQ',
        icon: 'pi pi-question-circle',
        routerLink: '/'
      }
    ]
  }


}

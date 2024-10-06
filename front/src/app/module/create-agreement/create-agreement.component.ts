import {Component, OnInit} from '@angular/core';
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {AgreementDocComponent} from "../agreement-doc/agreement-doc.component";

@Component({
  selector: 'app-create-agreement',
  templateUrl: './create-agreement.component.html',
  styleUrl: './create-agreement.component.scss'
})
export class CreateAgreementComponent implements OnInit {

  ref: DynamicDialogRef | undefined;

  origin: string | undefined;
  destination: string | undefined;
  validFrom: Date | undefined;
  validTo: Date | undefined;
  airlineCompanies: SelectModel[] | undefined;
  selectedAirline: SelectModel | undefined;
  commodities: SelectModel[] | undefined;
  selectedCommodity: SelectModel | undefined;
  weightBreaks: SelectModel[] | undefined;
  selectedWeightBreak: SelectModel | undefined;
  weightOptions: SelectModel[] | undefined;
  selectedWeightOption: SelectModel | undefined;
  agreementTypes: SelectModel[] | undefined;
  selectedAgreementType: SelectModel | undefined;
  price: number | undefined;

  constructor(public dialogService: DialogService) {

  }

  ngOnInit(): void {
    this.airlineCompanies = [
      { name: 'Qatar Airways', code: 'GEN' },
      { name: 'Gotham Airlines', code: 'PER' },
      { name: 'Vietnam Airlines', code: 'HUM' },
      { name: 'Avianca Airlines', code: 'ABC' }
    ];
    this.commodities = [
      {name: 'GEN', code: 'GEN'},
      {name: 'PER', code: 'PER'},
      {name: 'VAL', code: 'VAL'},
      {name: 'VUN', code: 'VUN'}
    ];
    this.weightBreaks = [
      {name: '100-500', code: '100-500'},
      {name: '500-1000', code: '500-1000'},
      {name: '1000+', code: '1000+'}
    ];
    this.weightOptions = [
      {name: 'Subject to Space', code: '1'},
      {name: 'Customize', code: '2'}
    ];
    this.agreementTypes = [
      {name: 'Hard SPA', code: '1'},
      {name: 'Soft SPA', code: '2'}
    ];
  }

  show() {
    this.ref = this.dialogService.open(AgreementDocComponent, { header: 'Agreement Review'});
  }


}

interface SelectModel {
  name: string;
  code: string;
}

import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-negotiate',
  templateUrl: './negotiate.component.html',
  styleUrl: './negotiate.component.scss'
})
export class NegotiateComponent implements OnInit{
  origin: string | undefined;
  destination: string | undefined;
  validFrom: Date | undefined;
  validTo: Date | undefined;
  price: number | undefined;
  airlineCompanies: SelectModel[] | undefined;
  commodities: SelectModel[] | undefined;
  selectedCommodity: SelectModel | undefined;
  weightBreaks: SelectModel[] | undefined;
  selectedWeightBreak: SelectModel | undefined;
  weightOptions: SelectModel[] | undefined;
  selectedWeightOption: SelectModel | undefined;
  agreementTypes: SelectModel[] | undefined;
  selectedAgreementType: SelectModel | undefined;

  constructor() {

  }

  ngOnInit(): void {
    this.airlineCompanies = [
      { name: 'Qatar Airways', code: 'GEN' },
      { name: 'Lutfansa', code: 'PER' },
      { name: 'Thai Airways', code: 'HUM' },
      { name: 'Pegasus Cargo', code: 'VAL' },
      { name: 'Gotham Airlines', code: 'VUN' }
    ];
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
    this.weightOptions = [
      {name: 'Subject to Space', code: '1'},
      {name: 'Customize', code: '2'}
    ];
    this.agreementTypes = [
      {name: 'Hard SPA', code: '1'},
      {name: 'Soft SPA', code: '2'}
    ];
  }

}

interface SelectModel {
  name: string;
  code: string;
}

import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {DialogService, DynamicDialogRef} from "primeng/dynamicdialog";
import {AgreementDocComponent} from "../agreement-doc/agreement-doc.component";
import {AgreementConfirmComponent} from "../agreement-confirm/agreement-confirm.component";
import {SignedAgrComponent} from "../signed-agr/signed-agr.component";

@Component({
  selector: 'app-dealer-list',
  templateUrl: './dealer-list.component.html',
  styleUrl: './dealer-list.component.scss'
})
export class DealerListComponent implements OnInit {

  ref: DynamicDialogRef | undefined;

  dealerList: DealerModel[];
  origin: string = "";
  destination: string = "";
  commodities: DropdownModel[] | undefined;
  selectedCommodity: DropdownModel | undefined;

  weightBreaks: DropdownModel[] | undefined;
  selectedWeightBreak: DropdownModel | undefined;




  constructor(private router: Router, public dialogService: DialogService) {
    this.dealerList = [
      {
        companyName: 'Turkish Airlines',
        opCarrier: 'Air Premia',
        airlinePrefixCode: 'TK-350',
        origin: 'ICN',
        destination: 'FRA',
        commodityCodes: 'GEN,VUN,PER',
        weightBreaks: '1000',
        ratePerKg: '1.00 $',
        interlineWeight: '10.000 kg',
        agreementType: 'Hard SPA',
        validFrom: '02-SEP-2024',
        validTo: '31-DEC-2024',
        contact: 'info@airpremia.com',
        status: 1
      },
      {
        companyName: 'Vietnam Airlines JSC',
        opCarrier: 'Turkish Airlines',
        airlinePrefixCode: 'VN-738',
        origin: 'HAN',
        destination: 'NRT',
        commodityCodes: 'GEN,VUN,PER',
        weightBreaks: '1000',
        ratePerKg: '1.10 $',
        interlineWeight: '20.000 kg',
        agreementType: 'Hard SPA',
        validFrom: '06-OCT-2024',
        validTo: '31-OCT-2024',
        contact: 'info@vietnamairlines.com',
        status: 2
      },
      {
        companyName: 'Nepal Airlines',
        opCarrier: 'Turkish Airlines',
        airlinePrefixCode: '285-RA',
        origin: 'KTM',
        destination: 'NRT',
        commodityCodes: 'GEN',
        weightBreaks: '1000',
        ratePerKg: '1.60 $',
        interlineWeight: '8.000 kg',
        agreementType: 'Soft SPA',
        validFrom: '02-OCT-2024',
        validTo: '13-DEC-2024',
        contact: 'info@nepalairlines.com',
        status: 1
      },
      {
        companyName: 'Turkish Airlines',
        opCarrier: 'Qatar Airways',
        airlinePrefixCode: '933-KZ',
        origin: 'IST',
        destination: 'SCL',
        commodityCodes: 'GEN',
        weightBreaks: '1000',
        ratePerKg: '3.00 $',
        interlineWeight: 'Subject to Space',
        agreementType: 'Soft SPA',
        validFrom: '06-OCT-2024',
        validTo: '31-OCT-2024',
        contact: 'info@qatarairways.com',
        status: 3
      },
      {
        companyName: 'Avianca Airlines',
        opCarrier: 'Turkish Airlines',
        airlinePrefixCode: '289-OM',
        origin: 'BOG',
        destination: 'LAX',
        commodityCodes: 'GEN',
        weightBreaks: '1000',
        ratePerKg: '1.40 $',
        interlineWeight: 'Subject to Space',
        agreementType: 'Soft SPA',
        validFrom: '17-SEP-2024',
        validTo: '27-OCT-2024',
        contact: 'info@avianca.com',
        status:3
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
        companyName: 'Turkish Airlines',
        opCarrier: 'Air Premia',
        airlinePrefixCode: 'TK-350',
        origin: 'ICN',
        destination: 'FRA',
        commodityCodes: 'GEN,VUN,PER',
        weightBreaks: '1000',
        ratePerKg: '1.00 $',
        interlineWeight: '10.000 kg',
        agreementType: 'Hard SPA',
        validFrom: '02-SEP-2024',
        validTo: '31-DEC-2024',
        contact: 'info@airpremia.com',
        status: 1
      },
      {
        companyName: 'Vietnam Airlines JSC',
        opCarrier: 'Turkish Airlines',
        airlinePrefixCode: 'VN-738',
        origin: 'HAN',
        destination: 'NRT',
        commodityCodes: 'GEN,VUN,PER',
        weightBreaks: '1000',
        ratePerKg: '1.10 $',
        interlineWeight: '20.000 kg',
        agreementType: 'Hard SPA',
        validFrom: '06-OCT-2024',
        validTo: '31-OCT-2024',
        contact: 'info@vietnamairlines.com',
        status: 2
      },
      {
        companyName: 'Nepal Airlines',
        opCarrier: 'Turkish Airlines',
        airlinePrefixCode: '285-RA',
        origin: 'KTM',
        destination: 'NRT',
        commodityCodes: 'GEN',
        weightBreaks: '1000',
        ratePerKg: '1.60 $',
        interlineWeight: '8.000 kg',
        agreementType: 'Soft SPA',
        validFrom: '02-OCT-2024',
        validTo: '13-DEC-2024',
        contact: 'info@nepalairlines.com',
        status: 1
      },
      {
        companyName: 'Turkish Airlines',
        opCarrier: 'Qatar Airways',
        airlinePrefixCode: '933-KZ',
        origin: 'IST',
        destination: 'SCL',
        commodityCodes: 'GEN',
        weightBreaks: '1000',
        ratePerKg: '3.00 $',
        interlineWeight: 'Subject to Space',
        agreementType: 'Soft SPA',
        validFrom: '06-OCT-2024',
        validTo: '31-OCT-2024',
        contact: 'info@qatarairways.com',
        status: 3
      },
      {
        companyName: 'Avianca Airlines',
        opCarrier: 'Turkish Airlines',
        airlinePrefixCode: '289-OM',
        origin: 'BOG',
        destination: 'LAX',
        commodityCodes: 'GEN',
        weightBreaks: '1000',
        ratePerKg: '1.40 $',
        interlineWeight: 'Subject to Space',
        agreementType: 'Soft SPA',
        validFrom: '17-SEP-2024',
        validTo: '27-OCT-2024',
        contact: 'info@avianca.com',
        status:3
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

  showAgreement() {
    this.ref = this.dialogService.open(AgreementConfirmComponent, { header: 'Agreement Confirmation'});
  }

  showSingleAgreement() {
    this.ref = this.dialogService.open(SignedAgrComponent, { header: 'Agreement Details'});
  }

}

interface DealerModel {
  companyName: string;
  opCarrier: string;
  airlinePrefixCode: string;
  origin: string;
  destination: string;
  commodityCodes: string;
  weightBreaks: string;
  ratePerKg: string;
  interlineWeight: string;
  agreementType: string;
  validFrom: string;
  validTo: string;
  contact: string;
  status: number;
}


interface DropdownModel {
  name: string;
  code: string;
}

interface UploadEvent {
  originalEvent: Event;
  files: File[];
}

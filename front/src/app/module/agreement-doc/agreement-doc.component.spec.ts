import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgreementDocComponent } from './agreement-doc.component';

describe('AgreementDocComponent', () => {
  let component: AgreementDocComponent;
  let fixture: ComponentFixture<AgreementDocComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AgreementDocComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgreementDocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SignedAgrComponent } from './signed-agr.component';

describe('SignedAgrComponent', () => {
  let component: SignedAgrComponent;
  let fixture: ComponentFixture<SignedAgrComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [SignedAgrComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SignedAgrComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

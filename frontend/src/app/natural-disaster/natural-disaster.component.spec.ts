import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NaturalDisasterComponent } from './natural-disaster.component';

describe('NaturalDisasterComponent', () => {
  let component: NaturalDisasterComponent;
  let fixture: ComponentFixture<NaturalDisasterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NaturalDisasterComponent]
    });
    fixture = TestBed.createComponent(NaturalDisasterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

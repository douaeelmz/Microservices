import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedingsFormComponent } from './needings-form.component';

describe('NeedingsFormComponent', () => {
  let component: NeedingsFormComponent;
  let fixture: ComponentFixture<NeedingsFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NeedingsFormComponent]
    });
    fixture = TestBed.createComponent(NeedingsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

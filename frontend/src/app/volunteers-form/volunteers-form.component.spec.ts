import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VolunteersFormComponent } from './volunteers-form.component';
import { ReactiveFormsModule } from '@angular/forms';

describe('VolunteersFormComponent', () => {
  let component: VolunteersFormComponent;
  let fixture: ComponentFixture<VolunteersFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [VolunteersFormComponent],
      imports: [ReactiveFormsModule], 
    });
    fixture = TestBed.createComponent(VolunteersFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

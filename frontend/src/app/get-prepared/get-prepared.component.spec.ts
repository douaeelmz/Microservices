import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetPreparedComponent } from './get-prepared.component';

describe('GetPreparedComponent', () => {
  let component: GetPreparedComponent;
  let fixture: ComponentFixture<GetPreparedComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GetPreparedComponent]
    });
    fixture = TestBed.createComponent(GetPreparedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

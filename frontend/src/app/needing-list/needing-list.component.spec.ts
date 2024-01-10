import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeedingListComponent } from './needing-list.component';

describe('NeedingListComponent', () => {
  let component: NeedingListComponent;
  let fixture: ComponentFixture<NeedingListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NeedingListComponent]
    });
    fixture = TestBed.createComponent(NeedingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

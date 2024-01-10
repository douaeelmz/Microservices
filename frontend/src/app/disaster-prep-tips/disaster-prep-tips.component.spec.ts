import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisasterPrepTipsComponent } from './disaster-prep-tips.component';

describe('DisasterPrepTipsComponent', () => {
  let component: DisasterPrepTipsComponent;
  let fixture: ComponentFixture<DisasterPrepTipsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisasterPrepTipsComponent]
    });
    fixture = TestBed.createComponent(DisasterPrepTipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

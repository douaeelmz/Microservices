import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisasterInstructionsComponent } from './disaster-instructions.component';

describe('DisasterInstructionsComponent', () => {
  let component: DisasterInstructionsComponent;
  let fixture: ComponentFixture<DisasterInstructionsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DisasterInstructionsComponent]
    });
    fixture = TestBed.createComponent(DisasterInstructionsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

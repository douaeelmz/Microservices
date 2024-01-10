import { TestBed } from '@angular/core/testing';

import { NeedingService } from './needing.service';

describe('NeedingService', () => {
  let service: NeedingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NeedingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

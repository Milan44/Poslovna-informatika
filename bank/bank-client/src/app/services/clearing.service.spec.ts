import { TestBed, inject } from '@angular/core/testing';

import { ClearingService } from './clearing.service';

describe('ClearingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ClearingService]
    });
  });

  it('should be created', inject([ClearingService], (service: ClearingService) => {
    expect(service).toBeTruthy();
  }));
});

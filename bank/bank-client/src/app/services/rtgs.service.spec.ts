import { TestBed, inject } from '@angular/core/testing';

import { RtgsService } from './rtgs.service';

describe('RtgsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RtgsService]
    });
  });

  it('should be created', inject([RtgsService], (service: RtgsService) => {
    expect(service).toBeTruthy();
  }));
});

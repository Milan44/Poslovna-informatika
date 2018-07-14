import { TestBed, inject } from '@angular/core/testing';

import { AnalyticsOfStatementsService } from './analytics-of-statements.service';

describe('AnalyticsOfStatementsService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AnalyticsOfStatementsService]
    });
  });

  it('should be created', inject([AnalyticsOfStatementsService], (service: AnalyticsOfStatementsService) => {
    expect(service).toBeTruthy();
  }));
});

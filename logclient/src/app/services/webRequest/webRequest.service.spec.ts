import { TestBed } from '@angular/core/testing';

import { WebRequestService } from './webRequest.service';

describe('WebRequestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: WebRequestService = TestBed.get(WebRequestService);
    expect(service).toBeTruthy();
  });
});

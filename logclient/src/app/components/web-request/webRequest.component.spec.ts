import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WebRequestComponent } from './webRequest.component';

describe('WebRequestComponent', () => {
  let component: WebRequestComponent;
  let fixture: ComponentFixture<WebRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [WebRequestComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WebRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

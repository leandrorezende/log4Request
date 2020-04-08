import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UploadWebrequestComponent } from './upload-webrequest.component';

describe('UploadWebrequestComponent', () => {
  let component: UploadWebrequestComponent;
  let fixture: ComponentFixture<UploadWebrequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UploadWebrequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UploadWebrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

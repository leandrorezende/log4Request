import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddWebRequestComponent } from './add-web-request.component';

describe('AddWebRequestComponent', () => {
  let component: AddWebRequestComponent;
  let fixture: ComponentFixture<AddWebRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AddWebRequestComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddWebRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

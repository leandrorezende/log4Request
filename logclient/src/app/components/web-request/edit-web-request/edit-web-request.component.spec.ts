import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditWebRequestComponent } from './edit-web-request.component';

describe('EditWebRequestComponent', () => {
  let component: EditWebRequestComponent;
  let fixture: ComponentFixture<EditWebRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [EditWebRequestComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditWebRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

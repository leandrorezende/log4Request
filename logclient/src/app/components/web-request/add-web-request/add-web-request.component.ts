import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { WebRequestService } from '../../../services/webRequest/webRequest.service';

@Component({
  selector: 'app-add-webRequest',
  templateUrl: './add-web-request.component.html'
})
export class AddWebRequestComponent implements OnInit {

  constructor(private formBuilder: FormBuilder, private router: Router, private _webRequestService: WebRequestService) { }

  addForm: FormGroup;

  ngOnInit() {
    this.addForm = this.formBuilder.group({
      id: [],
      data: ['', [Validators.required, Validators.pattern("^(?:[0-9]{4}-[0-9]{2}-[0-9]{2})?(?:[ T][0-9]{2}:[0-9]{2}:[0-9]{2})([.,][0-9]{3})$")]],
      ip: ['', [Validators.required, Validators.pattern("^([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})$")]],
      request: ['', [Validators.required, Validators.maxLength(255)]],
      status: ['', [Validators.required, Validators.min(100), Validators.max(599)]],
      userAgent: ['', [Validators.required, Validators.maxLength(255)]]
    });
  }

  onSubmit() {
    this._webRequestService.createWebRequest(this.addForm.value)
      .subscribe(resp => {
        this.router.navigate(['app-list-webRequest']);
      });
  }

  cancelOperation(): void {
    this.router.navigate(['app-list-webRequest']);
  };

}

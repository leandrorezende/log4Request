import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { first } from "rxjs/operators";
import { WebRequest } from "../../../model/webRequest.model";
import { WebRequestService } from "../../../services/webRequest/webRequest.service";

@Component({
  selector: 'app-edit-webRequest',
  templateUrl: './edit-web-request.component.html'
})
export class EditWebRequestComponent implements OnInit {
  webRequest: WebRequest;
  editForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private _webRequestService: WebRequestService) { }

  ngOnInit() {
    let userId = window.localStorage.getItem("editUserId");
    if (!userId) {
      alert("Invalid action.")
      this.router.navigate(['list-user']);
      return;
    }
    this.editForm = this.formBuilder.group({
      id: [''],
      data: ['', [Validators.required, Validators.pattern("^(?:[0-9]{4}-[0-9]{2}-[0-9]{2})?(?:[ T][0-9]{2}:[0-9]{2}:[0-9]{2})([.,][0-9]{3})$")]],
      ip: ['', [Validators.required, Validators.pattern("^([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})[.]([0-9]{1,3})$")]],
      request: ['', [Validators.required, Validators.maxLength(255)]],
      status: ['', [Validators.required, Validators.min(100), Validators.max(599)]],
      userAgent: ['', [Validators.required, Validators.maxLength(255)]]
    });
    this._webRequestService.getWebRequestById(+userId)
      .subscribe(data => {
        this.editForm.setValue(data);
      });
  }

  onSubmit() {
    this._webRequestService.updateWebRequest(this.editForm.value).pipe(first())
      .subscribe(resp => this.router.navigate(['app-list-webRequest']), error => alert(error));
  }

  cancelOperation(): void {
    this.router.navigate(['app-list-webRequest']);
  };

}
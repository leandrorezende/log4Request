import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { WebRequestService } from "../../../services/webRequest/webRequest.service";

@Component({
  selector: 'app-upload-webrequest',
  templateUrl: './upload-webrequest.component.html'
})
export class UploadWebrequestComponent implements OnInit {
  private batchFile = null;
  uploadBatchForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private _webRequestService: WebRequestService) { }

  ngOnInit() {
    this.uploadBatchForm = this.formBuilder.group({
      file: ['', Validators.required]
    });
  }

  onSubmit() {
    const formData = new FormData();
    formData.append('file', this.batchFile, this.batchFile.name);

    this._webRequestService.uploadBatckWebRequest(formData)
      .subscribe(
        data => {
          alert("Arquivo foi enviado com sucesso");
        },
        error => console.log(error)
      );
    this.uploadBatchForm.reset();
  }

  fileChange(event): void {
    const fileList: FileList = event.target.files;
    if (fileList.length > 0) {
      this.batchFile = fileList[0];
    }
    else {
      alert("Arquivo inválido");
    }
  }

  cancelOperation(): void {
    this.router.navigate(['app-list-webRequest']);
  }

}

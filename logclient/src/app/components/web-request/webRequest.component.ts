import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { FormBuilder, FormGroup } from "@angular/forms";
import { WebRequest } from "../../model/webRequest.model";
import { WebRequestService } from "../../services/webRequest/webRequest.service";

@Component({
  selector: "app-list-webRequest",
  templateUrl: "./webRequest.component.html"
})
export class WebRequestComponent implements OnInit {
  state = {
    webRequests: [],
    currentPage: 0,
    pageSize: 4,
    pages: []
  };
  searchForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private _webRequestService: WebRequestService) { }

  ngOnInit() {
    this.searchForm = this.formBuilder.group({
      ip: [],
      initialDate: [],
      finalDate: []
    });
    this.getTableData();
  }

  filterWebRequest(): void {
    this.getTableData();
  };

  deleteWebRequest(webRequest: WebRequest): void {
    this._webRequestService.deleteWebRequest(webRequest.id)
      .subscribe(data => {
        this.state.webRequests = this.state.webRequests.filter(wr => wr !== webRequest);
      })
  };

  editWebRequest(webRequest: WebRequest): void {
    window.localStorage.removeItem("editUserId");
    window.localStorage.setItem("editUserId", webRequest.id.toString());
    this.router.navigate(['app-edit-webRequest']);
  };

  addWebRequest(): void {
    this.router.navigate(['app-add-webRequest']);
  };

  hadlePageChange(page) {
    this.state.currentPage = page;
    this.getTableData();
  };

  uploadBatch(): void {
    this.router.navigate(['app-upload-webrequest']);
  };

  getTableData() {
    const { pageSize, currentPage } = this.state;
    var queryParams = `linesPerPage=${pageSize}&page=${currentPage}`;
    this._webRequestService
      .getWebRequestFilter(this.searchForm.value, queryParams)
      .subscribe(res => {
        this.state.webRequests = res.content;
        this.state.pages = Array.from(Array(res.totalPages).keys());
      }, err => console.log(err));
  }
}

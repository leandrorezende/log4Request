import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { WebRequest } from "../../model/webRequest.model";

@Injectable({
  providedIn: "root"
})
export class WebRequestService {
  private _webRequestUrl = "http://localhost:8080/webRequest/";

  constructor(private http: HttpClient) { }

  getWebRequest() {
    return this.http.get<any>(`${this._webRequestUrl}`);
  }

  getWebRequestFilter(webRequestFilter, queryParams: string) {
    return this.http.post<any>(`${this._webRequestUrl}page?${queryParams}`, webRequestFilter);
  }

  getWebRequestById(id: number) {
    return this.http.get<any>(`${this._webRequestUrl}${id}`);
  }

  createWebRequest(webRequest: WebRequest) {
    return this.http.post<any>(`${this._webRequestUrl}`, webRequest);
  }

  updateWebRequest(webRequest: WebRequest) {
    return this.http.put<any>(`${this._webRequestUrl}${webRequest.id}`, webRequest);
  }

  deleteWebRequest(id: number) {
    return this.http.delete<any>(`${this._webRequestUrl}${id}`);
  }

  uploadBatckWebRequest(file: FormData) {
    return this.http.post<any>(`${this._webRequestUrl}uploadFile`, file);
  }

}

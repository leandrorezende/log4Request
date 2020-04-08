import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { WebRequestComponent } from "./components/web-request/webRequest.component";
import { WebRequestService } from "./services/webRequest/webRequest.service";
import { AddWebRequestComponent } from './components/web-request/add-web-request/add-web-request.component';
import { EditWebRequestComponent } from './components/web-request/edit-web-request/edit-web-request.component';
import { ReactiveFormsModule } from "@angular/forms";
import { UploadWebrequestComponent } from './components/web-request/upload-webrequest/upload-webrequest.component';

@NgModule({
  declarations: [
    AppComponent,
    WebRequestComponent,
    AddWebRequestComponent,
    EditWebRequestComponent,
    UploadWebrequestComponent
  ],
  imports: [BrowserModule, FormsModule, AppRoutingModule, HttpClientModule,
    ReactiveFormsModule,],
  providers: [
    WebRequestService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

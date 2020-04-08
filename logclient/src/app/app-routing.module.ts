import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { WebRequestComponent } from "./components/web-request/webRequest.component";
import { AddWebRequestComponent } from './components/web-request/add-web-request/add-web-request.component';
import { EditWebRequestComponent } from './components/web-request/edit-web-request/edit-web-request.component';
import { UploadWebrequestComponent } from './components/web-request/upload-webrequest/upload-webrequest.component';

const routes: Routes = [
  {
    path: "",
    redirectTo: "/app-list-webRequest",
    pathMatch: "full"
  },
  { path: 'app-list-webRequest', component: WebRequestComponent },
  { path: 'app-add-webRequest', component: AddWebRequestComponent },
  { path: 'app-edit-webRequest', component: EditWebRequestComponent },
  { path: 'app-upload-webrequest', component: UploadWebrequestComponent },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

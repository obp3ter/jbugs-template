import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {BackendService} from "./services/backend.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule
  ],
  providers: [BackendService,HttpClient]
})
export class BackendModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {UserModule} from "./user/user.module";
import {BackendModule} from "./core/backend/backend.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    UserModule,
    BackendModule
  ],
  providers: [BackendModule],
  bootstrap: [AppComponent]
})
export class AppModule { }

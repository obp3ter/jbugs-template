import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserComponent} from "./components/user/user.component";
import {UserListComponent} from "./components/user-list/user-list.component";
import { JumperDirective } from './directives/jumper/jumper.directive';
import { HideCloseBugDirective } from './directives/hide button/hide-close-bug.directive';

@NgModule({
  declarations: [
    UserComponent,
    UserListComponent,
    JumperDirective,
    HideCloseBugDirective
  ],
  exports: [
    UserListComponent,
    JumperDirective,
    HideCloseBugDirective
  ],
  imports: [
    CommonModule
  ]
})
export class UserModule { }

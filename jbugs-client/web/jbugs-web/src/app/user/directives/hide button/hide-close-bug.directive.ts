import {AfterViewInit, Directive, ElementRef, Input} from '@angular/core';
import {Roles, User} from "../../models/user.model";

@Directive({
  selector: '[appHideCloseBug]'
})
export class HideCloseBugDirective implements AfterViewInit{
  @Input()
  user:User;

  constructor(private el:ElementRef) {

  }

  thing()
  {

  }

  ngAfterViewInit(): void {
    console.log(this.user);
    if(this.user.roles.indexOf(Roles.DELETE_BUG)==-1)
      this.el.nativeElement.disabled=true;
  }

}

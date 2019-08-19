import {AfterViewInit, Directive, ElementRef, Input} from '@angular/core';
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";

@Directive({
  selector: '[appHideCloseBug]'
})
export class HideCloseBugDirective implements AfterViewInit{
  @Input()
  user:User;

  constructor(private el:ElementRef, private userService:UserService) {

  }

  thing()
  {

  }

  ngAfterViewInit(): void {
    console.log(this.user);
    if(!this.userService.hasCloseBug(this.user))
      this.el.nativeElement.disabled=true;
  }

}

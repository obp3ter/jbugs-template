import {Directive, ElementRef, HostListener} from '@angular/core';

@Directive({
  selector: '[appJumper]'
})

export class JumperDirective {
  cp:boolean =true;

  @HostListener("mouseenter") onMouseEnter(){
    if(this.cp)
      this.el.nativeElement.style.float='right';
    else
      this.el.nativeElement.style.float='left';
      this.cp=!this.cp;
  }
  constructor(private el:ElementRef) { }

}

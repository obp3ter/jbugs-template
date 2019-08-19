import {Component, ViewChild} from '@angular/core';
import {Roles, User} from "./user/models/user.model";


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jbugs-web';

  @ViewChild('userList', {static:false})
  public userListComponentChild;

  public colors:string[]=[
    "red",
    "green",
    "blue",
    "yellow",
    "pink"
  ];
  subtitle: string = "OK!";


  allertc()
  {
    alert(this.userListComponentChild.colors[0])
  }

}

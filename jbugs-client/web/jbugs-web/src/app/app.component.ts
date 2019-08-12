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

  public users: User[] =
    [
      {
        firstName : "Péter",
        lastName : "Oprea-Benkő",
        age: 21,
        roles:[Roles.CREATE_BUG,Roles.EDIT_BUG,Roles.DELETE_BUG]
      },
      {
        firstName : "Batman",
        lastName : "",
        age : 57,
        roles:[]
      },
      {
        firstName : "John",
        lastName : "Smith",
        age : 45,
        roles:[]
      }
    ];
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

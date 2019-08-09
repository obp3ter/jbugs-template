import { Component } from '@angular/core';
import {User} from "./models/user.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'jbugs-web';
  public users: User[] =
    [
      {
        firstName : "Peter",
        lastName : "OB",
        age: 21
      },
      {
        firstName : "John",
        lastName : "Smith",
        age : 45
      }
    ]
}

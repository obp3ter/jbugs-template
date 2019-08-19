import {Component, Input, OnInit} from '@angular/core';
import {User} from "../../models/user.model";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  public userList: User[];

  @Input()
  public  colors: string[];
  showList: boolean = true;

  constructor(private userService:UserService) { }

  ngOnInit() {
    this.userService.getAllUsers().subscribe((ul) =>{
      this.userList=ul;
    })
  }

  alertUserFromList(user: User) {
    alert(user.firstName);
  }
}

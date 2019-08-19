import {Injectable} from '@angular/core';
import {Roles, User} from "../models/user.model";
import {Observable, of} from "rxjs";
import {delay} from "rxjs/operators";
import {BackendService} from "../../core/backend/services/backend.service";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private backendService:BackendService) { }

  hasCloseBug(user:User):boolean
  {

    if(user.roles === undefined || !user.roles )
      return false;
    console.log('thing',user.roles.indexOf(Roles.DELETE_BUG)!=-1)
    return user.roles.indexOf(Roles.DELETE_BUG)!=-1;
  }
  getAllUsers():Observable<User[]>
  {
    return this.backendService.get("http://localhost:8080/jbugs/services/users");
    // return of([{
    //   firstName : "Péter",
    //   lastName : "Oprea-Benkő",
    //   age: 21,
    //   roles:[Roles.CREATE_BUG,Roles.EDIT_BUG,Roles.DELETE_BUG]
    // },
    // {
    //   firstName : "Batman",
    //   lastName : "",
    //   age : 57,
    //   roles:[]
    // },
    // {
    //   firstName : "John",
    //   lastName : "Smith",
    //   age : 45,
    //   roles:[]
    // }]).pipe(delay(2000))
  }

}

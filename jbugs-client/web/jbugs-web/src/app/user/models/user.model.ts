export interface User {
  ID:number;
  counter:number;
  email:string;
  firstName:string;
  lastName:string;
  mobileNumber:string;
  password:string;
  status:number;
  username:string;
  roles?:Roles[];
}
export enum Roles {
  EDIT_BUG,
  CREATE_BUG,
  DELETE_BUG
}

export interface User {
  firstName:string;
  lastName:string;
  age:number;
  roles?:Roles[];
}
export enum Roles {
  EDIT_BUG,
  CREATE_BUG,
  DELETE_BUG
}

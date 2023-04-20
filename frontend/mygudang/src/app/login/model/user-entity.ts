/**
* author: AlexistDev
* github: https://github.com/alexistdev
* email: alexistdev@gmail.com
*/
export class UserEntity {
  userName: string;
  name: string | undefined;
  password: string | undefined;


  constructor(userName: string, name?: string) {
    this.userName = userName;
    this.name = name;
  }
}

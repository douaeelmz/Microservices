import { EventEmitter, Component, Output } from '@angular/core';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css'],
})
export class LoginFormComponent {

  @Output() onSubmitLoginEvent = new EventEmitter();
  @Output() onSubmitRegisterEvent = new EventEmitter();

  active: string = "login";
  firstName: string = "";
  lastName: string = "";
  login: string = "";
  password: string = "";
  email: string = "";
  role: UserRole = UserRole.VOLONTAIRE; 

  userRoles = Object.values(UserRole); 

  onLoginTab(): void {
    this.active = "login";
  }

  onRegisterTab(): void {
    this.active = "register";
  }

  onSubmitLogin(): void {
    this.onSubmitLoginEvent.emit({ "login": this.login, "password": this.password });
  }

  onSubmitRegister(): void {
    const defaultRole = UserRole.VOLONTAIRE; 

    const roleToSubmit = this.role !== null && this.role !== undefined ? this.role : defaultRole;
  
    this.onSubmitRegisterEvent.emit({
      "firstName": this.firstName,
      "lastName": this.lastName,
      "login": this.login,
      "password": this.password,
      "email": this.email,
      "role": roleToSubmit 
    });
  }
}

export enum UserRole {
  ADMIN = 'ADMIN',
  VOLONTAIRE = 'VOLONTAIRE',
  VICTIME = 'VICTIME'
}

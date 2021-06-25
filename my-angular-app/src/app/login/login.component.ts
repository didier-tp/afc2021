import { Component, OnInit } from '@angular/core';
import { Login } from '../common/data/login'
import { LoginResponse } from '../common/data/loginResponse';
import { LoginService } from '../common/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public login : Login = new Login("admin1","pwd1","admin");
  public message :string | undefined ;

  constructor(private _loginService : LoginService) { }

  public onLogin(){
     //this.message = "donnees saisies = " + JSON.stringify(this.login);
     this._loginService.postLogin$(this.login).subscribe({
      next: (loginResp : LoginResponse)=>{ 
        console.log(loginResp);
        this.message = loginResp.message;  
      },
      error: (err) => { console.log("error:"+err); this.message = "erreur appel WS login";}
   });
  }

  
  ngOnInit(): void {
  }

}

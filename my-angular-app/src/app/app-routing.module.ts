import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DeviseComponent } from './devise/devise.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  { path: 'ngr-welcome', component: WelcomeComponent },
  { path: '', redirectTo: '/ngr-welcome', pathMatch: 'full'},
  { path: 'ngr-devise', component: DeviseComponent },
  { path: 'ngr-login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

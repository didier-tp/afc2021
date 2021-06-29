import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminDeviseComponent } from './admin-devise/admin-devise.component';
import { BasicComponent } from './basic/basic.component';
import { DeviseComponent } from './devise/devise.component';
import { LoginComponent } from './login/login.component';
import { ModifDeviseComponent } from './modif-devise/modif-devise.component';
import { MyCalculatriceComponent } from './my-calculatrice/my-calculatrice.component';
import { WelcomeComponent } from './welcome/welcome.component';

const routes: Routes = [
  { path: 'ngr-welcome', component: WelcomeComponent },
  { path: '', redirectTo: '/ngr-welcome', pathMatch: 'full'},
  { path: 'ngr-devise', component: DeviseComponent },
  { path: 'ngr-modif-devise/:codeDevise', component: ModifDeviseComponent },
  { path: 'ngr-admin-devise', component: AdminDeviseComponent },
  { path: 'ngr-login', component: LoginComponent },
  { path: 'ngr-basic', component: BasicComponent },
  { path: 'ngr-my-calculatrice', component: MyCalculatriceComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

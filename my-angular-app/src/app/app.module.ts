import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MyHeaderComponent } from './my-header/my-header.component';
import { MyFooterComponent } from './my-footer/my-footer.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { DeviseComponent } from './devise/devise.component';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MyHeaderComponent,
    MyFooterComponent,
    WelcomeComponent,
    DeviseComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    TabsModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

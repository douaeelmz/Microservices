import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ButtonsComponent } from './buttons/buttons.component';
import { HeaderComponent } from './header/header.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { WelcomeContentComponent } from './welcome-content/welcome-content.component';
import { AuthContentComponent } from './auth-content/auth-content.component';
import { ContentComponent } from './content/content.component';

import { AxiosService } from './axios.service';
import { MapsComponent } from './maps/maps.component';
import { MapService } from './map.service';
import { NeedingsFormComponent } from './needings-form/needings-form.component';
import { VolunteersFormComponent } from './volunteers-form/volunteers-form.component';
import { DisasterInstructionsComponent } from './disaster-instructions/disaster-instructions.component';
import { FooterComponent } from './footer/footer.component';
import { GetPreparedComponent } from './get-prepared/get-prepared.component';
import { DisasterPrepTipsComponent } from './disaster-prep-tips/disaster-prep-tips.component';
import { NaturalDisasterComponent } from './natural-disaster/natural-disaster.component';

@NgModule({
  declarations: [
    AppComponent,
    ButtonsComponent,
    HeaderComponent,
    LoginFormComponent,
    WelcomeContentComponent,
    AuthContentComponent,
    ContentComponent,
    MapsComponent,
    NeedingsFormComponent,
    VolunteersFormComponent,
    DisasterInstructionsComponent,
    FooterComponent,
    GetPreparedComponent,
    DisasterPrepTipsComponent,
    NaturalDisasterComponent
  ],
  imports: [
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [AxiosService,MapService],
  bootstrap: [AppComponent]
})
export class AppModule { }

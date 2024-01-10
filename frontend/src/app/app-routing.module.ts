import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthContentComponent } from './auth-content/auth-content.component';
import { MapsComponent } from './maps/maps.component';
import { ContentComponent } from './content/content.component';
import { NeedingsFormComponent } from './needings-form/needings-form.component';
import { VolunteersFormComponent } from './volunteers-form/volunteers-form.component';
import { GetPreparedComponent } from './get-prepared/get-prepared.component';
import { DisasterPrepTipsComponent } from './disaster-prep-tips/disaster-prep-tips.component';
import {DisasterInstructionsComponent} from './disaster-instructions/disaster-instructions.component';
import {NaturalDisasterComponent} from './natural-disaster/natural-disaster.component';
import { NeedingListComponent } from './needing-list/needing-list.component';
import { VolunteersListComponent } from './volunteers-list/volunteers-list.component';

const routes: Routes = [
  //{ path: 'authenticated', component: AuthContentComponent },
  { path: 'get-prepared', component: GetPreparedComponent },
  { path: 'disaster-prep-tips', component: DisasterPrepTipsComponent },
  { path: 'natural-disaster', component: NaturalDisasterComponent },
  { path: 'instructions', component: DisasterInstructionsComponent },
  { path: 'needings-list', component: NeedingListComponent },
  { path: 'volunteers-list', component: VolunteersListComponent },
  { path: 'map', component: MapsComponent },
  { path: '', component: ContentComponent },
  { path: 'form', component: NeedingsFormComponent },
  { path: 'volunteer', component: VolunteersFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

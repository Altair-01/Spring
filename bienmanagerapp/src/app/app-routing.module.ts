import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BiensComponent } from './biens/biens.component';
import { AddBienComponent } from './add-bien/add-bien.component';
import { AddOwnerComponent } from './add-owner/add-owner.component';
import { OwnersComponent } from './owners/owners.component';



const routes : Routes = [
  { path: 'biens', component: BiensComponent },
  { path: 'owners', component: OwnersComponent },
  { path: 'addBien', component: AddBienComponent },
  { path: 'addOwner', component: AddOwnerComponent },
  { path: '', redirectTo: 'biens', pathMatch:'full'}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

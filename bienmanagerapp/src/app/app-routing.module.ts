import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BiensComponent } from './biens/biens.component';
import { AddBienComponent } from './add-bien/add-bien.component';
import { ListBienComponent } from './list-bien/list-bien.component';



const routes : Routes = [
  { path: 'biens', component: BiensComponent },
  { path: 'addBien', component: AddBienComponent },
  { path: 'listBien', component: ListBienComponent },
  { path: '', redirectTo: 'biens', pathMatch:'full'}

];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BienService } from './services/bien.service';
import { AddBienComponent } from './add-bien/add-bien.component';
import { BiensComponent } from './biens/biens.component';
import { FormsModule } from '@angular/forms';
import { OwnerService } from './services/owner.service';
import { AddOwnerComponent } from './add-owner/add-owner.component';
import { OwnersComponent } from './owners/owners.component';

@NgModule({
  declarations: [
    AppComponent,
    BiensComponent,
    AddBienComponent,
    BiensComponent,
    AddOwnerComponent,
    OwnersComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [BienService, OwnerService],
  bootstrap: [AppComponent]
})
export class AppModule { }

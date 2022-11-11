import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { BienService } from './list-bien/bien.service';
import { AddBienComponent } from './add-bien/add-bien.component';
import { BiensComponent } from './biens/biens.component';
import { ListBienComponent } from './list-bien/list-bien.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    BiensComponent,
    AddBienComponent,
    ListBienComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [BienService],
  bootstrap: [AppComponent]
})
export class AppModule { }

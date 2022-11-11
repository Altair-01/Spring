import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Bien } from '../model/bien.model';
import { BienService } from './bien.service';

@Component({
  selector: 'app-list-bien',
  templateUrl: './list-bien.component.html'
})
export class ListBienComponent implements OnInit {


    title='Angular-SpringBoot';
    public biens: Bien[] | any;
  
    
    constructor (private bienService: BienService) {}
  
    ngOnInit(): void {
        this.getBiens();
    }
  
      public getBiens(): void {
        this.bienService.getBiens().subscribe(
          (response:Bien[]) => {
            this.biens = response;
          },
          (error:HttpErrorResponse) => {
            alert(error.message)
          }
        )
      }
    }


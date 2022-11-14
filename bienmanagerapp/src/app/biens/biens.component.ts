import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Bien } from '../model/bien.model';
import { BienService } from '../services/bien.service';


@Component({
  selector: 'app-biens',
  templateUrl: './biens.component.html'
})
export class BiensComponent implements OnInit {



    title='liste des biens';
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

      public deleteBiens(bien: Bien):void{
        console.log(bien)
      }
    


}

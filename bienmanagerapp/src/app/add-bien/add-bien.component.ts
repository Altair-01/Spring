import { Component, OnInit } from '@angular/core';
import { BienService } from '../services/bien.service';
import { Bien } from '../model/bien.model';


@Component({
  selector: 'app-add-bien',
  templateUrl: './add-bien.component.html'
})
export class AddBienComponent implements OnInit {

  newBien = new Bien();
  message? : string;
  router: any;
  constructor (private bienService: BienService) {}

  ngOnInit(): void {
  }
  
  addBien(){
    //console.log(this.newBien);
    this.bienService.addBien(this.newBien).subscribe(newBien => {
      console.log(newBien)
    });
    this.router.navigate(['biens']);
    this.message = "Ajout réussi"
  }

}

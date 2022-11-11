import { Component, OnInit } from '@angular/core';
import { BienService } from '../list-bien/bien.service';
import { Bien } from '../model/bien.model';


@Component({
  selector: 'app-add-bien',
  templateUrl: './add-bien.component.html'
})
export class AddBienComponent implements OnInit {

  newBien = new Bien();
  constructor() { }

  ngOnInit(): void {
  }
  addBien(){
    console.log(this.newBien);
  }

}

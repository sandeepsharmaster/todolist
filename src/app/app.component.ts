import { Component } from '@angular/core';
import { MatListOption } from '@angular/material'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  items = [];
  emptyvalue = '';

  selectedOptions :string[];
  selectedOption;
  current_selected: string;
  handleClickAdd(value: string) {
    if(value) {
      this.items.push(value);
      
    }
  }

  handleDelete() {
    console.log(this.selectedOptions)
    this.selectedOptions.forEach(element => {
     console.log(element)
    });
  }

  onSelection(e, v){
    console.log(this.selectedOptions);
    //console.log(v)
    for(let a of v) {
      console.log(a.value);
      //let matlist :MatListOption = v;
      
    }
    //this.selectedOptions=selectedOptions;
  }
}

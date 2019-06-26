import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  items = [];
  selectedOptions :string[];
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
}

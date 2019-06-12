import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  items = [];

  selectedOptions: string[] = [];
  handleClickAdd(value: string) {
    if(value) {
      this.items.push(value);
      
    }
  }

  handleDelete() {
    this.selectedOptions.forEach(element => {
      this.items.pop(element);
    });
  }
}

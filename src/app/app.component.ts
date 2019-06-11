import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  items = [`First`, `Second`, `Third`, `Fourth`];
  title = 'todolist';
  value = '';

  handleClickAdd(value: string) {
    this.value=value;
    this.items.push(value);
  }
}

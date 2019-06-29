import { Component, OnInit } from '@angular/core';
import { ToDoListService } from 'src/service/todolist.service';
import { ToDoList } from 'src/types/todolist.type';
import { UserList } from 'src/types/userlist.type';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
  ngOnInit(): void {
    this.getToDoList();
  }
  userList : UserList[];
  items = [];
  selectedOptions :string[];

  constructor(private todolistservice : ToDoListService) { }

  handleClickAdd(value: string) {
    if(value) {
      this.items.push(value);
      
    }
  }

  handleDelete() {
    console.log(this.selectedOptions)
    this.selectedOptions.forEach(element => {
      this.userList = this.userList.filter(
        userlistObject => userlistObject.listItem === element);
     console.log(this.userList);
    });
  }

  getToDoList() {
    this.todolistservice.getListById().subscribe(userList => {
      console.log(userList)
      this.userList = userList;
      this.userList.forEach(
        element => {
          console.log(element.listItem);
          this.items.push(element.listItem);
        }
      );
  });


  }
}

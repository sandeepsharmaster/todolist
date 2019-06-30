import { Component, OnInit, OnChanges } from '@angular/core';
import { ToDoListService } from 'src/service/todolist.service';
import { UserList } from 'src/types/userlist.type';
import { Observable } from 'rxjs';

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

      const index: number = this.items.indexOf(element);
      if (index !== -1) {
          this.items.splice(index, 1);
      }   

      this.userList = this.userList.filter(
        userlistObject => userlistObject.listItem === element); 
     console.log(this.userList);
    });
    this.userList.forEach(userlistObject => {
      this.todolistservice.deleteListItem(userlistObject.id).subscribe();
    });
    this.ngOnInit();
  }

  getToDoList() {
    this.todolistservice.getListById().subscribe(userList => {
      console.log(userList)
      this.userList = userList;
      this.items = [];
      this.userList.forEach(
        element => {
          console.log(element.listItem);
          this.items.push(element.listItem);
        }
      );
  });
  }

  getUpdatedList() : Observable <any> {
  return new Observable(observer => {
  this.todolistservice.getListById().subscribe(userList => {
      console.log(userList)
      this.userList = userList;
      this.items = [];
      this.userList.forEach(
        element => {
          console.log(element.listItem);
          this.items.push(element.listItem);
        }
      );
      });
        observer.next(this.items);
      }
    );
  }
}

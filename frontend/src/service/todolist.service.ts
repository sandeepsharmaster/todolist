import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ToDoList } from 'src/types/todolist.type';

@Injectable()
export class ToDoListService {
    //static url for now
    url: string = 'http://localhost:8080/getList?listId=1';
    
    constructor(private http: HttpClient) { }

    public getListById(): Observable<ToDoList> {
        return this.http.get<ToDoList>(this.url);
  }
}
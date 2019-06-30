import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ToDoList } from 'src/types/todolist.type';
import { UserList } from 'src/types/userlist.type';

@Injectable()
export class ToDoListService {
    //static url for now
    url: string = 'http://localhost:8080/getList?listId=14';

    deleteUrl : string = `http://localhost:8080/deleteItem?itemid=`;
    
    constructor(private http: HttpClient) { }

    public getListById(): Observable<UserList[]> {
        return this.http.get<UserList[]>(this.url);
    }

    public deleteListItem(itemid: number) : Observable<any> {
        return this.http.delete(this.deleteUrl + itemid);
    }
}
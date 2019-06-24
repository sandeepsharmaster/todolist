package com.todolist.service;

import java.sql.SQLDataException;

import com.todolist.entity.ToDoList;
import com.todolist.entity.UserList;

public interface ListService {
	public void createToDoList(ToDoList toDoList);
	
	public void deleteList(Long id);
	
	public void deleteListItem(Long id);
	
	public void updateListItem(UserList userList) throws SQLDataException;
	
	public void addListItem(ToDoList todoList);
}

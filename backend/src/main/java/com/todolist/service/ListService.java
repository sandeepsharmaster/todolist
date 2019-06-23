package com.todolist.service;

import com.todolist.entity.ToDoList;

public interface ListService {
	public void createToDoList(ToDoList toDoList);
	
	public void deleteList(Long id);
	
	public void deleteListItem(Long id);
}

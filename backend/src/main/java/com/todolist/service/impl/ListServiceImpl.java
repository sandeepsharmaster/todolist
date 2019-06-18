package com.todolist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.todolist.entity.ToDoList;
import com.todolist.repository.ToDoListRepository;
import com.todolist.service.ListService;

public class ListServiceImpl implements ListService {

	@Autowired
	private ToDoListRepository toDoListRepository;
	
	@Override
	public void createToDoList(ToDoList toDoList) {
		toDoListRepository.save(toDoList);
	}

}

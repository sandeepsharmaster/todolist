package com.todolist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.ToDoList;
import com.todolist.repository.ToDoListRepository;
import com.todolist.service.ListService;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private ToDoListRepository toDoListRepository;

	@Override
	public void createToDoList(ToDoList toDoList) {
		toDoListRepository.save(toDoList);

	}

	@Override
	public void deleteList(Long id) {

		toDoListRepository.deleteById(id);
	}

}

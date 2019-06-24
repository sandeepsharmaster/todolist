package com.todolist.service.impl;

import java.sql.SQLDataException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.entity.ToDoList;
import com.todolist.entity.UserList;
import com.todolist.repository.ToDoListRepository;
import com.todolist.repository.UserListRepository;
import com.todolist.service.ListService;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	private ToDoListRepository toDoListRepository;

	@Autowired
	private UserListRepository userListRepository;

	@Override
	public void createToDoList(ToDoList toDoList) {
		toDoListRepository.save(toDoList);
	}

	@Override
	public void deleteList(Long id) {
		toDoListRepository.deleteById(id);
	}

	@Override
	public void deleteListItem(Long id) {
		userListRepository.deleteById(id);
	}

	@Override
	public void updateListItem(UserList userList) throws SQLDataException {
		Optional<UserList> findOption = userListRepository.findById(userList.getId());
		if (findOption.isPresent()) {
			userListRepository.save(userList);
		} else {
			throw new SQLDataException("List Item Does not Exist !!!");
		}
	}

	@Override
	public void addListItem(ToDoList todoList) {
		toDoListRepository.save(todoList);

	}

}

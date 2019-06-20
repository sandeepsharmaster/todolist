package com.todolist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.entity.ToDoList;
import com.todolist.entity.UserList;
import com.todolist.service.ListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "ToDoList")
public class ListController {
	
	@Autowired
	private ListService listService;

	@ApiOperation(value = "Create ToDo List")
	@PostMapping(value = "/createList")
	public ResponseEntity<String> registerUser(/* @RequestBody ToDoList toDoList */) {
		// Save details
		
		UserList userList = new UserList(null, "New Item");
		ArrayList al = new ArrayList();
		al.add(userList);
		ToDoList toDoList = new ToDoList(null, al);
		
		listService.createToDoList(toDoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value = "/delete")
	public ResponseEntity<String> testDelete() {
		
		listService.deleteList(1L);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

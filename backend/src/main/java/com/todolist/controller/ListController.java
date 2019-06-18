package com.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.entity.ToDoList;
import com.todolist.service.ListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "ToDoList", description = "Operations related to todolist service")
public class ListController {
	
	@Autowired
	private ListService listService;

	@ApiOperation(value = "Register new User")
	@PostMapping(value = "/createList")
	public ResponseEntity<String> registerUser(@RequestBody ToDoList toDoList) {
		// Save details
		listService.createToDoList(toDoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}

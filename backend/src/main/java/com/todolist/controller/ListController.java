package com.todolist.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		UserList userList = new UserList();
		userList.setListItem("This is item");
		userList.setListItem("This is item2");
		userList.setListItem("This is item3");
		userList.setListItem("This is item4");
		ArrayList<UserList> al = new ArrayList<UserList>();
		al.add(userList);
		
		ToDoList toDoList = new ToDoList();
		toDoList.setUserList(al);
		
		listService.createToDoList(toDoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deleteitem")
	public ResponseEntity<String> deleteItem(@RequestParam(name = "itemid") Long itemId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/deletelist")
	public ResponseEntity<String> deleteList(@RequestParam(name = "listid") Long listId) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}

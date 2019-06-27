package com.todolist.controller;

import java.sql.SQLDataException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.entity.ToDoList;
import com.todolist.entity.UserList;
import com.todolist.service.ListService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "ToDoList")
@CrossOrigin
public class ListController {

	@Autowired
	private ListService listService;

	@ApiOperation(value = "Create ToDo List")
	@PostMapping(value = "/createList")
	public ResponseEntity<String> registerUser(@RequestBody ToDoList toDoList) {
		listService.createToDoList(toDoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get list")
	@GetMapping(value = "/getList")
	public ResponseEntity<List<UserList>> getUserList(@RequestParam Long listId) {
		List<UserList> userlist= listService.getList(listId);
		return new ResponseEntity<List<UserList>>(userlist, HttpStatus.OK);
	}

	@ApiOperation(value = "Delete List Item")
	@DeleteMapping(value = "/deleteItem")
	public ResponseEntity<String> deleteItem(@RequestParam(name = "itemid") Long itemId) {
		listService.deleteListItem(itemId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Delete List")
	@DeleteMapping(value = "/deleteList")
	public ResponseEntity<String> deleteList(@RequestParam(name = "listid") Long listId) {
		listService.deleteList(listId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Update List Item")
	@PatchMapping(value = "/updateListItem")
	public ResponseEntity<String> updateListItem(@RequestBody UserList userList) throws SQLDataException {
		listService.updateListItem(userList);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@ApiOperation(value = "Add List Item")
	@PutMapping(value = "/addListItem")
	public ResponseEntity<String> addListItem(@RequestBody ToDoList todoList) {
		listService.addListItem(todoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
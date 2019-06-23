package com.todolist.controller;

import java.sql.SQLDataException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		UserList userList2 = new UserList();
		userList2.setListItem("This is item2");
		UserList userList3 = new UserList();
		userList3.setListItem("This is item3");
		UserList userList4 = new UserList();
		userList4.setListItem("This is item4");
		ArrayList<UserList> al = new ArrayList<UserList>();
		al.add(userList);
		al.add(userList2);
		al.add(userList3);
		al.add(userList4);
		
		ToDoList toDoList = new ToDoList();
		toDoList.setUserList(al);
		
		listService.createToDoList(toDoList);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete List Item")
	@DeleteMapping(value = "/deleteitem")
	public ResponseEntity<String> deleteItem(@RequestParam(name = "itemid") Long itemId) {
		listService.deleteListItem(itemId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete List")
	@DeleteMapping(value = "/deletelist")
	public ResponseEntity<String> deleteList(@RequestParam(name = "listid") Long listId) {
		listService.deleteList(listId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update List Item")
	@PatchMapping(value = "/updateListItem")
	public ResponseEntity<String> updateListItem() throws SQLDataException {
		UserList userList4 = new UserList();
		userList4.setId(8L);
		userList4.setListItem("item 2 modified");
		
		ArrayList<UserList> al = new ArrayList<UserList>();
		al.add(userList4);
		
		listService.updateListItem(userList4);
		
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
}

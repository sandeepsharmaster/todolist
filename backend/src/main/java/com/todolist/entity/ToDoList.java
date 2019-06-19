package com.todolist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ToDoList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public ToDoList() {
		
	}
	
	public ToDoList(Long id, List<UserList> userList) {
		this.id = id;
		this.userList=userList;
	}
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<UserList> userList;
	
}

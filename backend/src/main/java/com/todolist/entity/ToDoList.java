package com.todolist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ToDoList")
public class ToDoList {

	@Id
	@GeneratedValue
	private Long id;
	
	@Getter
	@Setter
	@OneToMany(cascade = CascadeType.ALL)
	private List<UserList> userList;
	
}

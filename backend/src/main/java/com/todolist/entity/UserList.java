package com.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "UserList")
public class UserList {

	@Id
	private Long id;
	
	@Getter
	@Setter
	private String listItem;
}

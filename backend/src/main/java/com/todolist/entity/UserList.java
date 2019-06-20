package com.todolist.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
public class UserList {

	protected UserList() {
		
	}
	
	public UserList(Long id, String listItem) {
		this.id = id;
		this.listItem = listItem;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todoList_id")
    private ToDoList todoList;
	
	@Getter
	@Setter
	private String listItem;
	
}

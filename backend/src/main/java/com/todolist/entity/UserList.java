package com.todolist.entity;

import javax.persistence.Column;
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
@Table(name = "userlist")
public class UserList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userlist_id")
	private Long id;


	/*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todolist_id", insertable = true)
    private ToDoList todoList;*/
	
	@Getter
	@Setter
	@Column(name = "listitem")
	private String listItem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getListItem() {
		return listItem;
	}

	public void setListItem(String listItem) {
		this.listItem = listItem;
	}
	
}

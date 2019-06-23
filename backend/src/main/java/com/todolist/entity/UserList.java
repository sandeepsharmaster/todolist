package com.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userlist")
public class UserList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userlist_id")
	private Long id;

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

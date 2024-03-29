package com.todolist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "todolist")
public class ToDoList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "todolist_id")
	private Long id;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "todolist_id", nullable = false, updatable = true)
	private List<UserList> userList;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<UserList> getUserList() {
		return userList;
	}

	public void setUserList(List<UserList> userList) {
		this.userList = userList;
	}

}

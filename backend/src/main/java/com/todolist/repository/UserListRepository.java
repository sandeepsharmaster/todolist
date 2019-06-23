package com.todolist.repository;

import org.springframework.data.repository.CrudRepository;

import com.todolist.entity.UserList;

public interface UserListRepository extends CrudRepository<UserList, Long> {
	
}

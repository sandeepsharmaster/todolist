package com.todolist.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.todolist.entity.ToDoList;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {
	
	String jpql_deleteById = "delete from to_do_list td where td.id = :id";
	
	@Modifying
	@Query(value = jpql_deleteById, nativeQuery = true)
	void deleteById(@Param("id") Long id);
}

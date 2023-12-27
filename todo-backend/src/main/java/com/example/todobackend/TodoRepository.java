package com.example.todobackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

	public interface TodoRepository extends JpaRepository<Todo, Long> {
	    Todo findByName(String name);
	}

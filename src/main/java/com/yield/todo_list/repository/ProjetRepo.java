package com.yield.todo_list.repository;

import com.yield.todo_list.entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetRepo extends JpaRepository<Projet, Long> {
}

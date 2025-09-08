package com.yield.todo_list.repository;

import com.yield.todo_list.entity.Tache;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TacheRepo extends JpaRepository<Tache, Long> {
}

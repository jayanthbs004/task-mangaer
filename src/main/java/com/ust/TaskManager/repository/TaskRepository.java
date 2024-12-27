package com.ust.TaskManager.repository;

import com.ust.TaskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

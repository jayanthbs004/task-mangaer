package com.ust.TaskManager.service;

import com.ust.TaskManager.dto.TaskDTO;
import com.ust.TaskManager.entity.Task;
import com.ust.TaskManager.exception.TaskNotFoundException;
import com.ust.TaskManager.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        Task savedTask = taskRepository.save(task);
        TaskDTO savedDTO = new TaskDTO();
        BeanUtils.copyProperties(savedTask, savedDTO);
        return savedDTO;
    }

    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));

        BeanUtils.copyProperties(taskDTO, existingTask);
        existingTask.setId(id);
        Task updatedTask = taskRepository.save(existingTask);

        TaskDTO updatedDTO = new TaskDTO();
        BeanUtils.copyProperties(updatedTask, updatedDTO);
        return updatedDTO;
    }

    public List<TaskDTO> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> {
                    TaskDTO dto = new TaskDTO();
                    BeanUtils.copyProperties(task, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public TaskDTO getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        TaskDTO dto = new TaskDTO();
        BeanUtils.copyProperties(task, dto);
        return dto;
    }

    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        taskRepository.deleteById(id);
    }
}

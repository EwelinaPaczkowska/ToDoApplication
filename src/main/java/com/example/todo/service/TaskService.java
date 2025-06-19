package com.example.todo.service;

import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }

    public void deleteAllTasks(){
        taskRepository.deleteAll();
    }

    public Task updateTask(Long id, Task updatedtask){
        Task task = taskRepository.findById(id).
                orElseThrow(()-> new NoSuchElementException("Task not found"));

        task.setTitle(updatedtask.getTitle());
        task.setCompleted(updatedtask.isCompleted());
        return taskRepository.save(task);
    }

    //public Task findTaskById(Long id){}
}

package com.app.todoapp.services;


import com.app.todoapp.model.Task;
import com.app.todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TaskServices {



    private final TaskRepository taskRepository;

    public TaskServices(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTask(Model model){
        return taskRepository.findAll();
    }

    public void createTask(String title){
        Task task=new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id){
        Task task=taskRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid Task ID"));
        task.setCompleted(!task.isCompleted());
        taskRepository.save(task);
    }

}

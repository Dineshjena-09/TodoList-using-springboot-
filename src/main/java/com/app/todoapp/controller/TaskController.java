package com.app.todoapp.controller;


import com.app.todoapp.model.Task;
import com.app.todoapp.services.TaskServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//@RequestMapping("/tasks")
public class TaskController {

    private final TaskServices taskservice;

    public TaskController(TaskServices taskService){
        this.taskservice=taskService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks=taskservice.getAllTask(model);
        model.addAttribute("tasks",tasks);
        return "tasks";
    }
    @PostMapping
    public String createTask(String title){
        taskservice.createTask(title);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskservice.deleteTask(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskservice.toggleTask(id);
        return "redirect:/";
    }
}

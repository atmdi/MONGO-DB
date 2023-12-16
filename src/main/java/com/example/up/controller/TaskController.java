package com.example.up.controller;

import com.example.up.model.Task;
import com.example.up.service.TaskService;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import jakarta.persistence.Embeddable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;
    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        List<Task> taskList=this.taskService.findAll();
        return  ResponseEntity.ok(taskList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable("id") String id){
        Task taskbyId = taskService.findById(id);
        if (taskbyId==null)
        {
            return ResponseEntity.badRequest().body("task ID is not valid");
        }
        return ResponseEntity.ok(taskbyId);

    }

    @PostMapping("/save")
    public ResponseEntity creatTask(@RequestBody Task task){
        Task creatTask = taskService.createTask(task);
        return creatTask==null ? ResponseEntity.badRequest().body("need a title"):
                ResponseEntity.ok(creatTask);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTask(@PathVariable("id") String id){
        String deleteTaskById = taskService.deleteTaskById(id);
        return deleteTaskById==null? ResponseEntity.badRequest().body("wrong task id"):
                ResponseEntity.ok(deleteTaskById);
    }
//    @PutMapping("/update")
//    public ResponseEntity updateTask(@RequestBody Task task){
//        Task updateTask = taskService.updateTask(task);
//        return updateTask==null? ResponseEntity.badRequest().body("wrong task update"):
//                ResponseEntity.ok(updateTask);
//    }
}

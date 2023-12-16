package com.example.up;

import com.example.up.model.Task;
import com.example.up.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class UpApplication implements CommandLineRunner {
    @Autowired TaskService taskService;
    public static void main(String[] args) {
        SpringApplication.run(UpApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        Task t1=new Task();
//        t1.setDone(false);
//        t1.setTitle("sport");
//
//        Task t2=new Task();
//        t2.setTitle("study");
//        t2.setDone(true);
//
//        taskService.createTask(t1);
//        taskService.createTask(t2);

    }
}


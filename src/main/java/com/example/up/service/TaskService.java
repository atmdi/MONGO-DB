package com.example.up.service;

import com.example.up.model.Task;
import com.example.up.repositoris.TaskRepository;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(String id) {
        Optional<Task> taskbyId = taskRepository.findById(id);
        return taskbyId.isPresent() ? taskbyId.get() : null;
    }

    public String deleteTaskById(String id) {
        if (!taskRepository.existsById(id)) {
            return null;
        }
        taskRepository.deleteById(id);
        return id;
    }

    public Task createTask(Task task) {
        if (task.getTitle() == null) {
            return null;
        }

        if (task.getDone() == null) {
            task.setDone(false);
        }

        return taskRepository.save(task);
    }

}

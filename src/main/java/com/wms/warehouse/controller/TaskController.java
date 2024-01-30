package com.wms.warehouse.controller;

import com.wms.warehouse.entity.TaskEntity;
import com.wms.warehouse.service.TaskService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "TaskController")
public class TaskController {

    private final TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/task")
    public ResponseEntity createTask (@RequestParam String content) throws ParseException {
        TaskEntity task = taskService.getTimeintext(content);
        if (task == null) {
            return new ResponseEntity("Null content please input again", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(task, HttpStatus.CREATED);
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskEntity>> getListTask() {
        return new ResponseEntity<>(taskService.getAllTask(),HttpStatus.OK);
    }
    @DeleteMapping("/task/{id}")
    public ResponseEntity deleteTask(@PathVariable String id) {
        if (taskService.deleteTask(id)) return new ResponseEntity<>("Delete Success",HttpStatus.OK);
        return new ResponseEntity<>("Not found Task id:" + id,HttpStatus.NOT_FOUND);
    }
}

package com.application.SpringBootRestProjectManagement.controllers;

import com.application.SpringBootRestProjectManagement.controllers.DTO.TaskDTO;
import com.application.SpringBootRestProjectManagement.entities.Task;
import com.application.SpringBootRestProjectManagement.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Task> optionalTask = taskService.findByID(id);
        if(optionalTask.isPresent()){
            Task task = optionalTask.get();
            TaskDTO taskDTO = TaskDTO.builder()
                    .id(task.getId())
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .assignedTo(task.getAssignedTo())
                    .project(task.getProject())
                    .commentList(task.getCommentList())
                    .build();

            return  ResponseEntity.ok(taskDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<TaskDTO> taskDTOList = taskService.findAll().stream().map(
                task -> TaskDTO.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .dueDate(task.getDueDate())
                        .assignedTo(task.getAssignedTo())
                        .project(task.getProject())
                        .commentList(task.getCommentList())
                        .build()
        ).toList();
        return ResponseEntity.ok(taskDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody TaskDTO taskDTO )throws URISyntaxException {

        if(taskDTO.getTitle().isBlank() || taskDTO.getDescription().isBlank() || taskDTO.getDueDate().isBlank() || taskDTO.getAssignedTo()==null){
            return ResponseEntity.badRequest().build();
        }

        Task task = Task.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .dueDate(taskDTO.getDueDate())
                .assignedTo(taskDTO.getAssignedTo())
                .project(taskDTO.getProject())
                .build();
        taskService.save(task);
        return ResponseEntity.created(new URI("/api/task/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody TaskDTO taskDTO){

        Optional<Task> optionalTask = taskService.findByID(id);

        if(optionalTask.isPresent()){
            Task task = optionalTask.get();

            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            task.setAssignedTo(taskDTO.getAssignedTo());
            task.setDueDate(taskDTO.getDueDate());
            task.setProject(taskDTO.getProject());

            taskService.save(task);
            return ResponseEntity.ok("Actualizado Correctamente");
        }


        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id!=null){
            taskService.deleteById(id);
            return ResponseEntity.ok("Eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}

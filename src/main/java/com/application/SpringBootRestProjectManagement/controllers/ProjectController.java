package com.application.SpringBootRestProjectManagement.controllers;



import com.application.SpringBootRestProjectManagement.controllers.DTO.ProjectDTO;

import com.application.SpringBootRestProjectManagement.entities.Project;
import com.application.SpringBootRestProjectManagement.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/project")
public class ProjectController {


    @Autowired
    private IProjectService projectService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Project> projectOptional = projectService.findById(id);
        if(projectOptional.isPresent()){
            Project project = projectOptional.get();

            ProjectDTO projectDTO = ProjectDTO.builder()
                    .id(project.getId())
                    .name(project.getName())
                    .description(project.getDescription())
                    .ownerId(project.getOwnerId())
                    .taskList(project.getTaskList())
                    .build();

            return ResponseEntity.ok(projectDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<ProjectDTO> projectDTOList = projectService.findAll().stream()
                .map(project -> ProjectDTO.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .description(project.getDescription())
                        .ownerId(project.getOwnerId())
                        .taskList(project.getTaskList())
                        .build()
                ).toList();


        return ResponseEntity.ok(projectDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProjectDTO projectDTO) throws URISyntaxException {
        if(projectDTO.getName().isBlank() || projectDTO.getDescription().isBlank() || projectDTO.getOwnerId()==null){
            return ResponseEntity.badRequest().build();
        }


        Project project = Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .ownerId(projectDTO.getOwnerId())
                .build();
        projectService.save(project);
        return ResponseEntity.created(new URI("/api/project/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody ProjectDTO projectDTO){

        Optional<Project> projectOptional = projectService.findById(id);

        if(projectOptional.isPresent()){
            Project project = projectOptional.get();

            project.setName(projectDTO.getName());
            project.setDescription(projectDTO.getDescription());
            project.setOwnerId(projectDTO.getOwnerId());

            projectService.save(project);

            return ResponseEntity.ok("Actualizado Correctamente");

        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        if(id!=null){
            projectService.deleteById(id);
            return ResponseEntity.ok("Eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}

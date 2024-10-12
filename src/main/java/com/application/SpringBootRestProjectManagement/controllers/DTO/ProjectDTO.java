package com.application.SpringBootRestProjectManagement.controllers.DTO;


import com.application.SpringBootRestProjectManagement.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Long ownerId;
    private List<Task> taskList = new ArrayList<>();
}

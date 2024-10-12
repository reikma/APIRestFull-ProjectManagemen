package com.application.SpringBootRestProjectManagement.controllers.DTO;

import com.application.SpringBootRestProjectManagement.entities.Comment;
import com.application.SpringBootRestProjectManagement.entities.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private String dueDate;
    private Long assignedTo;
    private Project project;
    private List<Comment> commentList = new ArrayList<>();
}

package com.application.SpringBootRestProjectManagement.controllers.DTO;

import com.application.SpringBootRestProjectManagement.entities.Task;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {

    private Long id;
    private Long userId;
    private String content;
    private Task task;
}

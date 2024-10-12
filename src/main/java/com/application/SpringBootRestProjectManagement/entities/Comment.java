package com.application.SpringBootRestProjectManagement.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comentarios")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String content;

    @ManyToOne
    @JoinColumn(name = "task_id",nullable = false)
    @JsonIgnore
    private Task task;
}

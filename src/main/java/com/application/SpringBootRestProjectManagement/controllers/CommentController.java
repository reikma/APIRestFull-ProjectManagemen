package com.application.SpringBootRestProjectManagement.controllers;


import com.application.SpringBootRestProjectManagement.controllers.DTO.CommentDTO;
import com.application.SpringBootRestProjectManagement.entities.Comment;
import com.application.SpringBootRestProjectManagement.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<Comment> optionalComment=commentService.findById(id);
        if(optionalComment.isPresent()){
            Comment comment= optionalComment.get();

            CommentDTO commentDTO= CommentDTO.builder()
                    .id(comment.getId())
                    .userId(comment.getUserId())
                    .content(comment.getContent())
                    .task(comment.getTask())
                    .build();
            return ResponseEntity.ok(commentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<CommentDTO> commentDTOList = commentService.findAll().stream()
                .map(comment -> CommentDTO.builder()
                        .id(comment.getId())
                        .userId(comment.getUserId())
                        .content(comment.getContent())
                        .task(comment.getTask())
                        .build())
                .toList();
        return ResponseEntity.ok(commentDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody CommentDTO commentDTO) throws URISyntaxException {

        if(commentDTO.getContent().isBlank() || commentDTO.getUserId()==null){
            return ResponseEntity.badRequest().build();
        }

        Comment comment = Comment.builder()
                .userId(commentDTO.getUserId())
                .content(commentDTO.getContent())
                .task(commentDTO.getTask())
                .build();
        commentService.save(comment);

        return ResponseEntity.created(new URI("/api/comment/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@RequestBody CommentDTO commentDTO){
        Optional<Comment> optionalComment = commentService.findById(id);

        if(optionalComment.isPresent()){
            Comment comment = optionalComment.get();
            comment.setUserId(commentDTO.getUserId());
            comment.setContent(commentDTO.getContent());
            comment.setTask(commentDTO.getTask());

            return ResponseEntity.ok("Actualizado Correctamente");
        }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id !=null){
            commentService.deleteById(id);
            return ResponseEntity.ok("Eliminado Correctamente");
        }
        return ResponseEntity.badRequest().build();
    }
}

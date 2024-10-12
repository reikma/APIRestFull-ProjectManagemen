package com.application.SpringBootRestProjectManagement.controllers;


import com.application.SpringBootRestProjectManagement.controllers.DTO.UserDTO;
import com.application.SpringBootRestProjectManagement.entities.User;
import com.application.SpringBootRestProjectManagement.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private IUserService userService;


    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){

        Optional<User> optionalUser = userService.findById(id);

        if(optionalUser.isPresent()){

            User user = optionalUser.get();

            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .password(user.getPassword())
                    .build();


            return ResponseEntity.ok(userDTO);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<UserDTO> userDTOList = userService.findAll().stream()
                .map(user -> UserDTO.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build()
                ).toList();

        return ResponseEntity.ok(userDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserDTO userDTO) throws URISyntaxException {

        if(userDTO.getUsername().isBlank() || userDTO.getPassword().isBlank() || userDTO.getEmail().isBlank()){
            return ResponseEntity.badRequest().build();
        }

        User user = User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .build();


        userService.save(user);
        return ResponseEntity.created(new URI("/api/user/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO, @PathVariable Long id){

        Optional<User> optionalUser= userService.findById(id);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();

            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());

            userService.save(user);

            return ResponseEntity.ok("Registro Actualizado");
        }


        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {

        if(id!=null){
            userService.deleteById(id);
            return ResponseEntity.ok("Eliminado Correctamente");

        }

        return ResponseEntity.badRequest().build();
    }
}

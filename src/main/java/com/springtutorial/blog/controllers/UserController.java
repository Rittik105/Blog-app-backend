package com.springtutorial.blog.controllers;

import com.springtutorial.blog.payloads.ApiResponse;
import com.springtutorial.blog.payloads.UserDto;
import com.springtutorial.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    //POST - Create a new User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto createdUserDto = userService.createUser(userDto);

        return new ResponseEntity<>(createdUserDto, HttpStatus.CREATED);
    }

    //PUT - Update a User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
        UserDto updatedUserDto = this.userService.updateUser(userDto, userId);

        return ResponseEntity.ok(updatedUserDto);
    }

    //DELETE - Delete a User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
        this.userService.deleteUser(userId);

        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
    }

    //GET - Get list of all users
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = this.userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

    //GET - Get particular user using id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
        UserDto fetchedUserDto = this.userService.getUserById(userId);

        return ResponseEntity.ok(fetchedUserDto);
    }

}

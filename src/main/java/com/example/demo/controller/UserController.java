
package com.example.demo.controller;


import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.exception.BadRequestException;


  @RestController
@RequestMapping("/api/v1")  // End Point URL: http://localhost:8080/api/v1/users

public class UserController {

  @Autowired
  private UserRepository userRepository;
  /**
   * Get all users list.
   *
   * @return the list
   */
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }
  /**
   * Gets users by id.
   *
   * @param userId the user id
   * @return the users by id
   * @throws ResourceNotFoundException the resource not found exception
   */
  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }
  

  /**
   * Create user user.
   */
    @PostMapping("/users")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }
  


  /**
   * Update user response entity.
   *
   * @param userId the user id
   * @param userDetails the user details
   * @return the response entity
   * @throws ResourceNotFoundException the resource not found exception
   */
  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId, @Valid @RequestBody User userDetails)
      throws ResourceNotFoundException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
    user.setUpdatedAt(new Date());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }
  /**
   * Delete user map.
   *
   * @param userId the user id
   * @return the map
   * @throws Exception the exception
   */
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
// ====================   Below Cutom Methods ========================

@GetMapping("/users/lastNames/{lastName}")
public List<User> getUsersByLastName(@PathVariable(value = "lastName") String lastName){
    return userRepository.findByLastNameIgnoreCase(lastName)  ;        
}

// Below using Create Query Method - Not Query Annotation

@GetMapping("/users/firstNames/{firstName}/lastNames/{lastName}")
public List<User> getUsersByFirstAndLastName(@PathVariable(value = "firstName") String firstName, @PathVariable(value = "lastName") String lastName){
    return userRepository.findByFirstNameAndLastNameIgnoreCase(firstName, lastName);        
}

// Below using Create Query Method - Not Query Annotation
@GetMapping("/users/firstNames/{firstName}")
public List<User> getUsersByFirstName(@PathVariable(value = "firstName") String firstName){
    return userRepository.findByFirstNameIgnoreCase(firstName);        
}


}
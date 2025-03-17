package com.channy.pattern.controller;

import com.channy.pattern.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/{id}")
  public String getUser(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  public String updateUser(@PathVariable Long id, @RequestParam String name) {
    return userService.updateUser(id, name);
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return "User removed from cache!";
  }
}

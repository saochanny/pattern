package com.channy.pattern.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

  @Cacheable(value = "users", key = "#id")
  public String getUserById(Long id) {
    log.info("Fetching user from database..."); // Simulate DB fetch
    return "User-" + id;
  }

  @CachePut(value = "users", key = "#id")
  public String updateUser(Long id, String newUser) {
    log.info("Updating user in database...");
    return newUser;
  }

  @CacheEvict(value = "users", key = "#id")
  public void deleteUser(Long id) {
    log.info("Removing user from cache...");
  }
}

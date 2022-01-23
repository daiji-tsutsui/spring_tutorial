package com.example.restservice;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.restservice.repository.UserRepository;
import com.example.restservice.domain.User;

@RestController
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired UserRepository repo;

  @RequestMapping(path="/users", method=RequestMethod.GET)
  public List<User> index() {
    logger.info("Called users index");
    return repo.getUsers();
  }

  @RequestMapping(path="/users/{id}", method=RequestMethod.GET)
  public User show(@PathVariable int id) {
    return repo.getUserById(id);
  }

  @RequestMapping(path="/users", method=RequestMethod.POST)
  public User create(
    @RequestParam(value = "name", defaultValue = "") String name,
    @RequestParam(value = "password", defaultValue = "") String password
  ) {
    return repo.getUserById(1);
  }
}

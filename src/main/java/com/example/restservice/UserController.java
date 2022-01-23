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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.restservice.repository.UserRepository;
import com.example.restservice.domain.User;
import com.example.restservice.dto.request.UserRequest;

@RestController
public class UserController {

  private static final Logger logger = LoggerFactory.getLogger(UserController.class);

  @Autowired UserRepository dao;

  @RequestMapping(path="/users", method=RequestMethod.GET)
  public List<User> index() {
    // logger.info("Called users index");
    return dao.findUsers();
  }

  @RequestMapping(path="/users/{id}", method=RequestMethod.GET)
  public User show(@PathVariable Integer id) {
    return dao.findUserById(id);
  }

  @RequestMapping(path="/users", method=RequestMethod.POST)
  public User create(@RequestBody UserRequest req) {
    User user = new User(null, req.getName(), req.getPassword());
    return dao.save(user);
  }
}

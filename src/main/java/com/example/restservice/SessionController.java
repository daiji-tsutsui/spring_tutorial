package com.example.restservice;

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

import com.example.restservice.repository.SessionRepository;
import com.example.restservice.domain.Session;
import com.example.restservice.dto.request.SessionRequest;
import com.example.restservice.repository.UserRepository;
import com.example.restservice.domain.User;
import com.example.restservice.dto.request.UserRequest;

@RestController
public class SessionController {

  private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

  @Autowired SessionRepository dao;
  @Autowired UserRepository userDao;

  @RequestMapping(path="/sessions", method=RequestMethod.GET)
  public List<Session> index() {
    return dao.findSessions();
  }

  @RequestMapping(path="/login", method=RequestMethod.POST)
  public Session login(@RequestBody UserRequest req) {
    String name = req.getName();
    String password = req.getPassword();
    Integer userId = userDao.getIdByNameAndPassword(name, password);
    if (userId != null) {
      logger.info("Got UserId: " + userId.toString());
      Session session = new Session(null, null, userId, null);
      return dao.save(session);
    } else {
      logger.error("No users with name: " + name + ", password: " + password);
    }
    return null;
  }

  @RequestMapping(path="/logout", method=RequestMethod.DELETE)
  public User logout(@RequestBody SessionRequest req) {
    Session session = dao.findSessionByToken(req.getToken());
    User user = userDao.findUserById(session.getUserId());
    dao.delete(session);
    return user;
  }

  // @RequestMapping(path="/auth", method=RequestMethod.GET)
  // public User authGet(@PathVariable String token) {
  //   Session session = dao.findSessionByToken(token);
  //   User user = dao.findUserById(session.getUserId());
  //   return user;
  // }

  // @RequestMapping(path="/auth", method=RequestMethod.POST)
  // public User authPost(@RequestBody SessionRequest req) {
  //   Session session = dao.findSessionByToken(req.getToken());
  //   User user = dao.findUserById(session.getUserId());
  //   return user;
  // }
}

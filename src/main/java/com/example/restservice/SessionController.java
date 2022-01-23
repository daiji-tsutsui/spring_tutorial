package com.example.restservice;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
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
import com.example.restservice.dto.request.UserRequest;

@RestController
public class SessionController {

  // private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

  @Autowired SessionRepository dao;

  @RequestMapping(path="/sessions", method=RequestMethod.GET)
  public List<Session> index() {
    return dao.findSessions();
  }

  // @RequestMapping(path="/login", method=RequestMethod.POST)
  // public Session login(@RequestBody UserRequest req) {
  //   return;
  // }

  // @RequestMapping(path="/logout", method=RequestMethod.DELETE)
  // public Session logout(@RequestBody SessionRequest req) {
  //   return;
  // }

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

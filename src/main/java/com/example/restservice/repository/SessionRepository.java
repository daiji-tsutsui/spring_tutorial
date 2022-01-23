package com.example.restservice.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.restservice.domain.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, String> {

    // 全セッションを取得
    @Query("SELECT * FROM sessions ORDER BY id ASC")
    List<Session> findSessions();

    // tokenで指定したセッションのIDを取得
    @Query("SELECT * FROM sessions WHERE token = :token")
    Session findSessionByToken(String token);

}

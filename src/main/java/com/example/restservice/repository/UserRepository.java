package com.example.restservice.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.restservice.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    // 全ユーザーを取得
    @Query("SELECT * FROM users ORDER BY id ASC")
    List<User> findUsers();

    // idで指定したユーザーを取得
    @Query("SELECT * FROM users WHERE id = :id")
    User findUserById(Integer id);

    // 名前とパスワードからユーザーIDを取得
    @Query("SELECT id FROM users WHERE name = :name AND password = :password")
    Integer getIdByNameAndPassword(String name, String password);
}

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
    List<User> getUsers();

    // idで指定したユーザーを取得
    @Query("SELECT * FROM users WHERE id = :id")
    User getUserById(int id);

}

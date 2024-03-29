package com.example.springjpahibernateexample.repository;

import com.example.springjpahibernateexample.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Integer> {

        Optional<List<Users>>findByName(String name);


}

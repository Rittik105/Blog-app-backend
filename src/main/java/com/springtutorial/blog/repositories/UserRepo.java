package com.springtutorial.blog.repositories;

import com.springtutorial.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}

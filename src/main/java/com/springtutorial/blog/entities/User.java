package com.springtutorial.blog.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", nullable = false, length = 30)
    private String name;

    @Column(nullable = true, length = 30)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true, length = 300)
    private String about;

}

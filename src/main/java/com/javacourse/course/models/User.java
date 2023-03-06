package com.javacourse.course.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ToString @EqualsAndHashCode
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    @Id
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String name;

    @Getter @Setter @Column(name = "last_name")
    private String last_name;

    @Getter @Setter @Column(name = "email")
    private String email;

    @Getter @Setter @Column(name = "telephone")
    private String telephone;

    @Getter @Setter @Column(name = "password")
    private String password;
}

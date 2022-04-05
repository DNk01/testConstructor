package com.example.testconstructor.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "user_name")
    String user_name;

    @Column(name = "user_surname")
    String user_surname;
}

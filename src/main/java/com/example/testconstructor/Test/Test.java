package com.example.testconstructor.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class Test {
    @Id
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    String name;
    @Column(name="questionsAmount")
    int questionsAmount;
}

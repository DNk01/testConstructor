package com.example.testconstructor.Test;

import com.example.testconstructor.Question.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "test")
public class Test {
    @Id
    @Column(name = "test_id")
    Long testId;

    @Column(name = "test_name")
    String testName;
}

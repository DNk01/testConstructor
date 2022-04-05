package com.example.testconstructor.Statisctics;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "statistic")
public class Statistic {
    @Id
    @Type(type="org.hibernate.type.UUIDCharType")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="statistic_id", updatable = false, nullable = false)
    private UUID statistic_id;

    @Column(name = "user_id")
    Long user_id;

    @Column(name = "test_id")
    Long test_id;

    @Column(name="right_answers_amount")
    Integer right_answers_amount;
}

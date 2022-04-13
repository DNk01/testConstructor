package com.example.testconstructor.Url;

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
@Table(name = "url")
public class Url {
    @Id
    @Column(name = "url_id", nullable = false)
    private Long urlId;

    @Column(name = "test_id")
    Long testId;

    @Column(name = "user_id")
    Long userId;

}

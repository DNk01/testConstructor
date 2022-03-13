package com.example.testconstructor.repositories;

import com.example.testconstructor.entities.Constructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstructorRepository extends JpaRepository<Constructor, Long> {
}

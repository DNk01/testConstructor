package com.example.testconstructor.services;

import com.example.testconstructor.entities.Constructor;
import com.example.testconstructor.repositories.ConstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ConstructorService {

    private final ConstructorRepository constructorRepository;

    @Autowired
    public ConstructorService(ConstructorRepository constructorRepository){
        this.constructorRepository = constructorRepository;
    }

    public void createConstructor(Constructor constructor){
        constructorRepository.save(constructor);
    }

    public Constructor findByIdConstructor(Long id){
        return constructorRepository.findById(id).get();
    }

    public void deleteByIdConstructor(Long id) { constructorRepository.deleteById(id); }
}

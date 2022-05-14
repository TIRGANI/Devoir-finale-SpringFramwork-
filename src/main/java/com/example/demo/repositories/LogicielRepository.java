package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Logiciel;

@Repository
public interface LogicielRepository  extends JpaRepository<Logiciel, Integer>{

}

package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Urgence;


@Repository
public interface UrgenceRepository  extends JpaRepository<Urgence, Integer>{

}

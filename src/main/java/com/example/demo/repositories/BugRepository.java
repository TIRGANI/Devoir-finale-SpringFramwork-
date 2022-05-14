package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Bug;


@Repository
public interface BugRepository  extends JpaRepository<Bug, Integer>{

}

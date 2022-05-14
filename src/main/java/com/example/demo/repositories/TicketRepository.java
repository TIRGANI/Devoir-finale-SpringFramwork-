package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Integer>{

}

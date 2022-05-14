package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Bug;
import com.example.demo.models.Ticket;
import com.example.demo.models.User;
import com.example.demo.repositories.BugRepository;
import com.example.demo.repositories.TicketRepository;
import com.example.demo.repositories.UserRepository;

@RestController
@RequestMapping("tickets")
public class TicketController {
	@Autowired
	private TicketRepository repository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BugRepository bugRepository;

	@GetMapping("/all")
	public List<Ticket> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/alltricket/{id}")
	public List<Ticket> findByiduser(@PathVariable final int id) {
		List<Ticket> tickets = repository.findAll();
		List<Ticket> utick = new ArrayList<Ticket>();
		for (Ticket t : tickets) {
			if (t.getUser().getId() == id) {
				utick.add(t);
			}

		}
		return utick;
	}

	@GetMapping(value = "/{id}")
	public Optional<Ticket> findByCode(@PathVariable final int id) {
		return repository.findById(id);
	}

	@PostMapping(value = "/save")
	public void save(@RequestBody final Ticket ticket) {
		repository.save(ticket);
	}

	@PostMapping(value = "/savet")
	public void saveTicket(@PathVariable String nom, String description, int priorite, int bugid,
			int userid) {
		User u = new User();
		for (User us : userRepository.findAll()) {
			if (us.getId() == userid) {
				u = us;
			}

		}
		Bug b = new Bug();
		for (Bug bs : bugRepository.findAll()) {
			if (bs.getId() == bugid) {
				b = bs;
			}

		}

		repository.save(new Ticket(nom, description, priorite, u, b));
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		repository.deleteById(id);
	}
}

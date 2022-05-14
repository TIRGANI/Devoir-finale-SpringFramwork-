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
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private BugRepository bugRepository;
	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping("/all")
	public List<User> findAll() {
		return userrepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<User> findByCode(@PathVariable final int id) {
		return userrepository.findById(id);
	}
	

	@GetMapping(value = "/listbugs")
	public List<Bug> listbugs() {
		List<Bug> bugs = bugRepository.findAll();
		List<Bug> bugsNonAtt = new ArrayList<>();
		for (Bug bug : bugs) {
			if (bug.getEtat() != "non attribués") {
				bugsNonAtt.add(bug);
			}
		}
		return bugsNonAtt;
	}

	@PostMapping("/{idBug}/{idDev}")
	public void affecter(@PathVariable int idBug, @PathVariable int idDev) {
		Bug bug = bugRepository.getById(idBug);
		User dev = userrepository.getById(idDev);
		Ticket ticket = new Ticket();
		if (dev != null && bug != null) {

			ticket.setDescription("desc");
			ticket.setNom(null);
			ticket.setUser(dev);
			ticket.setBug(bug);
			ticketRepository.save(ticket);

		}
	}

	@PostMapping(value = "/save")
	public void save(@RequestBody final User user) {
		userrepository.save(user);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		userrepository.deleteById(id);
	}
}

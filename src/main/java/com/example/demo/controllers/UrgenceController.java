package com.example.demo.controllers;

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


import com.example.demo.models.Urgence;
import com.example.demo.repositories.UrgenceRepository;
@RestController
@RequestMapping("urgences")
public class UrgenceController {
	@Autowired
	private  UrgenceRepository repository;

	@GetMapping("/all")
	public List<Urgence> findAll() {
		return repository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Urgence> findByCode(@PathVariable final int id) {
		return repository.findById(id);
	}

	@PostMapping(value = "/save")
	public void save(@RequestBody final Urgence urgence ) {
		repository.save(urgence);
	}


	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		repository.deleteById(id);
	}
}

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

import com.example.demo.models.Bug;
import com.example.demo.repositories.BugRepository;


@RestController
@RequestMapping("bugs")
public class BugController {
	@Autowired
	private BugRepository bugRepository;

	@GetMapping("/all")
	public List<Bug> findAll() {
		return bugRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Bug> findByCode(@PathVariable final int id) {
		return bugRepository.findById(id);
	}
	
	@PostMapping(value = "/save")
	public void save(@RequestBody final Bug bug) {
		bugRepository.save(bug);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		bugRepository.deleteById(id);
	}
}

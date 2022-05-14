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
import com.example.demo.models.Logiciel;
import com.example.demo.repositories.LogicielRepository;

@RestController
@RequestMapping("logiciels")
public class LogicelController {
	@Autowired
	private LogicielRepository logicielRepository;

	@GetMapping("/all")
	public List<Logiciel> findAll() {
		return logicielRepository.findAll();
	}

	@GetMapping(value = "/{id}")
	public Optional<Logiciel> findByCode(@PathVariable final int id) {
		return logicielRepository.findById(id);
	}

	@PostMapping(value = "/save")
	public void save(@RequestBody final Logiciel logiciel) {
		logicielRepository.save(logiciel);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable(required = true) int id) {
		logicielRepository.deleteById(id);
	}
}

package com.ashwin.controller;

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

import com.ashwin.accessingdatamysql.Marks;
import com.ashwin.accessingdatamysql.Marks;
import com.ashwin.accessingdatamysql.MarksRepository;

@RestController
@RequestMapping("/api/marks")
public class MarksController {
	@Autowired
	private MarksRepository marksRepository;
	
	@GetMapping()
	public List<Marks> getDetails() {
		return (List<Marks>)marksRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Marks> getDetails(@PathVariable int id ) {
		return marksRepository.findById(id);
	}

	@PostMapping()
	public void addNewUser(@RequestBody Marks marks) {
		marksRepository.save(marks);
		
	}
	
	@DeleteMapping("/del/{id}")
	public String delDetails(@PathVariable int id) {
		marksRepository.deleteById(id);
		return "Successfully Deleted " + id;
	}
}
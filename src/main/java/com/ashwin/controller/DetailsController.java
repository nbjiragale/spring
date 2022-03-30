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

import com.ashwin.accessingdatamysql.User;
import com.ashwin.accessingdatamysql.Details;
import com.ashwin.accessingdatamysql.DetailsRepository;

@RestController
@RequestMapping("/api/details")
public class DetailsController {
	@Autowired
	private DetailsRepository detailsRepository;
	
	@GetMapping()
	public List<Details> getDetails() {
		return (List<Details>)detailsRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Details> getDetails(@PathVariable int id ) {
		return detailsRepository.findById(id);
	}

	@PostMapping()
	public void addNewUser(@RequestBody Details details) {
		detailsRepository.save(details);
		
	}
	
	@DeleteMapping("/del/{id}")
	public String delDetails(@PathVariable int id) {
		detailsRepository.deleteById(id);
		return "Successfully Deleted " + id;
	}
}
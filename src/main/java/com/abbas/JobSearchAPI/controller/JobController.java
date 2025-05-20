package com.abbas.JobSearchAPI.controller;

import java.io.IOException;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abbas.JobSearchAPI.Services.Services;
import com.abbas.JobSearchAPI.model.Job;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class JobController {

	@GetMapping("/")
	  @Operation(summary = "Home endpoint", description = "Returns a welcome message")
	  public void redirect(HttpServletResponse response) throws IOException {
	    response.sendRedirect("/swagger-ui.html");
	  }
	
	@Autowired
	Services services;
	
	@GetMapping("/jobs")
	  public List<Job> getAllJobs(){
		  
		  return services.getJobs();
	  }
	  
	@PostMapping("/job")
	  public void addJob(@RequestBody Job j) {
		  services.addJob(j);
		 
	  }
	
	
	@GetMapping("/jobs/{text}")
	public List<Document> search(@PathVariable String text){
		
		return services.search(text);
		
	}
}

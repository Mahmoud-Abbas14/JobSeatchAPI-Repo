package com.abbas.JobSearchAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class Services {
	@Autowired
	JobRepository jobRepository;

	@Autowired
	Search search;
	
	public List<Job> getJobs() {
		return jobRepository.findAll();
	}

	public void addJob(Job p) {


		jobRepository.save(p);
	}

	public List<org.bson.Document> search(String text) {
		return search.findByText(text);
	}

	

	
}

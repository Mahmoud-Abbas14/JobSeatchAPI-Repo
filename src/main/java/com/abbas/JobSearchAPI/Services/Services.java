package com.abbas.JobSearchAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.abbas.JobSearchAPI.Repository.JobRepository;
import com.abbas.JobSearchAPI.Repository.Search;
import com.abbas.JobSearchAPI.model.Job;


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

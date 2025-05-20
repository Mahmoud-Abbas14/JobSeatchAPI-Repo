package com.abbas.JobSearchAPI.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.abbas.JobSearchAPI.model.Job;

public interface JobRepository extends MongoRepository<Job, String> {

}

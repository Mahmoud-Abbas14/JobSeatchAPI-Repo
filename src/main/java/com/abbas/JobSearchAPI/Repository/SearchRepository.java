package com.abbas.JobSearchAPI.Repository;

import java.util.List;

import org.bson.Document;


public interface SearchRepository {
	List<Document> findByText(String text);
}

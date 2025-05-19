package com.abbas.JobSearchAPI;

import java.util.List;

import org.bson.Document;


public interface SearchRepository {
	List<Document> findByText(String text);
}

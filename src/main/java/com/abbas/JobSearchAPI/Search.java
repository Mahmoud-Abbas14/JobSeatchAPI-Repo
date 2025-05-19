package com.abbas.JobSearchAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;

@Component
public class Search implements SearchRepository{

	@Autowired
    private MongoTemplate mongoTemplate;

	@Override
	public List<Document> findByText(String text) {
	    List<Document> pipeline = Arrays.asList(
	        new Document("$search", new Document("index", "default")
	            .append("text", new Document("query", text)
	                .append("path", Arrays.asList("desc", "skills", "exp")))),
	        new Document("$limit", 2L)
	    );

	    MongoCollection<Document> collection = mongoTemplate.getCollection("Job");

	    AggregateIterable<Document> results = collection.aggregate(pipeline).allowDiskUse(true);

	    List<Document> documents = new ArrayList<>();
	    for (Document doc : results) {
	        documents.add(doc);
	    }
	    return documents;
	}
	
}

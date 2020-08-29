package com.dxc.app;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDemo_04 {

	public static void main(String[] args) {
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoClient.getDatabase("dxc");
		MongoCollection<Document> collection=mongoDatabase.getCollection("abcd");
		
	
	   collection.deleteOne(new Document("name", "book"));
		
		System.out.println("Document Delete Success");
		
		mongoClient.close();
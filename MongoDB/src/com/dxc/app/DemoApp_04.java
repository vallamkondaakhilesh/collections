package com.dxc.app;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class DemoApp_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase= mongoClient.getDatabase("dxc");
		MongoCollection<Document> mongoCollection=mongoDatabase.getCollection("gadget");

		mongoCollection.updateOne(
				Filters.and(
						Filters.eq("name","Mobile"),
						Filters.eq("brand", "Lenovo")
						),
				Updates.set("memory", "16GB")
				);
	
		
		System.out.println("Document Updated Success");
		
		mongoClient.close();
	}

}
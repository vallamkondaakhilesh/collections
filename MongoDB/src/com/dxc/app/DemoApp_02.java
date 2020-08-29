package com.dxc.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

public class DemoApp_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean existing = false;

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the collection name : ");
		String collectionName = scanner.next();
		
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("dxc");
		MongoIterable<String> collectionNames = mongoDatabase.listCollectionNames();
		List<String> listofcollections = collectionNames.into(new ArrayList<String>());
		for(String colName : listofcollections) {
			if(collectionName.equals(colName)) {
				existing = true;
				break;
			}
		}
		if(existing) {
			System.out.println("collection is already existing");
		}
		else {
			mongoDatabase.createCollection(collectionName);
			System.out.println("collection created");
		}
		mongoClient.close();
		scanner.close();
	}

}
package com.dxc.app;

import java.util.ArrayList;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DemoApp_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase mongoDatabase = mongoClient.getDatabase("dxc");

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the collection name : ");
		String collectionName = scanner.next();
		
		if(mongoDatabase.listCollectionNames().into(new ArrayList<String>()).contains(collectionName))
		{
			MongoCollection<Document> mongoCollection=mongoDatabase.getCollection(collectionName);
			Document document = new Document()
					               .append("name", "Pendrive")
					               .append("memory", "16GB");
			mongoCollection.insertOne(document);
			System.out.println("Document inserted Success");
		}
		else
		{
			System.out.println("Collection is not exist");
		}
		mongoClient.close();
	}

}
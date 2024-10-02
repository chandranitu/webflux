package com.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "my_collection") // This maps the class to a MongoDB collection
public class MyEntity {

	@Id
	private String id; // MongoDB document ID

	private String name;
	private String description;

	// Constructors
	public MyEntity() {
	}

	public MyEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MyEntity{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", description='" + description + '\''
				+ '}';
	}
}

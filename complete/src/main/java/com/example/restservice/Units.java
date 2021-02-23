package com.example.restservice;

public class Units {

	private final long id;
	private final String content;

	public Units(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}

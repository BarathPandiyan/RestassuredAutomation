package com.test.pojos;

import com.google.gson.Gson;

public class Jobs {
	private String name;
	private String job;
	
	public Jobs( String _name, String _job ) {
		this.name = _name;
		this.job = _job;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return this.name + " " + this.job;
	}
	
	public String getJSON() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}

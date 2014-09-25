package com.fumec.job.api;

import java.io.IOException;
import java.util.List;

import com.fumec.job.api.model.Job;
import com.google.gson.Gson;

public class JobServiceImpl implements jobService{

	private String description;
	private String location;
	private String latitude;
	private String longitude;
	private boolean fulltime;
	private String page;
	
	private String url;
	private String json;
	
	private final String URI_BASE = "http://jobs.github.com/positions.json?";
	private final String DESCRIPTION = "description=";
	private final String LOCATION = "location=";
	private final String LATITUDE = "lat=";
	private final String LONGITUDE = "long=";
	private final String FULL_TIME = "full_time=";
	private final String PAGE = "page=";
	
		
	//https://jobs.github.com/positions.json?description=python&location=sf&full_time=true
	
	public JobServiceImpl(){
		this.url = this.URI_BASE;
	}
	
	@Override
	public void setDescription(String value) {
		this.description = value;		
		this.montaUrl(DESCRIPTION, value);
	}

	@Override
	public void setLocation(String value) {
		this.location = value;
		this.montaUrl(LOCATION, value);
	}
	
	@Override
	public void setLatitudeLongetude(String latitude, String longitude ) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.montaUrl(LATITUDE, latitude);
		this.montaUrl(LONGITUDE, longitude);
	}

	@Override
	public void setFullTime(Boolean value) {
		this.fulltime = value;
		this.montaUrl(FULL_TIME, value.toString());
	}
	
	@Override
	public void setPage(String value) {
		this.page = value;
		this.montaUrl(PAGE, value);
	}
	
	public String getUrl() {
		return url;
	}

	private void montaUrl(String parametro, String valor) {
		 
		if (!this.url.equals(this.URI_BASE)) {
			this.url += "&";
		}
		this.url += parametro + valor;
	}
	
	//https://jobs.github.com/positions.json?description=python&location=sf&full_time=true
	
	@Override
	public List<Job> Search(String json) {
		
		//Gson gson = new Gson();
		//List<Job> jobs = (List<Job>) gson.fromJson(json, Job.class);
		
		return null;
		
	}
			
}

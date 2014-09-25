package com.fumec.job.api;

import java.util.List;

import com.fumec.job.api.model.Job;

public interface jobService {

	public void setDescription(String value);
	public void setLocation(String value);
	public void setLatitudeLongetude(String latitude, String longetude);
	public void setFullTime(Boolean value);
	public void setPage(String value);
	public List<Job> Search(String value);
}

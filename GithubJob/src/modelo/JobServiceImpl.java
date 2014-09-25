package modelo;

import interfaces.Json;
import interfaces.Url;
import interfaces.jobService;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;


public class JobServiceImpl implements jobService{

	private Url url = new UrlImpl();
	private Json json = new JsonImpl();
	
	private final String URI_BASE = "http://jobs.github.com/positions.json?";
	private final String DESCRIPTION = "description=";
	private final String LOCATION = "location=";
	private final String LATITUDE = "lat=";
	private final String LONGITUDE = "long=";
	private final String FULL_TIME = "full_time=";
	private final String PAGE = "page=";
	
	
	public JobServiceImpl(){
		this.url.setUrl(URI_BASE);
	}
	
	@Override
	public void setDescription(String value) {
		this.url.incluirParametroPesquisa(DESCRIPTION);
		this.url.incluirValorPesquisa(value);
;	}

	@Override
	public void setLocation(String value) {
		this.url.incluirParametroPesquisa(LOCATION);
		this.url.incluirValorPesquisa(value);
	}
	
	@Override
	public void setLatitudeLongetude(String latitude, String longitude ) {
		this.url.incluirParametroPesquisa(LATITUDE);
		this.url.incluirValorPesquisa(latitude);		
		this.url.incluirParametroPesquisa(LONGITUDE);
		this.url.incluirValorPesquisa(longitude);
	}

	@Override
	public void setFullTime(Boolean value) {
		this.url.incluirParametroPesquisa(FULL_TIME);
		this.url.incluirValorPesquisa(value.toString());
	}
	
	@Override
	public void setPage(String value) {
		this.url.incluirParametroPesquisa(PAGE);
		this.url.incluirValorPesquisa(value);
	}

	public String getUrl() {
		return this.url.getUrl();
	}

	//https://jobs.github.com/positions.json?description=python&location=sf&full_time=true
	
	@Override
	public List<Job> Search(String json) {
		
		List<Job> jobs = ((Object) this.json.gson).fromJson(json, new TypeToken<List<Job>>(){}.getType());
		return jobs;
	}
	
}

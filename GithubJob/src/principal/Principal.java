package principal;

import java.util.ArrayList;
import java.util.List;


import modelo.GetConteudoPagina;
import modelo.Job;
import modelo.JobServiceImpl;



public class Principal {

	public static void main(String[] args){
		TestJob();
		
	}
	
	public static void TestJob(){
		String url;
		String json;
				
		JobServiceImpl service = new JobServiceImpl();
		GetConteudoPagina getPagina = new GetConteudoPagina();
				
		service.setDescription("java");
		service.setLocation("New York");
		service.setFullTime(true);
		
		url = service.getUrl();
		
		json = getPagina.pegarConteudoUrl(url);		
		//System.out.println(json);
		
		List<Job> jobs = new ArrayList<Job>();
		jobs = service.Search(json);
		
		for (Job job : jobs) {
			System.out.println(job.getTitle());
		}
	}
	
	}

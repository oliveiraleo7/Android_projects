package principal;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


import java.util.List;
import com.fumec.job.api.GetConteudoPagina;
import com.fumec.job.api.JobServiceImpl;
import com.fumec.job.api.jobService;
import com.fumec.job.api.model.Job;


public class Test {

	public static void main(String[] args){
		//TestJob();
		
		InputStream teste = null;
		try {
			teste = getContentFromUrl();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(teste.toString());
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
		
		//json = getPagina.pegarConteudoUrl(url);
		
		System.out.println(url);
		
		
		//List<Job> jobs = service.Search(json);
	}
	
	// método utilizando a API nativa URL, HttpURLConnection
	public static InputStream getContentFromUrl() throws Exception {
	  InputStream is = null;
	  URL url = new URL("http://jobs.github.com/positions.json?description=python&location=sf&full_time=true");
	  is = url.openStream();
	  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	  conn.setDoOutput(true);
	  conn.setDefaultUseCaches(true);
	  conn.setUseCaches(true);
	  conn.setRequestMethod("GET");
	  conn.setRequestProperty("Content-type", "text/xml; charset=UTF-8");
	  is = null;
	  try {
	      is = conn.getInputStream();
	  } catch (Exception e) {
	      e.printStackTrace();
	      is = conn.getErrorStream();
	  }
	  return is;
	}

}

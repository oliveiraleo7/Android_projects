package com.project.curiosos;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;



import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

public class BaixaJson extends AsyncTask<String, String, Void> {

	private TextView texto;
	
	public BaixaJson(TextView text){
		this.texto = text;
	}
	
	@Override
	protected Void doInBackground(String... params) {
		
		Log.i("doInBack", "doInBack");
		String url = params[0];
		String json;
		List<Curiosidade> lista;
		
		json = this.BaixarConteudo(url);
		lista = this.ConverterJson(json);
		
		try {
			this.texto.setText("oioioioioi");
			Log.i("teste", "testandoAlteracao");
		} catch (Exception e) {
			Log.i("teste", e.getMessage());
		    e.printStackTrace();
		}
		return null;

	}
	
	@Override
	protected void onProgressUpdate(String... params) {
		Log.i("onProgressUpdate", "onProgressUpdate");
        texto.setText(params[0]);
	}
	
	private String BaixarConteudo(String url){
		
		//url = "https://jobs.github.com/positions.json?description=java&location=New%20york&full_time=true";
		
		String json = "";
		
		HttpClient httpclient = new DefaultHttpClient(); 
		HttpGet httpget = new HttpGet(url);

	
	    try {
	    	
	    	HttpResponse response = httpclient.execute(httpget); 
	    	HttpEntity entity = response.getEntity(); 
	    	
	    	if (entity != null) { 
	    		InputStream instream = entity.getContent(); 
	    		json = toString(instream); 
	    		instream.close(); 
	    		
	    		//List<Trend> trends = getTrends(json); 
	    	
	    	}

	    	//json = responseBody.toString();

	    } catch (Exception e) {
	    	System.err.println("Erro no json: " + e.getMessage());
		    e.printStackTrace();
	    } finally {
	      // Release the connection.
	      //method.releaseConnection();
	    }  
	    return json;
	    
	}
	
	private List<Curiosidade> ConverterJson(String json) {
		
		List<Curiosidade> curiosidades = null;
		
		try {
			Gson gson = new Gson();
			curiosidades = gson.fromJson(json, new TypeToken<List<Curiosidade>>(){}.getType());
			
			
		} catch (JsonSyntaxException e) {
			System.err.println("Erro na sintaxe do json: " + e.getMessage());
		    e.printStackTrace();
		} catch (JsonParseException e) {
			System.err.println("Erro na convers�o do json: " + e.getMessage());
		    e.printStackTrace();
		} catch (Exception e) {
			System.err.println("Exce��o: " + e.getMessage());
		    e.printStackTrace();
		} 
		return curiosidades;
	}
	
	private String toString(InputStream is) throws IOException { 
		byte[] bytes = new byte[1024]; 
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		
		int lidos; 
		while ((lidos = is.read(bytes)) > 0) { 
			baos.write(bytes, 0, lidos); 
		} 
		return new String(baos.toByteArray()); }


}

package com.aula.android.jsontwitter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
 
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ConsumirJsonTwitterActivity extends ListActivity {

 
	
	 	@Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        new DownloadJsonAsyncTask().execute("http://leonardolael.esy.es/curiosidades.php");
	    }


	 	@Override
	    protected void onListItemClick(ListView l, View v, int position, long id) {
	        super.onListItemClick(l, v, position, id);
	         
	        Curiosidade trend = (Curiosidade)l.getAdapter().getItem(position);
	         
	        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(trend.item));
	        startActivity(it);
	    }  


	class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Curiosidade>> {
	 
	        ProgressDialog dialog;
	 
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            dialog = ProgressDialog.show(ConsumirJsonTwitterActivity.this, "Aguarde",
	                    "Baixando JSON, Por Favor Aguarde...");
	            Log.e("teste1","onPreExecute");
	        }


	        @Override
	        protected List<Curiosidade> doInBackground(String... params) {
	            String urlString = params[0];
	 
	            HttpClient httpclient = new DefaultHttpClient();
	            HttpGet httpget = new HttpGet(urlString);
	 
	            try {
	                HttpResponse response = httpclient.execute(httpget);
	 
	                HttpEntity entity = response.getEntity();
	 
	                if (entity != null) {
	                    InputStream instream = entity.getContent();
	 
	                    String json = toString(instream);
	                    instream.close();
	                     
	                    List<Curiosidade> trends = getCuriosidade(json);
	                     
	                    return trends;
	                } 
	            } catch (Exception e) {
	                Log.e("DEVMEDIA", "Falha ao acessar Web service", e);
	            }
	            Log.e("teste2","doInBackgroud");
	            return null;
	        }
	        
	        /*
	        private List<Curiosidade> getTrends(String jsonString) {
	 
	            List<Curiosidade> itens = new ArrayList<Curiosidade>();
	             
	            try {
	                JSONArray trendLists = new JSONArray(jsonString);
	                JSONObject trendList = trendLists.getJSONObject(0);
	                JSONArray trendsArray = trendList.getJSONArray("curiosidades");
	 
	                JSONObject trend;
	                 
	                for (int i = 0; i < trendsArray.length(); i++) {
	                    trend = new JSONObject(trendsArray.getString(i));
	 
	                    Log.i("DEVMEDIA", "nome=" + trend.getString("categoria"));
	                     
	                    Curiosidade item = new Curiosidade();
	                    item.categoria = trend.getString("categoria");
	                    item.item = trend.getString("item");
	                     
	                    itens.add(item);
	                }
	            } catch (JSONException e) {
	                Log.e("DEVMEDIA", "Erro no parsing do JSON", e);
	            }
	 
	            return itens;
	        }*/
	        
	        
	        private List<Curiosidade> getCuriosidade(String jsonString) {
	        	Gson gson = new Gson();
	            List<Curiosidade> itens = gson.fromJson(jsonString, Curiosidade.class);
	            return itens;
	        }

	        @Override
	        protected void onPostExecute(List<Curiosidade> result) {
	            super.onPostExecute(result);
	            dialog.dismiss();
	            if (result.size() > 0) {
	                ArrayAdapter<Curiosidade> adapter = new ArrayAdapter<Curiosidade>(
	                        ConsumirJsonTwitterActivity.this,
	                        android.R.layout.simple_list_item_1, result);
	                setListAdapter(adapter);
	 
	            } else {
	                AlertDialog.Builder builder = new AlertDialog.Builder(
	                        ConsumirJsonTwitterActivity.this).setTitle("Aten��o")
	                        .setMessage("N�o foi possivel acessar essas inform��es...")
	                        .setPositiveButton("OK", null);
	                builder.create().show();
	            }
	            Log.e("teste3","onPostExecute");
	        }
	 
	        private String toString(InputStream is) throws IOException {
	 
	            byte[] bytes = new byte[1024];
	            ByteArrayOutputStream baos = new ByteArrayOutputStream();
	            int lidos;
	            while ((lidos = is.read(bytes)) > 0) {
	                baos.write(bytes, 0, lidos);
	            }
	            return new String(baos.toByteArray());
	        }
	    }
	 
	}
	 
	class Curiosidade {
	    String categoria;
	    String item;
	     
	    @Override
	    public String toString() {
	        return categoria;
	    }
	}

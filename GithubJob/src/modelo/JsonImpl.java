package modelo;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import interfaces.Json;

public class JsonImpl implements Json {

	private String json;
	public Gson gson = new Gson();
		
	@Override
	public String getJson() {
		return this.json;
	}

	@Override
	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String ConverterParaJson(List<Object> lista) {
		this.json = gson.toJson(lista);
		return this.getJson();
	}

	@Override
	public String ConverterParaJson(Object obj) {
		this.json = gson.toJson(obj);
		return this.getJson();
	}

	@Override
	public List<Object> LerJson(String json) {

		List<Object> lista = gson.fromJson(json, new TypeToken<List<Object>>(){}.getType());
		return lista;
		
	}

}

package interfaces;

import java.util.List;

public interface Json {
		
	Object gson = null;

	public String getJson();
	
	public void setJson(String json);
	
	public String ConverterParaJson(List<Object> lista);
	
	public String ConverterParaJson(Object obj);
	
	public List<Object> LerJson(String json);

}

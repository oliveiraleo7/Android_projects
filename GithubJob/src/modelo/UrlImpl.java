package modelo;

import interfaces.Url;

public class UrlImpl implements Url {
	
	private String url;
	private int contParametros = 0;

	@Override
	public void setUrl(String url) {
		this.url = url;
		
	}

	@Override
	public String getUrl() {
		return this.url;
	}

	@Override
	public void incluirParametroPesquisa(String parametro) {
		
		if (this.contParametros > 0){
			this.url += "&";
		}
		this.url += parametro;
		this.contParametros++;
		
	}

	@Override
	public void incluirValorPesquisa(String valor) {
		valor = valor.replace(" ", "%20");
		this.url += valor;
		
	}
	
	

}

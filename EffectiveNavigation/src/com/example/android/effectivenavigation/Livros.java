package com.example.android.effectivenavigation;

import java.util.LinkedList;

public class Livros {
	
	private LinkedList<String> livros = new LinkedList<String>();


	public Livros() {
		
		livros.add("Geneses");
		livros.add("Marcos");
		livros.add("Apocalipse");
		livros.add("Jo�o");
		livros.add("Salmos");
		livros.add("Prov�rbios");
		livros.add("Canticos");
		livros.add("Romanos");
		livros.add("II Corintios");
		livros.add("III Jo�o");
		livros.add("Lucas");
		livros.add("Atos");
		livros.add("Hebreus");
		livros.add("Sofonias");
			  
	}
	
	public int getTamanho() {
		return livros.size();
	}
	
	public LinkedList<String> getLista(){
		return livros;
	}
	
	public String getItem(int i){
		return livros.get(i);
	}
	
	
	
	
}

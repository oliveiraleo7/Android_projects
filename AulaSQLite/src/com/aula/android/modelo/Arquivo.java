package com.aula.android.modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Arquivo {
	
	
	public Arquivo(String caminho) throws IOException{
		FileWriter arq = new FileWriter(caminho);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		gravarArq.printf("+--Resultado--+%n");
	    for (int i=1; i<=10; i++) {
	      gravarArq.printf("| %2d X %d = %2d |%n", i, 1, (i*2));
	    }
	    gravarArq.printf("+-------------+%n");
	    
	    arq.close();
	
	}

	public void EscreverNoArquivo(){
		
	}
	
	public void FecharArquivo() throws IOException{
		
	}
	    



}

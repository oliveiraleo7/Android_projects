package com.project.curiosos;

import com.google.android.gms.ads.*;


import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView texto;
	Button vai, volta;	
	Textos textos = new Textos();
	int indice_atual = 0;


	
	/*String[] array = new String[10];
	int[] a = new int[10];*/

	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Texto        
        texto = (TextView)findViewById(R.id.textView1);
        indice_atual = new Random().nextInt(textos.getList().size());
        this.setarConteudo(indice_atual);
        
        //Botao Vai 
        vai = (Button)findViewById(R.id.btn_vai);          
        vai.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (indice_atual == textos.getList().size()) {
		    		indice_atual = 0;
		    	}
		    	else {
		    		indice_atual++;
		    	}
		    	setarConteudo(indice_atual);			
			}
		});
        
        //Botao volta
        volta = (Button)findViewById(R.id.btn_volta);
        volta.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				if (indice_atual == 0) {
		    		indice_atual = textos.getList().size();
		    	}
		    	else {
		    		indice_atual--;
		    	}
		    	setarConteudo(indice_atual);			
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void setarConteudo(int indice){
    	texto.setText(textos.getList().get(indice));
    }


}

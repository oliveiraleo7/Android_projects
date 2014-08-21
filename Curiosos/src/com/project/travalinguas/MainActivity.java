package com.project.travalinguas;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import java.util.Random;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView texto;
	private Button btn_outro;	
	private Textos textos = new Textos();
	private int indice_atual = 0;
	private AdView adView;
	private static Display display;
	private LinearLayout layout;


	
	/*String[] array = new String[10];
	int[] a = new int[10];*/

	
	@SuppressWarnings({ "deprecation", "static-access" })
	@SuppressLint("NewApi")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //Tamanho da tela
        display = ((WindowManager) getSystemService(this.WINDOW_SERVICE)).getDefaultDisplay();
        
        // Criar o adView.
        adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-2089512394531818/4497272285");
        adView.setAdSize(AdSize.BANNER);
        
        layout = (LinearLayout)findViewById(R.id.mainLayout);
        layout.addView(adView);
        
        // Iniciar uma solicita��o gen�rica.
        AdRequest adRequest = new AdRequest.Builder().build();

        // Carregar o adView com a solicita��o de an�ncio.
        adView.loadAd(adRequest);
        
        
        //Texto        
        texto = (TextView)findViewById(R.id.textView1);
        indice_atual = new Random().nextInt(textos.getList().size());
        this.setarConteudo(indice_atual);
        
        //Botao Outro
        btn_outro = (Button)findViewById(R.id.btn_outro);
        btn_outro.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				indice_atual = new Random().nextInt(textos.getList().size());
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
    
    @Override
    public void onPause() {
      adView.pause();
      super.onPause();
    }

    @Override
    public void onResume() {
      super.onResume();
      adView.resume();
    }

    @Override
    public void onDestroy() {
      adView.destroy();
      super.onDestroy();
    }


}

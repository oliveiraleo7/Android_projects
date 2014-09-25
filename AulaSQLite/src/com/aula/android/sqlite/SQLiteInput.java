package com.aula.android.sqlite;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
 
public class SQLiteInput extends Activity implements OnClickListener{
 
    Button sqlInsert;
    Button sqlView;
    Button sqlDelete;
 
    EditText sqlNome;
    EditText sqlMatricula;
    EditText sqlDisciplina;
    EditText sqlCargaHoraria;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exemplosqlite);
 
        sqlInsert = (Button) findViewById(R.id.bSQLInsert);
        sqlView  = (Button) findViewById(R.id.bSQLView);
        sqlDelete = (Button) findViewById(R.id.bSQLDelete);
 
        sqlNome  = (EditText) findViewById(R.id.etNome);
        sqlMatricula    = (EditText) findViewById(R.id.etMatricula);
        sqlDisciplina	= (EditText) findViewById(R.id.etDisciplica);
        sqlCargaHoraria = (EditText) findViewById(R.id.etCargaHoraria);
 
        sqlInsert.setOnClickListener(this);
        sqlView.setOnClickListener(this);
        sqlDelete.setOnClickListener(this);
    }
 
    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
    	String name 	= sqlNome.getText().toString();
        switch (arg0.getId()){
        case R.id.bSQLInsert:
 
            boolean work = true;
 
            try{
 
            String age  	= sqlMatricula.getText().toString();
            String disc 	= sqlDisciplina.getText().toString();
            String cargaHor	= sqlCargaHoraria.getText().toString();	
            
            SQLiteManage entry = new SQLiteManage(SQLiteInput.this);
 
            entry.open();
            entry.createEntry(name, age,disc,cargaHor);
            entry.close();
 
            }catch (Exception e){
                work = false;
                String erro = e.toString();
                Dialog d = new Dialog(this);
                d.setTitle("Erro!");
                TextView tv = new TextView(this);
                tv.setText(erro);
                d.setContentView(tv);
                d.show();
 
            }finally{
                if (work == true){
                    Dialog d = new Dialog(this);
                    d.setTitle("Carregado!");
                    TextView tv = new TextView(this);
                    tv.setText("Com sucesso.");
                    d.setContentView(tv);
                    d.show();
                }
            }
            break;
        
        case R.id.bSQLView:
            Intent i = new Intent("com.aula.android.sqlite.SQLVIEW");
            startActivity(i);
            break;
        
        case R.id.bSQLDelete:
        	
            SQLiteManage entry = new SQLiteManage(SQLiteInput.this);
            
            entry.open();
            entry.deletar(name);
            entry.close();
            
            Toast toast = Toast.makeText(this, "Deletado com sucesso",Toast.LENGTH_SHORT);
            toast.show();
                    	
        	break;
        }
    }
 
}
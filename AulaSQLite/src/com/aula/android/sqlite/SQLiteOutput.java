package com.aula.android.sqlite;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.aula.android.modelo.Arquivo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TableRow.LayoutParams;
import android.widget.TableLayout;
import android.widget.TableRow;
 
public class SQLiteOutput extends Activity{
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlview);
 
        SQLiteManage info = new SQLiteManage(this);
 
        TableLayout tl = (TableLayout) findViewById(R.id.tl1);
 
        info.open();
        ArrayList<TableRow> data = info.getData();
        info.close();
 
        for(TableRow tr : data) {
        	tl.addView(tr, new TableLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        }
        
        this.gravarJson();
 
    }
    
    public void gravarJson(){
    	
    	try {
    		String text = "OLA";
			File file = new File(context.getExternalFilesDir(null),
				"romar.txt");
			FileOutputStream out = new FileOutputStream(file, true);
			out.write(text.getBytes());
			out.write("\n".getBytes());
			out.flush();
			out.close();	
			
		} catch (Exception e) {
			Log.e(TAG, e.toString());
		}
    	
    	
    	/*
    	String textoQueSeraEscrito = "Texto que sera escrito.";  
      
        FileWriter arquivo;  
        
        try {  
            arquivo = new FileWriter(new File(getAbsolutePath()+"/Arquivo.txt"));  
            arquivo.write(textoQueSeraEscrito);  
            arquivo.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        */
    	    	
    }
    
}
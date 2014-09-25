package com.aula.android.sqlite;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
import android.widget.TableRow;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;
 
public class SQLiteManage {
 
    public static final String _ROWID  			= "id";
    public static final String _NOME    		= "nome";
    public static final String _MATRICULA   	= "idade";
    public static final String _DISCIPLINA		= "disciplina";
    public static final String _CARGA_HORARIA 	= "cargaHoraria";
 
    public static final String BD_NOME  = "Idades";
    public static final String BD_TABLE = "aluno";
    public static final int BD_VERSION  = 4; //Deve-se alterar o versionamento quando a estrutura do banco for alterada
 
    private DbHelper nAjuda;
    private final Context nContext;
    private SQLiteDatabase nBaseDados;
 
    private static class DbHelper extends SQLiteOpenHelper{
 
        public DbHelper(Context context){
            super(context, BD_NOME, null, BD_VERSION);
            // TODO Auto-generated method stub
        }
 
        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(
                    "CREATE TABLE " + BD_TABLE + " (" +
                    _ROWID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    _NOME  + " TEXT NOT NULL, " +
                    _MATRICULA    + " TEXT NOT NULL," +
                    _DISCIPLINA + " TEXT NOT NULL," +
                    _CARGA_HORARIA + " TEXT NOT NULL" + ");"
            );
        }
 
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVesion) {
            // TODO Auto-generated method stub
            db.execSQL("DROP TABLE IF EXISTS " + BD_TABLE);
            onCreate(db);
        }
 
    }
 
    public SQLiteManage(Context c){
        nContext = c;
    }
 
    public SQLiteManage open() throws SQLException{
        nAjuda = new DbHelper(nContext);
        nBaseDados = nAjuda.getWritableDatabase();
        return this;
    }
 
    public void close(){
        nAjuda.close();
    }
 
    
    public void deletar(String nome){
    	nBaseDados.execSQL("delete from " + BD_TABLE + " where " + _NOME + " = '" + nome + "'");
    }
    
    public long createEntry(String nome, String matricula, String disciplina, String cargaHoraria) {
        ContentValues cv = new ContentValues();
        cv.put(_NOME, nome);
        cv.put(_MATRICULA, matricula);
        cv.put(_DISCIPLINA, disciplina);
        cv.put(_CARGA_HORARIA, cargaHoraria);
        return nBaseDados.insert(BD_TABLE, null, cv);
    }
 
    public ArrayList<TableRow> getData() {
        // TODO Auto-generated method stub
        String[] colunas = new String[]{ _ROWID, _NOME, _MATRICULA, _DISCIPLINA, _CARGA_HORARIA };
        Cursor c = nBaseDados.query(BD_TABLE, colunas, null, null, null, null, null);
        
        int iRow = c.getColumnIndex(_ROWID);
        int iNome= c.getColumnIndex(_NOME);
        int iMatricula = c.getColumnIndex(_MATRICULA);
        int iDisciplina = c.getColumnIndex(_DISCIPLINA);
        int iCargaHoraria = c.getColumnIndex(_CARGA_HORARIA);
 
        ArrayList<TableRow> linhas = new ArrayList<TableRow>();
        TableRow tr;
        TextView tv;
 
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            //Cria uma nova linha
            tr = new TableRow(nContext);
            tr.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
 
            //TextView Para ID
            tv = new TextView(nContext);
            tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
 
            //Adiciona o ID
            tv.setText(c.getString(iRow));
            tr.addView(tv);
 
            //TextView para Nome
            tv = new TextView(nContext);
            tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 10));
 
            //Adiciona o Nome
            tv.setText(c.getString(iNome));
            tr.addView(tv);
 
            //TextView para Matrícula
            tv = new TextView(nContext);
            tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 10));
 
            //Adiciona o Matrícula
            tv.setText(c.getString(iMatricula));
            tr.addView(tv);
            
            //TextView para Disciplina
            tv = new TextView(nContext);
            tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 10));
 
            //Adiciona o Disciplina
            tv.setText(c.getString(iDisciplina));
            tr.addView(tv);
            
            //TextView para Carga Horária
            tv = new TextView(nContext);
            tv.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 7));
 
            //Adiciona o Carga Horária
            tv.setText(c.getString(iCargaHoraria));
            tr.addView(tv);
 
            //Adiciona à Linha
            linhas.add(tr);
        }
        return linhas;
    }
}
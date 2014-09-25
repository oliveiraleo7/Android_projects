package com.livros.prJorge;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;


public class ListaLivros extends Activity implements OnItemClickListener
{
    private ListView listView;
    private AdapterListLivro adapterListView;
    private ArrayList<Livro> itens;
 
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_lista_livros);
 
        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.list_livros);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);
 
        createListView();
    }
 
    private void createListView()
    {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<Livro>();
        Livro item1 = new Livro("Mateus");
        Livro item2 = new Livro("Marcos");
        Livro item3 = new Livro("Lucas");
        Livro item4 = new Livro("João");
 
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);
        itens.add(item4);
 
        //Cria o adapter
        adapterListView = new AdapterListLivro(this, itens);
 
        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }
 
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3)
    {
        //Pega o item que foi selecionado.
        Livro item = adapterListView.getItem(arg2);
        //Demostração
        Toast.makeText(this, "Você Clicou em: " + item.getNome(), Toast.LENGTH_LONG).show();
    }
}
package br.exemplogridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adaptador extends BaseAdapter {
	private Context ctx;
	private int[] lista;
	
	public Adaptador(Context ctx, int[] lista){
		this.ctx = ctx;
		this.lista = lista;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return lista[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		ImageView iv = new ImageView(ctx);
		iv.setImageResource(lista[position]);
		//iv.setAdjustViewBounds(true);
		
		return iv;
	}
}

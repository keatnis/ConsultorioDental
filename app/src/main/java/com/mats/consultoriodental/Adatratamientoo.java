package com.mats.consultoriodental;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adatratamientoo extends BaseAdapter {
    private static LayoutInflater inflater=null;
    Context context;
    String[][] informacion;
    public Adatratamientoo(Context context, String[][] informacion) {
        this.context = context;
        this.informacion = informacion;
        inflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        final View vista=inflater.inflate(R.layout.activity_lista_tratamiento,null);
        TextView tvTitulo=(TextView) vista.findViewById(R.id.tvTitulo);
        TextView tvCosto=(TextView) vista.findViewById(R.id.tvCosto);

        tvTitulo.setText(informacion[position][0]);
        tvCosto.setText(informacion[position][3]);
        return vista;


    }
}

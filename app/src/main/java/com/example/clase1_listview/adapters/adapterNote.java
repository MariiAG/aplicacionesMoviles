package com.example.clase1_listview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.clase1_listview.R;
import java.util.ArrayList;

public class adapterNote extends BaseAdapter {
    public Context context;
    private ArrayList<String> list;

    public adapterNote() {
    }

    public adapterNote(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewItemNota = view;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(this.context);
            viewItemNota = inflater.inflate(R.layout.item_nota, viewGroup, false);
        }

        TextView tv_titulo, tv_contenido;
        tv_titulo = viewItemNota.findViewById(R.id.tv_titulo);
        tv_contenido = viewItemNota.findViewById(R.id.tv_contenido);

        tv_titulo.setText(list.get(i));
        tv_contenido.setText(list.get(i));

        return viewItemNota;
    }
}

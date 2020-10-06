package com.example.clase1_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clase1_listview.crud.NoteOp;
import com.example.clase1_listview.models.NoteMd;

import java.util.ArrayList;

public class MainDetalleNota extends AppCompatActivity {
    TextView tv_titulo, tv_contenido;
    Button regresar, modificar, eliminar;
    private NoteMd model;
    private NoteOp adapter;
    private ArrayList<String> list;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detalle_nota);

        initial();

        String i;
        i =getIntent().getStringExtra("posicion");
        num=Integer.parseInt(i) + 1;
        model=adapter.selectForId(num);
        tv_titulo.setText(model.getTitulo());
        tv_contenido.setText(model.getContenido());

        modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = tv_titulo.getText().toString();
                String contenido = tv_contenido.getText().toString();
                if(!titulo.isEmpty() || !contenido.isEmpty()){
                    model = new NoteMd(num,titulo, contenido);
                    long valorupdate = adapter.update(model);
                    if (valorupdate > 0){
                        Toast.makeText(MainDetalleNota.this, "Datos guardados correctamente", Toast.LENGTH_LONG).show();
                        Intent intent= new Intent(MainDetalleNota.this, MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainDetalleNota.this, "No se han podido guardar los datos", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(MainDetalleNota.this, "No se a agregado titulo o contenido a la nota", Toast.LENGTH_LONG).show();
                }
            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long valordelete = adapter.delete(num);
                 if (valordelete > 0){
                    Toast.makeText(MainDetalleNota.this, "Datos eliminados correctamente", Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(MainDetalleNota.this, MainActivity.class);
                    startActivity(intent);
                }
                    else {
                    Toast.makeText(MainDetalleNota.this, "No se han podido eliminar los datos", Toast.LENGTH_LONG).show();
                }
            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDetalleNota.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

   public void initial() {
        tv_titulo = findViewById(R.id.ed_titulo);
        tv_contenido = findViewById(R.id.ed_contenido);
        regresar = findViewById(R.id.regresar);
        modificar = findViewById(R.id.modificar);
        eliminar = findViewById(R.id.eliminar);
        model = new NoteMd();
        adapter = new NoteOp(getApplicationContext());
    }
}
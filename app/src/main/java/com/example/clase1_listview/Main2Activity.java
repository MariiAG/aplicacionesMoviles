package com.example.clase1_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.clase1_listview.crud.NoteOp;
import com.example.clase1_listview.database.SQLHelper;
import com.example.clase1_listview.models.NoteMd;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private Button cancelar, guardar;
    private TextView ed_titulo, ed_contenido;
    private NoteOp adapter;
    private NoteMd model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        cancelar = findViewById(R.id.cancelar);
        guardar = findViewById(R.id.guardar);
        ed_titulo = findViewById(R.id.ed_titulo);
        ed_contenido = findViewById(R.id.ed_contenido);


//EVENTO GUARDAR
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titulo = ed_titulo.getText().toString();
                String contenido = ed_contenido.getText().toString();
                if(!titulo.isEmpty() || !contenido.isEmpty()){
                    model = new NoteMd(titulo, contenido);
                    long valorinsert = adapter.insert(model);

                        if (valorinsert > 0){
                            Toast.makeText(Main2Activity.this, "Datos guardados correctamente", Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(Main2Activity.this, Main2Activity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(Main2Activity.this, "No se han podido guardar los datos", Toast.LENGTH_LONG).show();
                        }
                }else{
                    Toast.makeText(Main2Activity.this, "No se a agregado titulo o contenido a la nota", Toast.LENGTH_LONG).show();
                }
            }
        });

//EVENTO CANCELAR
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this, "Cancelado", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}

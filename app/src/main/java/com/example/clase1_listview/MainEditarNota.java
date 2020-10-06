package com.example.clase1_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clase1_listview.crud.NoteOp;
import com.example.clase1_listview.models.NoteMd;

import java.util.ArrayList;

public class MainEditarNota extends AppCompatActivity {

    EditText ed_titulo, ed_contenido;
    Button guardar, cancelar;
    private NoteMd model;
    private NoteOp adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_editar_nota);
        initial();









    }
    private void initial() {
        ed_titulo = findViewById(R.id.ed_titulo);
        ed_contenido = findViewById(R.id.ed_contenido);
        guardar = findViewById(R.id.modificar);
        cancelar = findViewById(R.id.eliminar);
        model = new NoteMd();
        adapter = new NoteOp(getApplicationContext());
    }
}
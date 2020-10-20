package com.example.clase1_listview;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.clase1_listview.adapters.adapterNote;
import com.example.clase1_listview.crud.NoteOp;
import com.example.clase1_listview.models.NoteMd;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listNota;
    Button agregar;
    private ArrayList<String> list;
    private NoteMd model;
    private NoteOp operacion;
    private adapterNote adapternote;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_AppCompat_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initial();

        list = operacion.list();
        adapternote = new adapterNote(this, list);
        //ArrayAdapter<String> listadapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_activated_1, list);
        listNota.setAdapter(adapternote);

        listNota.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //String num= String.valueOf(i);
             Intent nuevo = new Intent(MainActivity.this, MainDetalleNota.class);
             //nuevo.putExtra("posicion",num);
             startActivity(nuevo);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevo = new Intent(MainActivity.this, MainCrearNota.class);
                startActivity(nuevo);
            }
        });

    }
        private void initial() {
            listNota = findViewById(R.id.listNota);
            agregar = findViewById(R.id.agregar);
            list = new ArrayList<>();
            model = new NoteMd();
            operacion = new NoteOp(getApplicationContext());
        }

}

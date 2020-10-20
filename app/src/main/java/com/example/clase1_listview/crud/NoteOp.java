package com.example.clase1_listview.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.clase1_listview.database.SQLHelper;
import com.example.clase1_listview.models.NoteMd;
import java.util.ArrayList;

public class NoteOp{

    private String DBNAME="dbnota1";
    private int VERSION=1;
    public final Context context;
    private ArrayList<String> list;
    private SQLiteDatabase database;
    private SQLHelper helper;
    private NoteMd model;


    public NoteOp(Context context) {
        this.context = context;
        helper = new SQLHelper(context,DBNAME,null,VERSION);
    }

    protected void openRead(){
        database = helper.getReadableDatabase();
    }

    protected void openWrite(){
        database = helper.getWritableDatabase();
    }

    protected void close(){
        database.close();
    }

    public long insert(NoteMd model){
        openWrite();
        ContentValues content = new ContentValues();
        content.put("titulo", model.getTitulo());
        content.put("contenido", model.getContenido());
        long id = database.insert("nota",null, content);
        close();
        return id;
    }

    public ArrayList<String> list(){
        list = new ArrayList<>();
        openRead();
        Cursor cursor = database.query("nota", null, null,null, null, null, null);
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            String titulo, contenido, consolidado;
            int id;
            do {
                id = cursor.getInt(cursor.getColumnIndex("id"));
                titulo = cursor.getString(cursor.getColumnIndex("titulo"));
                contenido = cursor.getString(cursor.getColumnIndex("contenido"));

                consolidado = String.valueOf(id) + ". " + titulo+ "\n" + contenido;
                list.add(consolidado);
            }
            while (cursor.moveToNext());
        }
        close();
        return list;
    }

    /*public ArrayList<NoteMd> selectNotaForId(int id){
        openRead();
        String where = "id ?";
        String idtext = String.valueOf(id);
        Cursor cursor = database.query("nota", null, where, new String[]{idtext}, null, null, null);
        if (cursor.getCount() < 1){
            return null;
        }else {
            listado = new ArrayList<>();
            cursor.moveToFirst();
            do {
                model = new NoteMd();
                model.set_id(id);
                //model.set_id(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
                model.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
                model.setContenido(cursor.getString(cursor.getColumnIndex("contenido")));
                listado.add(model);
            }while (cursor.moveToNext());
            close();
            return listado;
        }

    }*/

    public NoteMd selectForId(int id){
        openRead();
        String where = "id = ?";
        String textId = String.valueOf(id);
        Cursor cursor = database.query("nota", null, where, new String[]{textId}, null, null, null);
        if (cursor.getCount() < 1){
            return null;
        }else {
            cursor.moveToFirst();
            model = new NoteMd();
            model.set_id(id);
            model.setTitulo(cursor.getString(cursor.getColumnIndex("titulo")));
            model.setContenido(cursor.getString(cursor.getColumnIndex("contenido")));
            close();
            return model;
        }
    }
    public long update(NoteMd model){
        openWrite();
        ContentValues content = new ContentValues();
        content.put("titulo", model.getTitulo());
        content.put("contenido", model.getContenido());

        String where = "id = ?";
        String textId = String.valueOf(model.get_id());
        long resp= database.update("Nota", content, where, new String[]{textId});
        close();
        return resp;
    }

    public long delete(int id){
        openWrite();
        String where = "id = ?";
        String textId = String.valueOf(model.get_id());
        long resp=database.delete("Nota", where, new String[]{textId});
        close();
        return resp;
    }
}

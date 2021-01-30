package com.example.practica_2.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.practica_2.R;

public class ControladorDB extends SQLiteOpenHelper {

    public ControladorDB(@Nullable Context context) {
        super(context, "com.example.practica_2.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE USUARIOS (ID INTEGER PRIMARY KEY AUTOINCREMENT, USER TEXT NOT NULL, PASS TEXT NOT NULL);");
        db.execSQL("CREATE TABLE TAREAS (ID INTEGER PRIMARY KEY, NOMBRE TEXT NOT NULL, USERNOMBRE TEXT, FOREIGN KEY (USERNOMBRE) REFERENCES USUARIOS (USER));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean loginUser(String usuario, String pass) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS WHERE USER = '" + usuario + "' AND PASS = '" + pass + "'", null);

        int regs = cursor.getCount();

        if (regs == 0) {
            db.close();
            return false;
        } else {
            return true;
        }
    }


    public boolean addUser(String name, String pass) {

        SQLiteDatabase db;
        db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM USUARIOS WHERE USER = '" + name + "'", null);

        int regs = cursor.getCount();

        if (regs == 0) {
            ContentValues registroUser = new ContentValues();
            registroUser.put("USER", name);
            registroUser.put("PASS", pass);

            db = this.getWritableDatabase();

            db.insert("USUARIOS", null, registroUser);
            db.close();
            return true;
        } else {
            return false;
        }
    }

    public void addTarea(String tarea, String nombreUser) {

        ContentValues registro = new ContentValues();
        registro.put("NOMBRE", tarea);
        registro.put("USERNOMBRE", nombreUser);

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("TAREAS", null, registro);
        db.close();
    }

    public void editTarea (String nuevaTarea, String tarea, String usuario) {

        ContentValues update = new ContentValues();
        update.put("NOMBRE", nuevaTarea);
        
        SQLiteDatabase db = this.getWritableDatabase();
        db.update("TAREAS",update, "NOMBRE = ? and USERNOMBRE = ?", new String[]{tarea, usuario});
    }

    public String[] obtenerTareas(String user) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("select * from tareas where usernombre= ?", new String[]{String.valueOf(user)});

        int regs = cursor.getCount();

        if (regs == 0) {
            db.close();
            return null;
        } else {
            String[] tareas = new String[regs];
            cursor.moveToFirst();
            for (int i = 0; i < regs; i++) {
                tareas[i] = cursor.getString(1);
                cursor.moveToNext();
            }
            db.close();
            return tareas;
        }
    }

    public int numeroRegistros(String user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TAREAS where usernombre= ?", new String[]{String.valueOf(user)});
        return cursor.getCount();
    }

    public void borrarTarea(String tarea) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("TAREAS", "NOMBRE = ?", new String[]{tarea});
    }

    public int getIdUser(String nombreUser) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT ID FROM USUARIOS WHERE USER = ?", new String[]{nombreUser});

        return cursor.getInt(0);
    }
}

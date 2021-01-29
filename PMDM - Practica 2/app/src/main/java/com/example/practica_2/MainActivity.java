package com.example.practica_2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.practica_2.db.ControladorDB;

public class MainActivity extends AppCompatActivity {

    ControladorDB controladorDB;
    private ArrayAdapter<String> miAdapter;
    ListView listViewTareas;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controladorDB = new ControladorDB(this);
        listViewTareas = (ListView) findViewById(R.id.listaTareas);
        Bundle extra = getIntent().getExtras();
        String userNombre = extra.getString("nombreUser");
        getSupportActionBar().setTitle("Tareas de " + userNombre +".");
        actualizarUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Bundle extra = getIntent().getExtras();
        String userNombre = extra.getString("nombreUser");

        final EditText cajaTexto = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Escribe la tarea.")
                .setView(cajaTexto)
                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tarea = cajaTexto.getText().toString();
                        controladorDB.addTarea(tarea, userNombre);
                        actualizarUI();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .create();
        dialog.show();
        return super.onOptionsItemSelected(item);
    }

    private void actualizarUI() {
        Bundle extra = getIntent().getExtras();
        String userNombre = extra.getString("nombreUser");

        if (controladorDB.numeroRegistros(userNombre) == 0) {
            listViewTareas.setAdapter(null);
        } else {
            miAdapter = new ArrayAdapter<>(this, R.layout.item_tarea, R.id.textItem, controladorDB.obtenerTareas(userNombre));
            listViewTareas.setAdapter(miAdapter);
        }
    }

    public void editarTarea () {

        Bundle extra = getIntent().getExtras();
        String userNombre = extra.getString("nombreUser");

        final EditText cajaTexto = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Escribe la tarea.")
                .setView(cajaTexto)
                .setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tarea = cajaTexto.getText().toString();
                        controladorDB.addTarea(tarea, userNombre);
                        actualizarUI();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .create();
        dialog.show();
        return super.onOptionsItemSelected(item);
    }


    }

    public void borrarTarea(View view) {
        View parent = (View) view.getParent();
        TextView tareaTextView = (TextView) parent.findViewById(R.id.textItem);
        String tarea = tareaTextView.getText().toString();
        controladorDB.borrarTarea(tarea);
        actualizarUI();
    }
}
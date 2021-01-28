package com.example.practica_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica_2.db.ControladorDB;

public class MainActivity extends AppCompatActivity {

    ControladorDB controladorDB;
    private ArrayAdapter<String> miAdapter;
    ListView listViewTareas;
    int idUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controladorDB = new ControladorDB(this);
        listViewTareas = (ListView) findViewById(R.id.listaTareas);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        idUser = bundle.getInt("userId");
        actualizarUI();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        final EditText cajaTexto = new EditText(this);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("Escribe la tarea.")
                .setView(cajaTexto)
                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String tarea = cajaTexto.getText().toString();
                        controladorDB.addTarea(tarea, idUser);
                        actualizarUI();
                    }
                })
                .setNegativeButton("Cancelar", null)
                .create();
        dialog.show();
        return super.onOptionsItemSelected(item);
    }

    private void actualizarUI() {
        if (controladorDB.numeroRegistros() == 0) {
            listViewTareas.setAdapter(null);
        } else {
            miAdapter = new ArrayAdapter<>(this, R.layout.item_tarea, R.id.textItem, controladorDB.obtenerTareas(idUser));
            listViewTareas.setAdapter(miAdapter);
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
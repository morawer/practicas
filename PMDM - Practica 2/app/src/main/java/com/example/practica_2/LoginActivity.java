package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.practica_2.db.ControladorDB;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    ControladorDB controladorDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        controladorDB = new ControladorDB(this);
    }

    public void botonCrearUsuario (View view) {

        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
        finish();
    }

    public void entrarButon(View view) {
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.user);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.password);

        String userName = usuario.getText().toString();
        String userPass = pass.getText().toString();

        if (controladorDB.loginUser(userName, userPass)) {

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("nombreUser", userName);
            startActivity(intent);

            finish();

        } else {
            Toast toast = Toast.makeText(this, R.string.toast_error_pass, Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
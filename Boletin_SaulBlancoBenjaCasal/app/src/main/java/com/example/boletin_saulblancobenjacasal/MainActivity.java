package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/*
CRUD
C --> Create/Crear
R --> Read/Select
U --> Update/Actualizar
D --> Delete/Borrar

 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void administrar(View view){
        Intent intent = new Intent(MainActivity.this, Activity_IntroDatosFoto.class);
        startActivity(intent);
    }
}
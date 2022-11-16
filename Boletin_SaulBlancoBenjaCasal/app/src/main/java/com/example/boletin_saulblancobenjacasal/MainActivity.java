package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText editText_IntroNombre;
    Button button_Jugar;
    Button button_VerPuntuaciones;
    Button button_anhadir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_Jugar=(Button) findViewById(R.id.button_Jugar);
        button_VerPuntuaciones=(Button) findViewById(R.id.button_VerPuntuaciones);
        button_anhadir=(Button)findViewById(R.id.button_anhadir);
        editText_IntroNombre=(EditText) findViewById(R.id.editText_IntroNombre);

    }



    public void anhadir(View view){
        Intent intent = new Intent(MainActivity.this, Activity_anhadir.class);
        startActivity(intent);
    }

    public void puntuaciones(View view){
        Intent intent = new Intent(MainActivity.this, Activity_TablasPuntuacion.class);
        startActivity(intent);
    }
}
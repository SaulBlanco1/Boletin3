package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;

public class Activity_IntroDatosFoto extends AppCompatActivity {

    TextView textView_IntroNombreFoto;
    ImageView imageView_imagen;
    EditText editText_nombreAntiguo;
    EditText editText_nombreNuevo;
    EditText editText_IntroNombreFoto;
    Button button_Crear;
    Button button_Modificar;
    Button button_eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_datos_foto);

        textView_IntroNombreFoto=(TextView) findViewById(R.id.textView_IntroNombreFoto);
        editText_IntroNombreFoto=(EditText) findViewById(R.id.editText_IntroNombreFoto);
        editText_nombreAntiguo=(EditText) findViewById(R.id.editText_nombreAntiguo);
        editText_nombreNuevo=(EditText)findViewById(R.id.editText_nombreNuevo);
        imageView_imagen=(ImageView) findViewById(R.id.imageView_imagen);
        button_Crear=(Button) findViewById(R.id.button_Crear);
        button_Modificar=(Button) findViewById(R.id.button_Modificar);
        button_eliminar=(Button) findViewById(R.id.button_eliminar);


    }
}
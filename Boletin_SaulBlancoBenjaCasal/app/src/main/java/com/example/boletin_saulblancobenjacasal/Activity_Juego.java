package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Activity_Juego extends AppCompatActivity {

    private TextView textView_HeaderPregunta, textView_PreguntaDeTurno;
    private Button button_Siguiente, button_Terminar;
    private RadioGroup radioGroup_Respuestas;
    private RadioButton radioButton_Respuesta1, radioButton_Respuesta2, radioButton_Respuesta3, radioButton_Respuesta4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        textView_HeaderPregunta = (TextView) findViewById(R.id.textView_HeaderPregunta);
        textView_PreguntaDeTurno = (TextView) findViewById(R.id.textView_PreguntaDeTurno);
        button_Siguiente = (Button) findViewById(R.id.button_Siguiente);
        button_Terminar = (Button) findViewById(R.id.button_Terminar);
        radioGroup_Respuestas = (RadioGroup) findViewById(R.id.radioGroup_Respuestas);
        radioButton_Respuesta1 = (RadioButton) findViewById(R.id.radioButton_Respuesta1);
        radioButton_Respuesta2 = (RadioButton) findViewById(R.id.radioButton_Respuesta2);
        radioButton_Respuesta3 = (RadioButton) findViewById(R.id.radioButton_Respuesta3);
        radioButton_Respuesta4 = (RadioButton) findViewById(R.id.radioButton_Respuesta4);
    }

    public void terminar(View v){
        Intent in = new Intent(Activity_Juego.this, MainActivity.class);
        startActivity(in);
    }
    
    public void siguientePregunta(View v){
        Intent i = new Intent(v.getContext(), Activity_Juego.class);
        startActivity(i);
    }
}
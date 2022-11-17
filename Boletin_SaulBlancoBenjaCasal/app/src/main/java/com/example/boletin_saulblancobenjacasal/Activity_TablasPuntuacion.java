package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_TablasPuntuacion extends AppCompatActivity {


    Button button_Volver;
    int idPregunta;
    String pregunta,respuesta1,respuesta2,respuesta3,respuesta4,respuestacorr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_tablas_puntuacion);

        button_Volver = (Button)findViewById(R.id.button_Volver);
        RecyclerView lista=(RecyclerView) findViewById(R.id.lista);

        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "boletin4", null, 1);

        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getReadableDatabase();

        //Array que incluye los campos/columnas de la tabla productos, sobre la que hacer la consulta
        String[] columnas = {"idPregunta","pregunta","respuesta1","respuesta2","respuesta3","respuesta4","respuestacorrect"};

        //El resultado de la consulta de select se guarda en el Cursor
        Cursor cursor = db.query("Preguntas",columnas,null,null,null,null,null);

        //Recorrer el array de resultados (cursor) para mostrar al usario la informacion
        //obtenida dentro de los campos del formulario.
        ArrayList<Pregunta> preguntasArray = new ArrayList<>();

        while(cursor.moveToNext()) {
             idPregunta = cursor.getInt(cursor.getColumnIndexOrThrow("idPregunta"));
             pregunta = cursor.getString(cursor.getColumnIndexOrThrow("pregunta"));
             respuesta1 = cursor.getString(cursor.getColumnIndexOrThrow("respuesta1"));
             respuesta2 = cursor.getString(cursor.getColumnIndexOrThrow("respuesta2"));
             respuesta3 = cursor.getString(cursor.getColumnIndexOrThrow("respuesta3"));
             respuesta4 = cursor.getString(cursor.getColumnIndexOrThrow("respuesta4"));
             respuestacorr= cursor.getString(cursor.getColumnIndexOrThrow("respuestacorrect"));

            Pregunta pregunta1 = new Pregunta(idPregunta, pregunta, respuesta1,respuesta2,respuesta3,respuesta4,respuestacorr);

            preguntasArray.add(pregunta1);
        }
      //  Toast.makeText(this, idPregunta+" "+pregunta+" "+respuesta1+" "+respuesta2+" "+respuesta3+" "+respuesta4+" "+respuestacorr, Toast.LENGTH_SHORT).show();
        cursor.close();
        //Cierro conexión con base de datos
        db.close();

        //Toast.makeText(this, idPregunta+" "+pregunta, Toast.LENGTH_SHORT).show();

        AdaptadorPreguntas adaptadorPreguntas = new AdaptadorPreguntas(preguntasArray,getApplicationContext());

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lista.setLayoutManager(mLayoutManager);
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setAdapter(adaptadorPreguntas);
    }

    public void volver(View v){
        Intent in = new Intent(Activity_TablasPuntuacion.this, MainActivity.class);
        startActivity(in);
    }
}
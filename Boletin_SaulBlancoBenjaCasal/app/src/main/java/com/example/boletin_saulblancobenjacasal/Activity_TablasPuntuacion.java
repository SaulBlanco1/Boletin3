package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class Activity_TablasPuntuacion extends AppCompatActivity {

    RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_tablas_puntuacion);

        lista=(RecyclerView) findViewById(R.id.lista);
//Instancio de la conexión con la Base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "almacen", null, 1);

        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getReadableDatabase();

        //Array que incluye los campos/columnas de la tabla productos, sobre la que hacer la consulta
        String[] columnas = {"idPregunta","pregunta","respuesta1","respuesta2","respuesta3","respuesta4","respuestacorrect"};

        //El resultado de la consulta de select se guarda en el Cursor
        Cursor cursor = db.query("Preguntas",columnas,null,null,null,null,null);

        //Recorrer el array de resultados (cursor) para mostrar al usario la informacion
        //obtenida dentro de los campos del formulario.
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        while(cursor.moveToNext()) {
            int idPregunta = cursor.getInt(cursor.getColumnIndex("idPregunta"));
            String pregunta = cursor.getString(cursor.getColumnIndex("pregunta"));
            String respuesta1 = cursor.getString(cursor.getColumnIndex("respuesta1"));
            String respuesta2 = cursor.getString(cursor.getColumnIndex("respuesta2"));
            String respuesta3 = cursor.getString(cursor.getColumnIndex("respuesta3"));
            String respuesta4 = cursor.getString(cursor.getColumnIndex("respuesta4"));
            String respuestacorr= cursor.getString(cursor.getColumnIndex("respuestacorrect"));

            Pregunta producto = new Pregunta(idPregunta, pregunta, respuesta1,respuesta2,respuesta3,respuesta4,respuestacorr);
            preguntas.add(producto);
        }
        cursor.close();
        //Cierro conexión con base de datos
        db.close();

        AdaptadorPreguntas adaptadorPreguntas = new AdaptadorPreguntas(preguntas);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        lista.setLayoutManager(mLayoutManager);
        lista.setItemAnimator(new DefaultItemAnimator());
        lista.setAdapter(adaptadorPreguntas);
    }
}
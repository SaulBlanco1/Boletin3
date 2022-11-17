package com.example.boletin_saulblancobenjacasal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //Constructor que incluye parametros para hacer de forma dinámica la construcción de la BD
    //Le pasamos el contexto, el nombre de la base de datos, el cursor y la versión
    public AdminSQLiteOpenHelper(Context context, String nombreDB, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nombreDB, factory, version);
    }

    @Override
    //Crear la tabla de preguntas
    public void onCreate(SQLiteDatabase db){
        final String CONSULTA_CREAR_TABLA =
                "CREATE TABLE Preguntas (" +
                        "idPregunta  INTEGER PRIMARY KEY," +
                        "pregunta TEXT," +
                        "respuesta1 TEXT," +
                        "respuesta2 TEXT," +
                        "respuesta3 TEXT," +
                        "respuesta4 TEXT," +
                        "respuestacorrect TEXT)";

        db.execSQL(CONSULTA_CREAR_TABLA);

        //    final String CONSULTA_CREAR_TABLA2 =
        //        "CREATE TABLE Partidas (npartida  INTEGER PRIMARY KEY,nombreusuario TEXT,puntuacion decimal(2,1), fecha date )";
      //  db.execSQL(CONSULTA_CREAR_TABLA2);


    }
    //Método para hacer cambio de versión de base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //gestion de cache online y cambio de version de base de datos
        // -> de momento no nos interesa realizar acciones en este caso
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
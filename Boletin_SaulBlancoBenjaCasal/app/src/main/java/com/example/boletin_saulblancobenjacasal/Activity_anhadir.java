package com.example.boletin_saulblancobenjacasal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_anhadir extends AppCompatActivity {

    EditText editText_resp1;
    EditText editText_resp2;
    EditText editText_resp3;
    EditText editText_resp4;
    Button button_anhadir;
    EditText editText_Pregunta;
    EditText editText_correct;
    int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anhadir);


        editText_resp1=(EditText)findViewById(R.id.editText_resp1);
        editText_resp2=(EditText)findViewById(R.id.editText_resp2);
        editText_resp3=(EditText)findViewById(R.id.editText_resp3);
        editText_resp4=(EditText)findViewById(R.id.editText_resp4);
        editText_Pregunta=(EditText)findViewById(R.id.editText_Pregunta);
        button_anhadir=(Button) findViewById(R.id.button_Anhadir);
        editText_correct=(EditText) findViewById(R.id.editText_correct);

    }

    public void alta(View v){
        //Instancio de la conexión con la Base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "boletin4", null, 1);
        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getWritableDatabase();

        String pregunta=editText_Pregunta.getText().toString();
        String resp1=editText_resp1.getText().toString();
        String resp2=editText_resp2.getText().toString();
        String resp3=editText_resp3.getText().toString();
        String resp4=editText_resp4.getText().toString();
        String respCorr=editText_correct.getText().toString();

        //Si no rellenó todos los valores del formulario error y no se genera alta de producto
        if(pregunta.length()==0 || resp1.length()==0 || resp2.length()==0 || resp3.length()==0 || resp4.length()==0 || respCorr.length()==0) {
            Toast.makeText(this, "Tienes datos obligatorios que rellenar", Toast.LENGTH_SHORT).show();
        } else {
            //aumento el valor de contador que referencia al ID  de la pregunta
            contador++;
            //Los valores están cubiertos y preparamos para alta de producto

            //Preparar la información anterior en un array de valores para incluirlos en la consulta de insert
            ContentValues valores = new ContentValues();
            //valores.put(<<nombre de la columna de la tabla>>, <<valor del campo>>);
            valores.put("idPregunta", contador);
            valores.put("pregunta", pregunta);
            valores.put("respuesta1",resp1);
            valores.put("respuesta2",resp2);
            valores.put("respuesta3",resp3);
            valores.put("respuesta4",resp4);
            valores.put("respuestacorrect",respCorr);



            //Consulta que lanza el insert sobre la tabla con los valores indicados.

            //Caso en el que el método devuelve la clave principal -> usar si clave principal autoincrement
            //long idFila = db.insert("productos",null,valores);

            //En nuestro caso, la clave principal el dada por el usuario, por lo que no insteresa generarla
            db.insert("Preguntas",null,valores);

            //Vacío los campos del formulario
            editText_Pregunta.setText("");
            editText_resp1.setText("");
            editText_resp2.setText("");
            editText_resp3.setText("");
            editText_resp4.setText("");
            editText_correct.setText("");


            //Mensaje informativo
            Toast.makeText(this, "Producto dado de alta", Toast.LENGTH_SHORT).show();
        }

        //Cierro conexión con base de datos
        db.close();
    }



}
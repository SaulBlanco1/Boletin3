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

    TextView textView_IntroNombreFoto;
    ImageView imageView_imagen;
    EditText editText_nombreAntiguo;
    EditText editText_nombreNuevo;
    EditText editText_IntroNombreFoto;
    Button button_Crear;
    Button button_Modificar;
    Button button_eliminar;
    int contador=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anhadir);

        textView_IntroNombreFoto=(TextView) findViewById(R.id.textView_IntroNombreFoto);
        editText_IntroNombreFoto=(EditText) findViewById(R.id.editText_IntroNombreFoto);

        button_Crear=(Button) findViewById(R.id.button_Anhadir);

        button_eliminar=(Button) findViewById(R.id.button_eliminar);


    }

    public void alta(View v){
        //Instancio de la conexión con la Base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "boletin4", null, 1);
        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getWritableDatabase();

        //Recogemos la información que el usuario rellenó en los campos del formulario
        String nombre = editText_IntroNombreFoto.getText().toString();

        //Si no rellenó todos los valores del formulario error y no se genera alta de producto
        if(nombre.length()==0) {
            Toast.makeText(this, "Tienes datos obligatorios que rellenar", Toast.LENGTH_SHORT).show();
        } else {
            //aumento el valor de contador que referencia al ID  de la foto
            contador++;
            //Los valores están cubiertos y preparamos para alta de producto

            //Preparar la información anterior en un array de valores para incluirlos en la consulta de insert
            ContentValues valores = new ContentValues();
            //valores.put(<<nombre de la columna de la tabla>>, <<valor del campo>>);
            valores.put("idfoto", contador);
            valores.put("nombrefoto", nombre);



            //Consulta que lanza el insert sobre la tabla con los valores indicados.

            //Caso en el que el método devuelve la clave principal -> usar si clave principal autoincrement
            //long idFila = db.insert("productos",null,valores);

            //En nuestro caso, la clave principal el dada por el usuario, por lo que no insteresa generarla
            db.insert("Fotos",null,valores);

            //Vacío los campos del formulario
            editText_IntroNombreFoto.setText("");


            //Mensaje informativo
            Toast.makeText(this, "Producto dado de alta", Toast.LENGTH_SHORT).show();
        }

        //Cierro conexión con base de datos
        db.close();
    }

    //Modificar información de la ficha de producto
    public void modificar(View v){
        //Instancio de la conexión con la Base de datos
        AdminSQLiteOpenHelper adminHelper = new AdminSQLiteOpenHelper(this, "almacen", null, 1);
        //Abro la conexión de base de datos, con permisos de escritura para realizar las altas
        SQLiteDatabase db = adminHelper.getWritableDatabase();

        //Recogemos la información que el usuario rellenó en los campos del formulario
        String nombreAntiguo = editText_nombreAntiguo.getText().toString();
        String nombreNuevo = editText_nombreNuevo.getText().toString();


        //Si no rellenó todos los valores del formulario error y no se genera alta de producto
        if(nombreAntiguo.length()==0 || nombreNuevo.length()==0) {
            Toast.makeText(this, "Tienes datos obligatorios que rellenar", Toast.LENGTH_SHORT).show();
        } else {
            //Los valores están cubiertos y preparamos para alta de producto

            //Preparar la información anterior en un array de valores para incluirlos en la consulta de insert
            ContentValues valores = new ContentValues();
            //valores.put(<<nombre de la columna de la tabla>>, <<valor del campo>>);
            valores.put("nombrefoto", nombreNuevo);


            // Filtros de la consulta para aplicar en la clausula WHERE "codigo" = codigo
            String seleccion = "nombrefoto" + " = ?";
            String[] condicion = {nombreAntiguo};

            int filasactualizadas = db.update("Fotos",valores,seleccion,condicion);

            if(filasactualizadas==0){
                Toast.makeText(this, "No se han actualizado productos", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Producto actualizado", Toast.LENGTH_SHORT).show();
            }
        }

        //Cierro conexión con base de datos
        db.close();
    }

}
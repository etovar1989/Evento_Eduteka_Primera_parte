package com.example.eventoeduteka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class dia3Opcion extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView dato;
    private Spinner spT;
    private AsyncHttpClient cliente;
    String nombre,pocision,bloque;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia3_opcion );

        bloque = getIntent().getStringExtra( "bloque" );
        dato = findViewById( R.id.txtBloque );
        if(bloque.equals( "M" )){
            dato.setText( "Bloque 1" );
        }if(bloque.equals( "T" )) {
            dato.setText( "Bloque 2" );
        }


        btnContinuar = findViewById( R.id.btnContinuar );

        spT = findViewById( R.id.spTalleres );
        cliente = new AsyncHttpClient( );

        spT.setOnItemSelectedListener(this);

        llenatSpinner();

        btnContinuar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText( dia3Opcion.this,"Conferencia: "+nombre+"Posicion: "+pocision,Toast.LENGTH_LONG ).show();
                Intent intent = new Intent( dia3Opcion.this,dia3SubMenu.class );
                intent.putExtra( "nombre",nombre );
                intent.putExtra( "id",pocision );
                intent.putExtra( "bloque",bloque );
                startActivity( intent );
            }
        } );


    }


    private void llenatSpinner() {
        String url="http://edukatic.icesi.edu.co/2020/complementosApk/talleres.php";
        cliente.post( url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode == 200){
                    cargarSpinner(new String(responseBody));
                    //Toast.makeText(dia2SubMenu.this,new String(responseBody), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        } );
    }



    private void cargarSpinner(String respuesta) {
        ArrayList<Conferencias> lista = new ArrayList<Conferencias>();

        try{
            JSONArray jsonArreglo = new JSONArray( respuesta );
            for(int i=0; i< jsonArreglo.length(); i++){

                Conferencias t = new Conferencias();
                t.setNombre(jsonArreglo.getJSONObject( i ).getString("idTaller")+" - "+ jsonArreglo.getJSONObject( i ).getString("nombreTaller"));
                lista.add( t );
            }

            ArrayAdapter<Conferencias> a = new ArrayAdapter<Conferencias>(this,android.R.layout.simple_dropdown_item_1line,lista);
            spT.setAdapter( a );


        }catch (Exception e){

        }

    }



    @Override
    public void onItemSelected(AdapterView<?>  parent, View view, int position, long id) {
        //Texto
        nombre = parent.getItemAtPosition(position).toString();
        //Posicion
        String string = nombre;
        String[] parts = string.split("-");
        pocision = parts[0];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

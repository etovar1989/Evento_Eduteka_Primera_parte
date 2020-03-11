package com.example.eventoeduteka.dia2;

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

import com.example.eventoeduteka.Conferencias;
import com.example.eventoeduteka.R;

import java.util.ArrayList;

public class dia2Plenaria extends AppCompatActivity implements AdapterView.OnItemSelectedListener{



    private Spinner spT;
    String nombre,pocision,tipo;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia2_plenaria );


        tipo="P";
        btnContinuar = findViewById( R.id.btnContinuar );
        spT = findViewById( R.id.spPlenarias );

        spT.setOnItemSelectedListener(this);


        ArrayList<Conferencias> lista = new ArrayList<Conferencias>();
        Conferencias u = new Conferencias();
        Conferencias o = new Conferencias();
        Conferencias e = new Conferencias();

        u.setNombre(1+" - "+ "Evaluar para enseñar a aprender: enfoque neuropedagógico de la evaluación para los aprendizajes desde las fases y funciones del pensamiento.\nPanelista: Ihosvany Seguí");
        lista.add( u );
        o.setNombre(2+" - "+ "Aprendizaje basado en proyectos de la era digital\nPanelista: Suzie Boss");
        lista.add( o );
        e.setNombre(3+" - "+ "Inteligencia Artificial en la Educación\nPanelista: Hellen Crompton");
        lista.add( e );

        ArrayAdapter<Conferencias> a = new ArrayAdapter<Conferencias>(this,android.R.layout.simple_dropdown_item_1line,lista);
        spT.setAdapter( a );


        btnContinuar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText( dia2Plenaria.this,"Conferencia: "+nombre+"Posicion: "+pocision,Toast.LENGTH_LONG ).show();

                Intent intent = new Intent( dia2Plenaria.this,dia2SubMenu.class );
                intent.putExtra( "tipo",tipo );
                intent.putExtra( "nombre",nombre );
                intent.putExtra( "id",pocision );
                startActivity( intent );

            }
        } );

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
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

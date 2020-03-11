package com.example.eventoeduteka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class dia3SubMenu extends AppCompatActivity {

    String nombre,bloque,id;
    TextView dato;
    Button btnCC,btnQR;
    Dialog cuadroDialogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia3_sub_menu );

        nombre = getIntent().getStringExtra( "nombre" );
        bloque = getIntent().getStringExtra( "bloque" );
        id = getIntent().getStringExtra( "id" );

        btnCC = findViewById( R.id.btnCC );
        btnQR = findViewById( R.id.btnQR );
        dato = findViewById( R.id.txtTipo );

        if(bloque.equals( "M" )){
            dato.setText( "Bloque 1 \n"+nombre );
        }if(bloque.equals( "T" )) {
            dato.setText( "Bloque  \n"+nombre );
        }


        btnCC.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cuadroDialogo = new Dialog( dia3SubMenu.this );
                cuadroDialogo.setContentView( R.layout.dialog_cc );
                cuadroDialogo.show();
                final EditText txtDcumento = cuadroDialogo.findViewById( R.id.txtResultado );
                final Button btnEnviar = cuadroDialogo.findViewById( R.id.btnEnviar );

                btnEnviar.setEnabled( true );

                btnEnviar.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent( dia3SubMenu.this, dia3Resultado.class );

                        if(txtDcumento.getText().toString().isEmpty()){
                            Toast.makeText(dia3SubMenu.this, "Tienes que llenar el campo documento", Toast.LENGTH_SHORT ).show();
                        }else{
                            intent.putExtra( "documento", txtDcumento.getText().toString() );
                            intent.putExtra( "id",id );
                            intent.putExtra( "bloque",bloque );
                            intent.putExtra( "nombre",nombre );
                            startActivity( intent );
                            cuadroDialogo.cancel();
                        }


                    }
                } );

            }
        } );

        btnQR.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( dia3SubMenu.this, dia3QR.class );
                intent.putExtra( "bloque",bloque );
                intent.putExtra( "id",id );
                startActivity( intent );

            }
        } );


    }
}

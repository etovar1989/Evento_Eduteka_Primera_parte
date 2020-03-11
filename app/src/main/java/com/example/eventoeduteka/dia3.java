package com.example.eventoeduteka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dia3 extends AppCompatActivity {

    Button btnTallerB1,btnTallerB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia3 );


        btnTallerB1 = findViewById( R.id.btnTallerB1 );
        btnTallerB2 = findViewById( R.id.btnTallerB2 );

        btnTallerB1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( dia3.this, dia3Opcion.class );
                intent.putExtra( "bloque","M" );
                startActivity( intent );
            }
        } );

        btnTallerB2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( dia3.this, dia3Opcion.class );
                intent.putExtra( "bloque","T" );
                startActivity( intent );
            }
        } );



    }
}

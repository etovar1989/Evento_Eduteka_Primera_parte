package com.example.eventoeduteka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.eventoeduteka.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class dia3QR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView myScannerView;

    String nombre,bloque,id,documento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia3_q_r );

        myScannerView = new ZXingScannerView( this );
        setContentView( myScannerView );
        myScannerView.setResultHandler( this );
        myScannerView.startCamera();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );

    }

    @Override
    public void handleResult(Result result) {

        documento = result.getText();
        bloque = getIntent().getStringExtra( "bloque" );
        id = getIntent().getStringExtra( "id" );
        nombre = getIntent().getStringExtra( "nombre" );

        Toast.makeText( this,"Consulta "+documento, Toast.LENGTH_SHORT).show();

        Intent in = new Intent( dia3QR.this, dia3Resultado.class );

        in.putExtra( "documento",documento);
        in.putExtra( "id",id);
        in.putExtra( "bloque",bloque);
        in.putExtra( "nombre",nombre);

        startActivity( in );
        finish();

    }
}

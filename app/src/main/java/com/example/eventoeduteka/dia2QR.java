package com.example.eventoeduteka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class dia2QR extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    private ZXingScannerView myScannerView;

    String documento,tipo,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dia2_q_r );

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
        tipo = getIntent().getStringExtra( "tipo" );
        id = getIntent().getStringExtra( "id" );

        Toast.makeText( this,"Consulta "+documento, Toast.LENGTH_SHORT).show();

        Intent in = new Intent( dia2QR.this, dia2Resultado.class );

        in.putExtra( "documento",documento);
        in.putExtra( "tipo",tipo);
        in.putExtra( "id",id);

        startActivity( in );
        finish();
    }


}

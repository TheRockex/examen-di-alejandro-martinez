package com.example.alejandromartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ImageView backgroundImageView = findViewById(R.id.backgroundImageView);

        // Cargar la imagen con Glide
        Glide.with(this)
                .load(R.drawable.fondo)
                .into(backgroundImageView);
    }

    public void ChangeToSesion(View view){
        Intent intent = new Intent(Registro.this,Acceder.class);
        startActivity(intent);
    }

    public void ChangeToMain(View view){
        Toast.makeText(Registro.this, "Registrado", Toast.LENGTH_SHORT).show();
    }
}
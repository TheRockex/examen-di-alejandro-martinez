package com.example.alejandromartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Acceder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceder);

        ImageView backgroundImageView = findViewById(R.id.backgroundImageView);

        // Cargar la imagen con Glide
        Glide.with(this)
                .load(R.drawable.fondo)
                .into(backgroundImageView);
    }

    public void ChangeToRegistrar(View view){
        Intent intent = new Intent(Acceder.this,Registro.class);
        startActivity(intent);
    }

    public void ChangeToMain(View view){
        Toast.makeText(Acceder.this, "Iniciado", Toast.LENGTH_SHORT).show();
    }

}
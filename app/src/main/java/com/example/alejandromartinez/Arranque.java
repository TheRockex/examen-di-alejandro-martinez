package com.example.alejandromartinez;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

public class Arranque extends AppCompatActivity {

    private ImageView galletaImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        degradado();
        galletaImageView = findViewById(R.id.caldo);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startAnimation();
            }
        }, 1000);//1000 ms
    }

    private void degradado(){
        GradientDrawable gradient = new GradientDrawable();
        gradient.setColors(
                new int[] {
                        getResources().getColor(R.color.white),
                                getResources().getColor(R.color.white)
                }
        );
        gradient.setOrientation(
            GradientDrawable.Orientation.TOP_BOTTOM
        );
        gradient.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradient.setShape(GradientDrawable.RECTANGLE);
        findViewById(R.id.gradiente).setBackground(gradient);
    }


    private void startAnimation() {
        //Animacion del muslo desapareciendo y encogiendo
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(galletaImageView, "scaleX", 1.0f, 0.0f);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(galletaImageView, "scaleY", 1.0f, 0.0f);


        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(galletaImageView, "alpha", 1.0f, 0.0f);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator, alphaAnimator);
        animatorSet.setDuration(1200);//Duracion
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());


        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent = new Intent(Arranque.this,Acceder.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });

        animatorSet.start();
    }

}
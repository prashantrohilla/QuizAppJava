package com.mcq.quizapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.mcq.quizapi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Animation scale,translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        scale= AnimationUtils.loadAnimation(this, R.anim.scale);
        translate= AnimationUtils.loadAnimation(this, R.anim.translate);
        binding.android.startAnimation(scale);
        binding.startButton.startAnimation(translate);

        Toast.makeText(MainActivity.this,"Developed by Prashant Rohilla",Toast.LENGTH_SHORT).show();

        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SelectQuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
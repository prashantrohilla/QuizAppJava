package com.mcq.quizapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.mcq.quizapi.Api.ApiClient;
import com.mcq.quizapi.Api.ApiInterface;
import com.mcq.quizapi.Models.QuestionModel;
import com.mcq.quizapi.Response.GetQuestionsResponse;
import com.mcq.quizapi.databinding.ActivityLevelBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static com.mcq.quizapi.SelectQuizActivity.server;

public class LevelActivity extends AppCompatActivity {

    ActivityLevelBinding binding;
    Animation translate, ntranslate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playAnimations();

        final String name = getIntent().getStringExtra("name");

        binding.easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert name != null;
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
                    Intent i = new Intent(LevelActivity.this, QuizActivity.class);
                    i.putExtra("name", name);
                    i.putExtra("level", "1");
                    startActivity(i);
            }
        });

        binding.medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert name != null;
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(LevelActivity.this, QuizActivity.class);
                i.putExtra("name", name);
                i.putExtra("level", "2");
                startActivity(i);
            }
        });
        binding.hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert name != null;
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(LevelActivity.this, QuizActivity.class);
                i.putExtra("name", name);
                i.putExtra("level", "3");
                startActivity(i);
            }
        });

        binding.timerBased.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                assert name != null;
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(LevelActivity.this, DynamicQuizActivity.class);
                i.putExtra("name", name);
                i.putExtra("level", "3");
                startActivity(i);
            }
        });


    }
    public void playAnimations()
    {
        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        ntranslate = AnimationUtils.loadAnimation(this, R.anim.ntranslate);
        binding.easy.startAnimation(translate);
        binding.medium.startAnimation(ntranslate);
        binding.hard.startAnimation(translate);
    }

}
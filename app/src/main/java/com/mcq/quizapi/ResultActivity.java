package com.mcq.quizapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mcq.quizapi.databinding.ActivityResultBinding;

public class ResultActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ActivityResultBinding binding;
        super.onCreate(savedInstanceState);
        binding=ActivityResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent mIntent = getIntent();
        int score = mIntent.getIntExtra("score", 0);

        String correct=Integer.toString(score);
        String incorrect=Integer.toString(10-score);
        String finalscore=Integer.toString(10*score);

        String points="Points";
        binding.correctAnswers.setText(correct);
        binding.wrongAnswers.setText(incorrect);
        binding.score.setText(finalscore+" "+points);
        binding.progressBar.setProgress(Integer.parseInt(finalscore));

        binding.playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ResultActivity.this, SelectQuizActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

    }
}
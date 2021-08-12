package com.mcq.quizapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.mcq.quizapi.Models.QuestionModel;
import com.mcq.quizapi.databinding.ActivityQuizBinding;

import java.util.List;

public class DynamicQuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    Animation translate, ntranslate, scale;
    static boolean op1 = false, op2 = false, op3 = false, op4 = false;
    int score = 0;
    int dscore = 0;
    List<QuestionModel> questionsList;
    int position = 0;
    int p = 1;
    CountDownTimer timer;
    int t = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playAnimations();

        String name = getIntent().getStringExtra("name");
        String level = getIntent().getStringExtra("level");
//        if (level.equals("1")) {
//            position = 0;
//        }
//        if (level.equals("2")) {
//            position = 10;
//        }
//        if (level.equals("3")) {
//            position = 20;
//        }

        if (name.equals("c")) {
            questionsList = SelectQuizActivity.cquestionsList;
        }
        if (name.equals("cpp")) {
            questionsList = SelectQuizActivity.cppquestionsList;
        }
        if (name.equals("csharp")) {
            questionsList = SelectQuizActivity.csharpquestionsList;
        }
        if (name.equals("html")) {
            questionsList = SelectQuizActivity.htmlquestionsList;
        }
        if (name.equals("java")) {
            questionsList = SelectQuizActivity.javaquestionsList;
        }
        if (name.equals("javascript")) {
            questionsList = SelectQuizActivity.javascriptquestionsList;
        }
        if (name.equals("mongodb")) {
            questionsList = SelectQuizActivity.mongodbquestionsList;
        }
        if (name.equals("mysql")) {
            questionsList = SelectQuizActivity.mysqlquestionsList;
        }
        if (name.equals("php")) {
            questionsList = SelectQuizActivity.phpquestionsList;
        }
        if (name.equals("java")) {
            questionsList = SelectQuizActivity.javaquestionsList;
        }

        setQuestions();

        binding.option1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (op1) {
                    binding.option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op1 = false;
                } else {
                    binding.option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.purplestroke));
                    if (op2)
                        binding.option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op3)
                        binding.option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op4)
                        binding.option4.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op1 = true;
                    op2 = false;
                    op3 = false;
                    op4 = false;
                }
            }
        });

        binding.option2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (op2) {
                    binding.option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op2 = false;
                } else {
                    binding.option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.purplestroke));
                    if (op1)
                        binding.option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op3)
                        binding.option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op4)
                        binding.option4.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op2 = true;
                    op1 = false;
                    op3 = false;
                    op4 = false;
                }
            }
        });

        binding.option3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (op3) {
                    binding.option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op3 = false;
                } else {
                    binding.option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.purplestroke));
                    if (op1)
                        binding.option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op2)
                        binding.option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op4)
                        binding.option4.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op3 = true;
                    op2 = false;
                    op1 = false;
                    op4 = false;
                }
            }
        });

        binding.option4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View view) {
                if (op4) {
                    binding.option4.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op4 = false;
                } else {
                    binding.option4.setBackgroundDrawable(getResources().getDrawable(R.drawable.purplestroke));
                    if (op1)
                        binding.option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op2)
                        binding.option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    if (op3)
                        binding.option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
                    op4 = true;
                    op2 = false;
                    op3 = false;
                    op1 = false;
                }
            }
        });


        binding.leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                Intent i = new Intent(DynamicQuizActivity.this, ResultActivity.class);
                i.putExtra("score", score);
                startActivity(i);
                finish();
            }
        });

        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkQuestion();
            }
        });
    }

    private void checkQuestion() {
        if (!op1 & !op2 & !op3 & !op4) {
            Toast.makeText(DynamicQuizActivity.this, "No option selected!!", Toast.LENGTH_SHORT).show();
        }

        String option1 = binding.option1.getText().toString();
        String option2 = binding.option2.getText().toString();
        String option3 = binding.option3.getText().toString();
        String option4 = binding.option4.getText().toString();
        String correctOption = questionsList.get(position).getCorrectOption();

        if (op1) {
            if (option1.equals(correctOption)) {
                score++;
                dscore++;
                Toast.makeText(getApplicationContext(), "Correct Option", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect !!. Correct Option is " + correctOption, Toast.LENGTH_SHORT).show();
            }
        }
        if (op2) {
            if (option2.equals(correctOption)) {
                score++;
                dscore++;
                Toast.makeText(getApplicationContext(), "Correct Option", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect !!. Correct Option is " + correctOption, Toast.LENGTH_SHORT).show();
            }
        }
        if (op3) {
            if (option3.equals(correctOption)) {
                score++;
                dscore++;
                Toast.makeText(getApplicationContext(), "Correct Option", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect !!. Correct Option is " + correctOption, Toast.LENGTH_SHORT).show();
            }
        }
        if (op4) {
            if (option4.equals(correctOption)) {
                score++;
                dscore++;
                Toast.makeText(getApplicationContext(), "Correct Option", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Incorrect !!. Correct Option is " + correctOption, Toast.LENGTH_SHORT).show();
            }
        }

        if (p < 10) // when its 9 it will increment and become 10 and when 10 it break
        {
            p++;
            position++;
            op1 = false;
            op2 = false;
            op3 = false;
            op4 = false;
            binding.option1.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
            binding.option2.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
            binding.option3.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
            binding.option4.setBackgroundDrawable(getResources().getDrawable(R.drawable.squarestroke));
            timer.cancel();
            setQuestions();
        } else {
            timer.cancel();
            Intent i = new Intent(DynamicQuizActivity.this, ResultActivity.class);
            i.putExtra("score", score);
            startActivity(i);
            finish();

        }
    }

    private void setQuestions() {

        checkList();
        String question = questionsList.get(position).getQuestion();
        String option1 = questionsList.get(position).getOption1();
        String option2 = questionsList.get(position).getOption2();
        String option3 = questionsList.get(position).getOption3();
        String option4 = questionsList.get(position).getOption4();
        binding.progressbar.setProgress(p * 10);
        binding.totalQuestion.setText("Question " + p + " / 10");
        binding.score.setText("Score " + score);

        binding.questionNumber.setText(p + "");
        binding.question.setText(question);
        binding.option1.setText(option1);
        binding.option2.setText(option2);
        binding.option3.setText(option3);
        binding.option4.setText(option4);

        t = 16000;
        timer = new CountDownTimer(t, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                binding.timer.setText((millisUntilFinished/1000)+" seconds");
            }

            @Override
            public void onFinish() {
                checkQuestion();
            }
        }.start();
    }

    private void playAnimations() {

        int random = (int) Math.floor(Math.random() * (10 - 1 + 1) + 1);
        switch (random) {
            case 1:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.one));
                break;
            case 2:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.two));
                break;
            case 3:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.three));
                break;
            case 4:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.four));
                break;
            case 5:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.five));
                break;

            case 6:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.six));
                break;
            case 7:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.seven));
                break;
            case 8:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.eight));
                break;
            case 9:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.nine));
                break;
            case 10:
                binding.layoutbackground.setBackgroundDrawable(getResources().getDrawable(R.drawable.ten));
                break;
        }

        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        ntranslate = AnimationUtils.loadAnimation(this, R.anim.ntranslate);
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        binding.questionNumber.startAnimation(scale);
        binding.option1.startAnimation(translate);
        binding.option2.startAnimation(ntranslate);
        binding.option3.startAnimation(translate);
        binding.option4.startAnimation(ntranslate);
    }

    public void checkList()
    {
        if(p==3)
        {
            if(dscore==1)
            {
                position+=10;
            }
            if(dscore==2)
            {
                position+=20;
            }
            dscore=0;
        }

        if(p==5)
        {
            if(dscore==0)
            {
                if(position>10 && position<20){ position-=10; }
                if(position>20){ position-=20; }
            }
            if(dscore==1)
            {
                if(position<10){ position+=10; }
                if(position>10 && position<20){ position+=10; }
            }
            if(dscore==2)
            {
                if(position<10){ position+=20; }
                if(position>10 && position<20){ position+=10; }
            }
            dscore=0;
        }

        if(p==7)
        {
            if(dscore==0)
            {
                if(position>10 && position<20){ position-=10; }
                if(position>20){ position-=20; }
            }
            if(dscore==1)
            {
                if(position<10){ position+=10; }
                if(position>10 && position<20){ position+=10; }
            }
            if(dscore==2)
            {
                if(position<10){ position+=20; }
                if(position>10 && position<20){ position+=10; }
            }
            dscore=0;
        }

        if(p==9)
        {
            if(dscore==0)
            {
                if(position>10 && position<20){ position-=10; }
                if(position>20){ position-=20; }
            }
            if(dscore==1)
            {
                if(position<10){ position+=10; }
                if(position>10 && position<20){ position+=10; }
            }
            if(dscore==2)
            {
                if(position<10){ position+=20; }
                if(position>10 && position<20){ position+=10; }
            }
            dscore=0;
        }
    }

}
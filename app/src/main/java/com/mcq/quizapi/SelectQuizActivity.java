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
import com.mcq.quizapi.databinding.ActivitySelectQuizBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SelectQuizActivity extends AppCompatActivity {
    ActivitySelectQuizBinding binding;
    Animation scale, translate;
    ApiInterface apiInterface;
    static List<QuestionModel> cppquestionsList;
    static List<QuestionModel> cquestionsList;
    static List<QuestionModel> csharpquestionsList;
    static List<QuestionModel> htmlquestionsList;
    static List<QuestionModel> javaquestionsList;
    static List<QuestionModel> javascriptquestionsList;
    static List<QuestionModel> mongodbquestionsList;
    static List<QuestionModel> mysqlquestionsList;
    static List<QuestionModel> phpquestionsList;
    static List<QuestionModel> pythonquestionsList;
    static boolean server=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySelectQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        playAnimations();
        Retrofit retrofit = ApiClient.getclient();  // we will call our static method here
        apiInterface = retrofit.create(ApiInterface.class); // we have initialised api interface

        binding.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.cpp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCppQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.java.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJavaQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


        binding.python.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPythonQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.html.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getHtmlQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });


        binding.javascript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getJavascriptQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.csharp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCsharpQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.php.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPhpQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

        binding.mongodb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMongodbQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        binding.mysql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getMysqlQuestions();
                if (!server)
                {
                    Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }

    public void playAnimations() {
        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        translate = AnimationUtils.loadAnimation(this, R.anim.translate);
        binding.c.startAnimation(scale);
        binding.cpp.startAnimation(scale);
        binding.java.startAnimation(scale);
        binding.python.startAnimation(scale);
        binding.html.startAnimation(scale);
        binding.javascript.startAnimation(scale);
        binding.csharp.startAnimation(scale);
        binding.mysql.startAnimation(scale);
        binding.php.startAnimation(scale);
        binding.mongodb.startAnimation(scale);
    }

    private void getCQuestions() // for api calling
    { // getting questions defined in api interface
        apiInterface.getCQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            cquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "c");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCppQuestions()
    {
        apiInterface.getCppQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            cppquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "cpp");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getCsharpQuestions()
    {
        apiInterface.getCsharpQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            csharpquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "csharp");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getHtmlQuestions()
    {
        apiInterface.getHtmlQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            htmlquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "html");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getJavaQuestions()
    {
        apiInterface.getJavaQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            javaquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "java");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getJavascriptQuestions()
    {
        apiInterface.getJavascriptQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            javascriptquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "javascript");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMongodbQuestions()
    {
        apiInterface.getMongodbQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            mongodbquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "mongodb");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getMysqlQuestions()
    {
        apiInterface.getMysqlQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            mysqlquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "mysql");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPhpQuestions()
    {
        apiInterface.getPhpQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            phpquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "php");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPythonQuestions()
    {
        apiInterface.getPythonQuestions().enqueue(new Callback<GetQuestionsResponse>() {
            @Override
            public void onResponse(Call<GetQuestionsResponse> call, Response<GetQuestionsResponse> response) {
                try {

                    if (response != null) {
                        if (response.body().getStatus().equals("1")) {  // data is coming
                            pythonquestionsList=response.body().getData();
                            Intent intent = new Intent(getApplicationContext(), LevelActivity.class);
                            intent.putExtra("name", "python");
                            startActivity(intent);
                        } else {  // failure case
                            Toast.makeText(getApplicationContext(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("exp", e.getLocalizedMessage());
                }
            }
            @Override
            public void onFailure(Call<GetQuestionsResponse> call, Throwable t) {
                Log.e("failure", t.getLocalizedMessage());
                server=false;
                // Toast.makeText(getApplicationContext(), "Serve is offline. Try again later.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
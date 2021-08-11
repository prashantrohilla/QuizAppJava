package com.mcq.quizapi.Api;

import com.mcq.quizapi.Models.QuestionModel;
import com.mcq.quizapi.Response.GetQuestionsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface { // here we will make all methods

    @GET("getcquestions.php")
    Call<GetQuestionsResponse> getCQuestions(); //1

    @GET("getcppquestions.php")
    Call<GetQuestionsResponse> getCppQuestions();

    @GET("getcsharpquestions.php")
    Call<GetQuestionsResponse> getCsharpQuestions();

    @GET("gethtmlquestions.php")
    Call<GetQuestionsResponse> getHtmlQuestions();

    @GET("getjavaquestions.php")
    Call<GetQuestionsResponse> getJavaQuestions(); // 5

    @GET("getjavascriptquestions.php")
    Call<GetQuestionsResponse> getJavascriptQuestions(); // 6

    @GET("getmongodbquestions.php")
    Call<GetQuestionsResponse> getMongodbQuestions();

    @GET("getmysqlquestions.php")
    Call<GetQuestionsResponse> getMysqlQuestions();

    @GET("getphpquestions.php")
    Call<GetQuestionsResponse> getPhpQuestions();

    @GET("getpythonquestions.php")
    Call<GetQuestionsResponse> getPythonQuestions();  //10



//    @GET("getcquestions.php")
//    Call<List<QuestionModel>> getCQuestions();
}

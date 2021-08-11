package com.mcq.quizapi.Response;

import com.mcq.quizapi.Models.QuestionModel;

import java.util.List;

public class GetQuestionsResponse {

    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<QuestionModel> getData() {
        return data;
    }

    public void setData(List<QuestionModel> data) {
        this.data = data;
    }

    String message;
    List<QuestionModel> data;

    public GetQuestionsResponse(String status, String message, List<QuestionModel> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}

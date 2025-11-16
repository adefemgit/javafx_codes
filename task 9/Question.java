package com.quizapp.model;

public class Question {
    public int questionId;
    public int quizId;
    public String questionText;
    public Type type;
    public int points;

    public enum Type { MCQ, TrueFalse, ShortAnswer }
}

package com.example.pole_chudes;

public class Question {
    private String questionText;
    private String answerText;
    public Question(String question, String answer) {
        this.questionText = question;
        this.answerText = answer;
    }

    public String getQuestion() {
        return questionText;
    }

    public String getAnswer() {
        return answerText;
    }

    public String getGuessedText() {
        return "*".repeat("энциклопедия".length());
    }
}

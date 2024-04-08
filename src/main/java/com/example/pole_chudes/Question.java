package com.example.pole_chudes;

public class Question {
    private String questionText;
    private String answerText;
    private String guessedText;
    public Question(String question, String answer) {
        this.questionText = question;
        this.answerText = answer;
        this.guessedText = "*".repeat(answer.length());
    }

    public String getQuestion() {
        return questionText;
    }

    public String getAnswer() {
        return answerText;
    }

    public String getGuessedText() {
        return guessedText;
    }

    public void cheсkingLetter(String letter) {
        guessedText = "***и******и*";
    }
}

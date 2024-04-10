package com.example.pole_chudes;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String questionText;
    private String answerText;
    private String guessedText;
    private List<Character> usedLetters;
    public Question(String question, String answer) {
        this.questionText = question;
        this.answerText = answer;
        this.guessedText = "*".repeat(answer.length());
        this.usedLetters = new ArrayList<>();
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

    public boolean checkingLetter(String letter) {
        if (answerText.contains(letter)) {
            for (int i = 0; i < answerText.length(); i += 1) {
                if (answerText.charAt(i) == letter.charAt(0)) {
                    if (i < answerText.length() + 1)
                        guessedText = guessedText.substring(0, i) + letter + guessedText.substring(i + 1);
                    else
                        guessedText = guessedText.substring(0, i) + letter;
                }
            }
            return true;
        }
        else
            return false;
    }

    public boolean checkLetter(String letter) {
        if (!usedLetters.contains(letter.charAt(0))) {
            usedLetters.add(letter.charAt(0));
            return true;
        }
        else
            return false;
    }
}

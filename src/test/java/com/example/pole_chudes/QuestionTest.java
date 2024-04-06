package com.example.pole_chudes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    @Test
    void setQuestion() {
        Question question = new Question("Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?", "энциклопедия");
        String questionText = "Однажды в знаменитую французскую тюрьму Бастилию заключили не человека, " +
                "а некое издание. Какое?";
        String answerText = "энциклопедия";
        assertEquals(questionText, question.getQuestion());
        assertEquals(answerText, question.getAnswer());
    }
}
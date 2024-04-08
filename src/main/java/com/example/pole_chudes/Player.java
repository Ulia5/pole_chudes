package com.example.pole_chudes;

public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int newPoints) {
        points += newPoints;
    }

    public boolean giveAnswer(Question question, String letter, int newPoint) {
        if (question.checkingLetter(letter)) {
            addPoints(newPoint);
            return true;
        }
        else
            return false;
    }
}

package com.example.qpc1.newquestion;

public class Question {
    private int id;
    private String question;
    private String resultA, resultB, resultC, resultD;
    private int correctResult;
    private String explain;

    public Question(int id, String question, String resultA, String resultB, String resultC, String resultD, int correctResult, String explain) {
        this.id = id;
        this.question = question;
        this.resultA = resultA;
        this.resultB = resultB;
        this.resultC = resultC;
        this.resultD = resultD;
        this.correctResult = correctResult;
        this.explain = explain;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResultA() {
        return resultA;
    }

    public void setResultA(String resultA) {
        this.resultA = resultA;
    }

    public String getResultB() {
        return resultB;
    }

    public void setResultB(String resultB) {
        this.resultB = resultB;
    }

    public String getResultC() {
        return resultC;
    }

    public void setResultC(String resultC) {
        this.resultC = resultC;
    }

    public String getResultD() {
        return resultD;
    }

    public void setResultD(String resultD) {
        this.resultD = resultD;
    }

    public int getCorrectResult() {
        return correctResult;
    }

    public void setCorrectResult(int correctResult) {
        this.correctResult = correctResult;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}

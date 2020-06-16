package com.company;

public class Question {
    private String Question;
    private String ratingType;
    private String answer;
    private String findings;

    public Question(){}

    public Question(String question, String ratingType, String answer, String findings) {
        Question = question;
        this.ratingType = ratingType;
        this.answer = answer;
        this.findings = findings;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getRatingType() {
        return ratingType;
    }

    public void setRatingType(String ratingType) {
        this.ratingType = ratingType;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFindings() {
        return findings;
    }

    public void setFindings(String findings) {
        this.findings = findings;
    }
}

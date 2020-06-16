package com.company;

import java.util.Objects;

public class Question {
    private String question;
    private String ratingType;
    private String answer;
    private String findings;

    public Question(){
        this.question = "";
        this.ratingType="";
        this.answer="";
        this.findings="";
    }

    public Question(String question, String ratingType, String answer, String findings) {
        this.question = question;
        this.ratingType = ratingType;
        this.answer = answer;
        this.findings = findings;
    }

    public boolean isQuestionNotEmpty(){
        String s1= "Action required to verify";
        String s2= "In Field/ Desktop";
        String s3= "Rating (Green, Red, NA)";
        String s4= "Compliance to Criteria (Findings, Observations; Actions- training? Filing? Communication? Procedure review? Other?)";

        if ((this.question != "" && this.ratingType != ""
        && this.answer != "" && this.findings != "") && !this.question.equals(s1) && !this.ratingType.equals(s2) &&
                !this.answer.equals(s3) && !this.findings.equals(s4)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "(" +
                "question='" + question + '\'' +
                ", ratingType='" + ratingType + '\'' +
                ", answer='" + answer + '\'' +
                ", findings='" + findings + '\'' +
                ')';
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

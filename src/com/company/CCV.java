package com.company;

import java.util.ArrayList;
import java.util.List;

public class CCV {
    private String auditDate;
    private String regoName;
    private String auditor;
    private List questions = new ArrayList<Question>();

    @Override
    public String toString() {
        String questionList = "";
        int i = 1;
        for (Object item : this.questions) {
            questionList = questionList + "\nQuestion "+ i + item.toString();
            i++;
        }

        return "CCV{" +
                "auditDate= '" + auditDate + '\'' +
                ", regoName= '" + regoName + '\'' +
                ", auditor= '" + auditor + '\'' +
                "\nQuestions\n##########################################################################################"
                + questionList +
                "\n##########################################################################################";
    }

    public CCV(){};

    public String getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(String auditDate) {
        this.auditDate = auditDate;
    }

    public String getRegoName() {
        return regoName;
    }

    public void setRegoName(String regoName) {
        this.regoName = regoName;
    }

    public List getQuestions() {
        return questions;
    }

    public void setQuestions(List questions) {
        this.questions = questions;
    }

    public String getAuditor() { return auditor; }

    public void setAuditor(String auditor) { this.auditor = auditor; }
}

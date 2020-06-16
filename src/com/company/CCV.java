package com.company;

import java.util.ArrayList;
import java.util.List;

public class CCV {
    private String auditDate;
    private String regoName;
    private List questions;

    public CCV(){};

    public CCV(String auditDate, String regoName, List questions) {
        this.auditDate = auditDate;
        this.regoName = regoName;
        this.questions = questions;
    }

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
}

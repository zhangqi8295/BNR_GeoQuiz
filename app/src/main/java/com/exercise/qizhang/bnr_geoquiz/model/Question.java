package com.exercise.qizhang.bnr_geoquiz.model;

public class Question {
    private int questionId;
    private boolean mAnswerTrue;

    public Question() {
    }

    public Question(int questionId, boolean mAnswerTrue) {
        this.questionId = questionId;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean ismAnswerTrue() {
        return mAnswerTrue;
    }

    public void setmAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}

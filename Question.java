package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int questionId;
    private int ans1;
    private int ans2;
    private int ans3;
    private int ans4;

    private int answerCorr;


    public Question(int questionId, int answerCorr, int ans1, int ans2, int ans3, int ans4)
    {
        this.questionId = questionId;
        this.answerCorr = answerCorr;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ans4 = ans4;

    }

    public int getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(int questionId)
    {
        this.questionId = questionId;
    }

    public int getAnswerCorr()
    {
        return answerCorr;
    }

    public boolean checkCorrAns(int ans)
    {
        return ans == answerCorr;
    }

    public List<Integer> getAnswers()
    {
        //List<Integer> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        integers.add(ans1);
        integers.add(ans2);
        integers.add(ans3);
        integers.add(ans4);
        return integers;
    }
}

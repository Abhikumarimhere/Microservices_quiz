package com.Abhishek.QuizService.entity;

import lombok.Data;

@Data
public class QuestionWrapper {

    private Long id;
    private String Questions;
    private String Option1;
    private String Option2;
    private String Option3;
    private String Option4;
    public QuestionWrapper(Long id, String questions, String option1, String option2, String option3, String option4) {
        this.id = id;
        Questions = questions;
        Option1 = option1;
        Option2 = option2;
        Option3 = option3;
        Option4 = option4;

    }

}

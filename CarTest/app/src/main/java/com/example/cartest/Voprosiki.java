package com.example.cartest;

public class Voprosiki {

    // Создание вопросов и ответов
    private String questions, ans_1, ans_2, ans_3, ans_4, correct;

    // Создание конструктора класса
    // В нем определяются все переменные, помещая в себя значение из вызова класса
    public Voprosiki(String questions, String ans_1, String ans_2, String ans_3, String ans_4, String correct) {
        this.questions = questions;
        this.ans_1 = ans_1;
        this.ans_2 = ans_2;
        this.ans_3 = ans_3;
        this.ans_4 = ans_4;
        this.correct = correct;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getAns_1() {
        return ans_1;
    }

    public void setAns_1(String ans_1) {
        this.ans_1 = ans_1;
    }

    public String getAns_2() {
        return ans_2;
    }

    public void setAns_2(String ans_2) {
        this.ans_2 = ans_2;
    }

    public String getAns_3() {
        return ans_3;
    }

    public void setAns_3(String ans_3) {
        this.ans_3 = ans_3;
    }

    public String getAns_4() {
        return ans_4;
    }

    public void setAns_4(String ans_4) {
        this.ans_4 = ans_4;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}

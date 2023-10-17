package org.chapter.chapter5.exercise6;

public class AdditionQuestion {

    private int a, b;  // 문제에서 사용되는 숫자.

    public AdditionQuestion() { // 생성자
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }

    public String getQuestion() {
        return a + " + " + b + " 은(는) 얼마인가요?";
    }

    public int getCorrectAnswer() {
        return a + b;
    }

}

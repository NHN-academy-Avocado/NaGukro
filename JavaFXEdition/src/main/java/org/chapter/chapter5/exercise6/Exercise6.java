package org.chapter.chapter5.exercise6;

import org.chapter.chapter5.exercise5.TextIO;

/**
 * 이 프로그램은 사용자에게 10개의 덧셈 퀴즈 문제를 출제합니다.
 * 문제에 사용되는 숫자는 무작위로 선택됩니다.
 * 숫자와 정답은 1 또는 2 자릿수입니다.
 * 사용자에게 10개의 질문을 하고, 컴퓨터는 퀴즈를 채점하여 사용자에게 틀린 문제에 대한 올바른 답변을 제공합니다.
 */
public class Exercise6 {

    private static AdditionQuestion[] questions;  // 퀴즈의 질문들

    private static int[] userAnswers;   // 사용자의 10개 질문에 대한 답변


    public static void main(String[] args) {
        System.out.println();
        System.out.println("덧셈 퀴즈에 오신 것을 환영합니다!");
        System.out.println();
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }


    /**
     * 퀴즈 질문을 저장하는 객체 배열을 생성합니다.
     */
    private static void createQuiz() {
        questions = new AdditionQuestion[10];
        for ( int i = 0; i < 10; i++ ) {
            questions[i] = new AdditionQuestion();
        }
    }


    /**
     * 사용자에게 10개의 퀴즈 질문을 하고 사용자의 답변을 저장합니다.
     * 답변은 이 서브 루틴에서 생성된 배열에 저장됩니다.
     */
    private static void administerQuiz() {
        userAnswers = new int[10];
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("질문 %2d:  %s ",
                    questionNum, questions[i].getQuestion());
            userAnswers[i] = TextIO.getlnInt();
        }
    }


    /**
     * 모든 문제와 정답을 표시하고 퀴즈에 대한 등급을 계산합니다.
     * 각 질문에 대해 사용자에게 정답 여부가 알려집니다.
     */
    private static void gradeQuiz() {
        System.out.println();
        System.out.println("다음은 올바른 답변입니다:");
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("   질문 %2d:  %s  정답은 %d 입니다  ",
                    questionNum, questions[i].getQuestion(), questions[i].getCorrectAnswer());
            if ( userAnswers[i] == questions[i].getCorrectAnswer() ) {
                System.out.println("정답입니다.");
                numberCorrect++;
            }
            else {
                System.out.println("당신은 " + userAnswers[i] + "라고 했는데, 이것은 틀렸습니다.");
            }
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("정답한 질문 수: " + numberCorrect + "개.");
        System.out.println("퀴즈 등급: " + grade);
        System.out.println();
    }

} // end class AdditionQuizWithObjects


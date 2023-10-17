package org.chapter.chapter5.exercise7;

import org.chapter.chapter5.exercise5.TextIO;

/**
 * 이 프로그램은 정수 답변을 가진 열 개의 질문으로 구성된 퀴즈를 생성, 관리 및 채점합니다.
 * 각 질문은 정수 답변을 가지며, 퀴즈에는 간단한 덧셈 문제, 뺄셈 문제 및 수학이 아닌 문제가 포함되어 있습니다.
 */
public class Exercise7 {

    // -------------------- 중첩 클래스와 인터페이스 -----------------------

    interface IntQuestion {
        public String getQuestion();

        public int getCorrectAnswer();
    }

    static class AdditionQuestion implements IntQuestion {
        private int a, b;  // 문제의 숫자입니다.

        public AdditionQuestion() { // 생성자
            a = (int) (Math.random() * 50 + 1);
            b = (int) (Math.random() * 50);
        }

        public String getQuestion() {
            return a + " + " + b + " 은(는) 무엇인가요?";
        }

        public int getCorrectAnswer() {
            return a + b;
        }
    }

    static class SubtractionQuestion implements IntQuestion {
        private int a, b;  // 문제의 숫자입니다.

        public SubtractionQuestion() { // 생성자
            a = (int) (Math.random() * 50 + 1);
            b = (int) (Math.random() * 50);
            if (b > a) { // a와 b를 교환하여 답이 음수가 되지 않도록 합니다.
                int temp = a;
                a = b;
                b = temp;
            }
        }

        public String getQuestion() {
            return a + " - " + b + " 은(는) 무엇인가요?";
        }

        public int getCorrectAnswer() {
            return a - b;
        }
    }

    // -------------------- 프로그램 --------------------------------------

    private static IntQuestion[] questions;  // 퀴즈의 질문

    private static int[] userAnswers;   // 사용자의 열 개 질문에 대한 답변

    public static void main(String[] args) {
        System.out.println();
        System.out.println("퀴즈에 오신 것을 환영합니다");
        System.out.println();
        System.out.println("일부 수학 문제와 일부 비수학 문제가 있지만");
        System.out.println("모든 문제의 답은 정수입니다.");
        System.out.println();
        createQuiz();
        administerQuiz();
        gradeQuiz();
    }

    /**
     * 퀴즈 질문을 저장하는 객체 배열을 생성합니다.
     */
    private static void createQuiz() {
        questions = new IntQuestion[10];
        for (int i = 0; i < 7; i++) {
            if (Math.random() < 0.5)
                questions[i] = new AdditionQuestion();
            else
                questions[i] = new SubtractionQuestion();
        }
        questions[7] = new IntQuestion() {
            public String getQuestion() {
                return "미국에는 몇 개의 주가 있나요?";
            }

            public int getCorrectAnswer() {
                return 50;
            }
        };
        questions[8] = new IntQuestion() {
            public String getQuestion() {
                return "제1차 세계 대전은 몇 년에 시작했나요?";
            }

            public int getCorrectAnswer() {
                return 1914;
            }
        };
        questions[9] = new IntQuestion() {
            public String getQuestion() {
                return "생명, 우주 및 모든 것의 궁극적인 질문의 답은 무엇인가요?";
            }

            public int getCorrectAnswer() {
                return 42;
            }
        };
    }

    /**
     * 사용자에게 열 개의 퀴즈 질문을 하고 사용자의 답변을 저장합니다.
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
     * 모든 질문과 정답을 표시하고 퀴즈를 평가합니다. 각 질문에 대해 사용자에게 답이 옳은지 알려줍니다.
     */
    private static void gradeQuiz() {
        System.out.println();
        System.out.println("여기는 정답입니다:");
        System.out.println();
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            System.out.println("질문 번호 " + (i + 1) + ":");
            System.out.println("    " + questions[i].getQuestion());
            System.out.println("    정답:  " + questions[i].getCorrectAnswer());
            if (userAnswers[i] == questions[i].getCorrectAnswer()) {
                System.out.println("    정답입니다.");
                numberCorrect++;
            } else {
                System.out.println("    당신의 답: " + userAnswers[i] + ", 틀렸습니다.");
            }
            System.out.println();
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("당신은 " + numberCorrect + " 개의 질문을 맞췄습니다.");
        System.out.println("퀴즈 점수: " + grade);
        System.out.println();
    }

}


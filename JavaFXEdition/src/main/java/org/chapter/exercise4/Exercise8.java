package org.chapter.exercise4;

/**
 * 이 프로그램은 사용자에게 10개의 덧셈 문제 퀴즈를 출제합니다. 문제의 숫자는 무작위로 선택됩니다.
 * 숫자와 답변은 1자리 또는 2자리 숫자입니다. 사용자에게 10개의 문제를 묻은 후, 컴퓨터는 퀴즈를 채점하고
 * 사용자에게 틀린 문제의 정답을 알려줍니다.
 */
public class Exercise8 {


    public static void main(String[] args) {
        int[] firstNums = new int[10];  // 10개 문제의 첫 번째 숫자
        int[] secondNums = new int[10]; // 10개 문제의 두 번째 숫자
        int[] answers = new int[10];    // 사용자의 답변
        System.out.println();
        System.out.println("덧셈 퀴즈에 오신 것을 환영합니다!");
        System.out.println();
        createQuiz(firstNums, secondNums);
        administerQuiz(firstNums, secondNums, answers);
        gradeQuiz(firstNums, secondNums, answers);
    }


    /**
     * 문제에 대한 숫자를 저장할 배열을 생성하고, 해당 배열을 무작위 숫자로 채웁니다.
     * 매개변수는 각 덧셈 문제의 첫 번째 및 두 번째 피연산자를 보관할 배열입니다.
     * 이 서브루틴이 호출될 때 이 배열들은 이미 만들어져 있어야 합니다!
     */
    private static void createQuiz(int[] firstNumbers, int[] secondNumbers) {
        for (int i = 0; i < 10; i++) {
            firstNumbers[i] = (int)(Math.random() * 50 + 1);  // 1에서 50 사이의 범위
            secondNumbers[i] = (int)(Math.random() * 50);    // 0에서 49 사이의 범위
        }
    }


    /**
     * 사용자에게 각각의 10개 퀴즈 문제를 묻고 사용자의 답변을 저장합니다.
     * 첫 번째 두 매개변수는 퀴즈 문제에 대한 피연산자를 보관합니다.
     * 세 번째 배열에는 사용자의 10개 문제에 대한 답변이 저장됩니다.
     * 이 서브루틴이 호출될 때 모든 배열들은 이미 생성되어 있어야 합니다.
     */
    private static void administerQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            System.out.printf("문제 %2d:  %2d + %2d 은(는) 얼마인가요? ",
                    questionNum, firstNumbers[i], secondNumbers[i]);
            userAnswers[i] = TextIO.getlnInt();
        }
    }


    /**
     * 모든 문제와 해당하는 정답을 표시하고 퀴즈에 대한 등급을 계산합니다.
     * 각 문제에 대해 사용자에게 정답 여부를 알려줍니다.
     * 첫 번째 두 매개변수는 퀴즈 문제에 대한 피연산자를 보관하고,
     * 세 번째 매개변수는 사용자가 퀴즈에 대해 제출한 답변을 보관합니다.
     */
    private static void gradeQuiz(int[] firstNumbers, int[] secondNumbers, int[] userAnswers) {
        System.out.println();
        System.out.println("다음은 정답입니다:");
        int numberCorrect = 0;
        int grade;
        for (int i = 0; i < 10; i++) {
            int questionNum = i + 1;
            int correctAnswer = firstNumbers[i] + secondNumbers[i];
            System.out.printf("   문제 %2d:  %2d + %2d  =  %2d.  ",
                    questionNum, firstNumbers[i], secondNumbers[i], correctAnswer);
            if (userAnswers[i] == correctAnswer) {
                System.out.println("정답입니다.");
                numberCorrect++;
            } else {
                System.out.println("당신의 답변은 " + userAnswers[i] + "으로, 틀렸습니다.");
            }
        }
        grade = numberCorrect * 10;
        System.out.println();
        System.out.println("정답 수: " + numberCorrect + "개.");
        System.out.println("퀴즈 등급: " + grade);
        System.out.println();
    }

}  // end class AdditionQuizNoGlobals

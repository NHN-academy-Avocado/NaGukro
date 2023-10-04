package org.example.chapter10.exercise;

public class Exercise6 {

    public static int longestConsecutiveCharSequence(String s, char c) {
        return longestConsecutiveCharSequenceHelper(s, c, 0, 0, 0);
    }

    private static int longestConsecutiveCharSequenceHelper(String s, char c, int index, int currentCount, int maxCount) {
        if (index == s.length()) {
            // Base case: 인덱스가 문자열 끝에 도달하면 탈출
            return maxCount;
        } else {
            if (s.charAt(index) == c) {
                //글자가 같으면 카운트 증가
                currentCount++;
            } else {
                //현재 카운트와 최댓값 비교해서 교체
                maxCount = Math.max(currentCount, maxCount);
                //현재 카운트 초기화
                currentCount = 0;
            }
            //재귀
            return longestConsecutiveCharSequenceHelper(s, c, index + 1, currentCount, maxCount); //증감식 index+1
        }
    }

    public static void main(String[] args) {
        String s = "aabcccaaaadefggg";
        char c = 'a';
        System.out.println("글자 " + c + "가" + s + "안에서 연속하는 숫자 중 가장 큰 숫자는" + longestConsecutiveCharSequence(s, c));
    }
}

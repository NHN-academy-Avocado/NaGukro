package org.example.chapter11.exercise;

public class Exercise2 {
    public static void main(String[] args) {
        ListNode lis = new ListNode("One");
        lis.next = new ListNode("Two");
        lis.next.next = new ListNode("Three");
        lis.next.next.next = new ListNode("Three");
        lis.next.next.next.next = new ListNode("Three");
        // length 메서드를 호출하고 결과를 출력합니다.
        System.out.println("리스트의 길이: " + length(lis));


//        insertAfter(lis, "이후 추가", "Two");
//        lis = insertBefore(lis, "이전 추가", "Two");

        // 첫 번째 출현의 "Two"를 "NewNode"로 변경합니다.
//        lis = modify(lis, "Two", "바꾸기");
        // "Three"라는 문자열의 모든 출현을 "NewNode"로 변경합니다.
//        lis = modifyAll(lis, "Three", "모두바꾸기");

        // 수정된 리스트를 출력합니다.
        ListNode current = lis;
        while (current != null) {
            System.out.println(current.info);
            current = current.next;
        }

        // invert 메서드를 사용하여 리스트를 반전시킵니다.
//        lis = invert(lis);
//
//        // 반전된 리스트를 출력합니다.
//        System.out.println("반전된 리스트:");
//        current = lis;
//        while (current != null) {
//            System.out.println(current.info);
//            current = current.next;
//        }
//
        // deleteDoubles 메서드를 사용하여 리스트에서 중복된 원소들을 제거합니다.
        lis = deleteDoubles(lis);
//
        // 중복된 원소들이 제거된 리스트를 출력합니다.
        System.out.println("중복 원소 제거된 리스트:");
        current = lis;
        while (current != null) {
            System.out.println(current.info);
            current = current.next;
        }

    }

    public static int length(ListNode lis) {
        // 재귀 호출의 기저 조건: 현재 노드가 null이면, 리스트의 끝에 도달한 것이므로 0을 반환합니다.
        if (lis == null) {
            return 0;
        }
        // 현재 노드가 null이 아니면, 현재 노드를 포함하여 1을 더하고, next 노드에 대해 재귀적으로 length 메서드를 호출합니다.
        return 1 + length(lis.next);
    }

    public static ListNode insertAfter(ListNode lis, String s, String given) {
        // 재귀 호출의 탈출 조건: 현재 노드가 null이면, 리스트의 끝에 도달한 것이므로 리스트를 그대로 반환합니다.
        if (lis == null) {
            return lis;
        }

        // 현재 노드의 값이 주어진 원소와 일치하는 경우
        if (lis.info.equals(given)) {
            ListNode newNode = new ListNode(s); // 새 노드를 생성합니다.
            newNode.next = lis.next; // 새 노드의 다음 노드를 현재 노드의 다음 노드로 설정합니다.
            lis.next = newNode; // 현재 노드의 다음 노드를 새 노드로 설정합니다.
            return lis; // 새 노드를 추가한 리스트를 반환합니다.
        }

        // 현재 노드의 값이 주어진 원소와 일치하지 않으면, 다음 노드로 이동하여 재귀 호출을 수행합니다.
        lis.next = insertAfter(lis.next, s, given);
        return lis; // 수정된 리스트를 반환합니다.
    }


    public static ListNode modify(ListNode lis, String old, String ne) {
        // 재귀 호출의 기저 조건: 현재 노드가 null이면, 리스트의 끝에 도달한 것이므로 리스트를 그대로 반환합니다.
        if (lis == null) {
            return lis;
        }

        // 현재 노드의 값이 찾고자 하는 값과 일치하는 경우
        if (lis.info.equals(old)) {
            lis.info = ne; // 노드의 값을 변경합니다.
            return lis; // 값을 변경한 리스트를 반환합니다.
        }

        // 현재 노드의 값이 찾고자 하는 값과 일치하지 않으면, 다음 노드로 이동하여 재귀 호출을 수행합니다.
        lis.next = modify(lis.next, old, ne);
        return lis; // 수정된 리스트를 반환합니다.
    }

    public static ListNode modifyAll(ListNode lis, String old, String ne) {
        // 재귀 호출의 기저 조건: 현재 노드가 null이면, 리스트의 끝에 도달한 것이므로 리스트를 그대로 반환합니다.
        if (lis == null) {
            return lis;
        }

        // 현재 노드의 값이 찾고자 하는 값과 일치하는 경우
        if (lis.info.equals(old)) {
            lis.info = ne; // 노드의 값을 변경합니다.
        }

        // 현재 노드의 값이 찾고자 하는 값과 일치하더라도, 리스트의 나머지 부분에서도 계속 찾아야 하므로
        // 다음 노드로 이동하여 재귀 호출을 수행합니다.
        lis.next = modifyAll(lis.next, old, ne);
        return lis; // 수정된 리스트를 반환합니다.
    }


    public static ListNode insertBefore(ListNode lis, String s, String given) {
        // 기저 사례: 리스트의 끝에 도달한 경우, 삽입하지 않고 그대로 반환
        if (lis == null) {
            return null;
        }

        // 현재 노드가 주어진 값과 일치하는 경우
        if (lis.info.equals(given)) {
            // 새 노드를 생성하고, 현재 노드를 그 노드의 다음 노드로 설정
            ListNode newNode = new ListNode(s);
            newNode.next = lis;
            return newNode; // 새로운 노드가 이제 리스트의 헤드입니다.
        }

        // 현재 노드가 주어진 값과 일치하지 않는 경우, 리스트의 다음 부분을 확인
        lis.next = insertBefore(lis.next, s, given);
        return lis; // 리스트의 헤드를 반환
    }


    public static ListNode copy(ListNode lis) {
        // 기저 조건: 현재 노드가 null인 경우, null을 반환합니다.
        if (lis == null) {
            return null;
        }

        // 현재 노드의 값을 가지는 새 노드를 생성합니다.
        ListNode newNode = new ListNode(lis.info);

        // 재귀 호출을 사용하여 현재 노드의 다음 노드를 복사하고,
        // 새로운 노드의 다음 노드로 설정합니다.
        newNode.next = copy(lis.next);

        // 복사된 노드를 반환합니다.
        return newNode;
    }

    public static ListNode invert(ListNode lis) {
        // 기저 조건: lis가 null이거나 마지막 노드인 경우 lis를 반환합니다.
        if (lis == null || lis.next == null) {
            return lis;
        }

        // 재귀 호출을 사용하여 리스트의 나머지 부분을 반전시킵니다.
        ListNode restInverted = invert(lis.next);

        // 현재 노드의 다음 노드의 next를 현재 노드로 설정하여 링크를 반전시킵니다.
        lis.next.next = lis;
        // 현재 노드의 next를 null로 설정합니다.
        lis.next = null;

        // 반전된 리스트의 헤드를 반환합니다.
        return restInverted;
    }


    public static ListNode deleteDoubles(ListNode lis) {
        // 기저 조건: lis가 null인 경우, null을 반환합니다.
        if (lis == null) {
            return null;
        }

        // 재귀 호출을 사용하여 리스트의 나머지 부분에서 중복을 제거합니다.
        ListNode nextNode = deleteDoubles(lis.next);

        // nextNode 리스트에서 현재 노드의 값과 같은 노드를 제거합니다.
        ListNode current = nextNode;
        ListNode prev = null;
        while (current != null) {
            if (current.info.equals(lis.info)) {
                if (prev != null) {
                    prev.next = current.next;
                } else {
                    nextNode = current.next;
                }
            } else {
                prev = current;
            }
            current = current.next;
        }

        // 현재 노드의 다음 노드를 업데이트합니다.
        lis.next = nextNode;

        // 수정된 리스트를 반환합니다.
        return lis;
    }


    public static boolean searchSequence(ListNode lis1, ListNode lis2) {
        // lis2가 null인 경우, lis2는 모든 리스트의 부분 수열입니다.
        if (lis2 == null) {
            return true;
        }

        // lis1이 null인 경우, lis2는 lis1의 부분 수열이 될 수 없습니다.
        if (lis1 == null) {
            return false;
        }

        // lis1의 첫 번째 원소가 lis2의 첫 번째 원소와 일치하는 경우,
        // 두 리스트의 나머지 부분에 대해 재귀적으로 검사합니다.
        if (lis1.info.equals(lis2.info)) {
            if (searchSequence(lis1.next, lis2.next)) {
                return true;
            }
        }

        // lis1의 첫 번째 원소가 lis2의 첫 번째 원소와 일치하지 않거나,
        // 일치하는 부분 수열을 찾지 못한 경우, lis1의 나머지 부분에 대해 재귀적으로 검사합니다.
        return searchSequence(lis1.next, lis2);
    }










}

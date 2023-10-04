package org.example.chapter11.exercise;

public class  Exercise1 {


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
//        // deleteDoubles 메서드를 사용하여 리스트에서 중복된 원소들을 제거합니다.
//        lis = deleteDoubles(lis);
//
//        // 중복된 원소들이 제거된 리스트를 출력합니다.
//        System.out.println("중복 원소 제거된 리스트:");
//        current = lis;
//        while (current != null) {
//            System.out.println(current.info);
//            current = current.next;
//        }


    }


    public static int length(ListNode lis) {
        //Todo 1-1
        int count = 0; // 노드의 수를 추적하기 위해 count 변수를 초기화합니다.
        ListNode current = lis; // 현재 노드를 리스트의 헤드로 초기화합니다.
        while (current != null) {
            count++; // 리스트의 각 노드마다 count를 증가시킵니다.
            current = current.next; // 리스트의 다음 노드로 이동합니다.
        }
        return count; // 최종 count를 반환합니다.
    }

    public static ListNode insertAfter(ListNode lis, String s, String given) {
        //Todo 1-2
        ListNode current = lis; // 리스트의 첫 번째 노드로 시작합니다.

        // 리스트를 순회하면서 주어진 원소를 찾습니다.
        while (current != null) {
            // 현재 노드의 값이 주어진 원소와 일치하면, 새 원소를 추가합니다.
            if (current.info.equals(given)) {
                ListNode newNode = new ListNode(s); // 새 노드를 생성합니다.
                newNode.next = current.next; // 새 노드의 다음 노드를 현재 노드의 다음 노드로 설정합니다.
                current.next = newNode; // 현재 노드의 다음 노드를 새 노드로 설정합니다.
                break; // 새 노드를 추가한 후에는 루프를 종료합니다.
            }
            current = current.next; // 다음 노드로 이동합니다.
        }
        return lis; // 수정된 리스트를 반환합니다.
    }


    public static ListNode modify(ListNode lis, String old, String ne) {
        //Todo 1-3
        ListNode current = lis; // 리스트의 첫 번째 노드로 시작합니다.

        // 리스트를 순회하며 'old' 문자열을 찾습니다.
        while (current != null) {
            if (current.info.equals(old)) {
                current.info = ne; // 첫 번째 출현을 찾으면, 값을 'ne'로 변경합니다.
                break; // 첫 번째 출현을 변경한 후에는 루프를 종료합니다.
            }
            current = current.next; // 다음 노드로 이동합니다.
        }
        return lis; // 수정된 리스트를 반환합니다.
    }

    public static ListNode modifyAll(ListNode lis, String old, String ne) {
        //Todo 1-4
        ListNode current = lis; // 리스트의 첫 번째 노드로 시작합니다.

        // 리스트를 순회하며 'old' 문자열의 모든 출현을 찾아서 'ne'로 변경합니다.
        while (current != null) {
            if (current.info.equals(old)) {
                current.info = ne; // 'old'와 일치하는 모든 노드의 값을 'ne'로 변경합니다.
            }
            current = current.next; // 다음 노드로 이동합니다.
        }
        return lis; // 수정된 리스트를 반환합니다.
    }

    public static ListNode insertBefore(ListNode lis, String s, String given) {
        //Todo 1-5
        ListNode current = lis;
        ListNode prev = null;

        while (current != null) {
            if (current.info.equals(given)) {
                ListNode newNode = new ListNode(s);
                newNode.next = current;
                if (prev != null) {
                    prev.next = newNode;
                } else {
                    lis = newNode;
                }
                break;
            }
            prev = current;
            current = current.next;
        }
        return lis;
    }

    public static ListNode copy(ListNode lis) {
        //Todo 1-6
        if (lis == null) {
            // 원본 리스트가 비어있는 경우, 비어있는 리스트를 반환합니다.
            return null;
        }

        // 새로운 연결 리스트의 헤드를 생성합니다.
        ListNode newLis = new ListNode(lis.info);
        // 원본 연결 리스트의 현재 노드를 나타냅니다.
        ListNode currentOriginal = lis.next;
        // 복사된 새로운 연결 리스트의 현재 노드를 나타냅니다.
        ListNode currentNew = newLis;

        while (currentOriginal != null) {
            // 원본 리스트의 현재 노드의 값을 사용하여 새로운 노드를 생성합니다.
            ListNode newNode = new ListNode(currentOriginal.info);
            // 새로운 노드를 새로운 리스트의 마지막 노드에 연결합니다.
            currentNew.next = newNode;
            // 두 리스트의 현재 노드를 다음 노드로 이동시킵니다.
            currentNew = newNode;
            currentOriginal = currentOriginal.next;
        }

        // 복사된 새로운 연결 리스트를 반환합니다.
        return newLis;
    }

    public static ListNode invert(ListNode lis) {
        //Todo 1-7
        // 이전 노드를 저장하는 변수입니다. 초기에는 null입니다.
        ListNode prev = null;
        // 현재 노드를 나타내는 변수입니다.
        ListNode current = lis;

        // 리스트를 순회하면서 링크를 반전시킵니다.
        while (current != null) {
            // 다음 노드를 임시로 저장합니다.
            ListNode nextTemp = current.next;
            // 현재 노드의 링크를 이전 노드로 설정하여 링크를 반전시킵니다.
            current.next = prev;
            // 이전 노드를 현재 노드로 업데이트합니다.
            prev = current;
            // 현재 노드를 다음 노드로 이동시킵니다.
            current = nextTemp;
        }

        // 링크가 반전된 리스트의 헤드를 반환합니다.
        return prev;
    }

    public static ListNode deleteDoubles(ListNode lis) {
        //Todo 1-8 중복된 요소 제거
        if (lis == null) {
            // 리스트가 비어있는 경우, 비어있는 리스트를 반환합니다.
            return null;
        }

        // 현재 노드를 나타냅니다.
        ListNode current = lis;
        while (current != null) {
            // 중복된 원소를 찾아 제거할 대상 노드를 나타냅니다.
            ListNode runner = current;
            while (runner.next != null) {
                if (runner.next.info.equals(current.info)) {
                    // 중복된 원소를 찾았을 경우, 대상 노드를 리스트에서 제거합니다.
                    runner.next = runner.next.next;
                } else {
                    // 다음 노드로 이동합니다.
                    runner = runner.next;
                }
            }
            // 현재 노드를 다음 노드로 이동시킵니다.
            current = current.next;
        }
        return lis;
    }

    /**
     * lis1이 lis2를 연속된 부분 수열로 포함하는지 확인하는 메서드입니다.
     *
     * @param lis1 부분 수열의 포함 여부를 확인할 리스트
     * @param lis2 lis1 내에서 연속된 부분 수열로 포함되는지 확인할 리스트
     * @return lis1이 lis2를 연속된 부분 수열로 포함하면 true, 그렇지 않으면 false
     */
    public static boolean searchSequence(ListNode lis1, ListNode lis2) {
        if (lis2 == null) {
            // lis2가 비어있는 경우, 모든 리스트는 빈 리스트를 부분 수열로 포함합니다.
            return true;
        }

        ListNode current1 = lis1;
        while (current1 != null) {
            ListNode temp1 = current1;
            ListNode temp2 = lis2;

            // lis1과 lis2의 현재 원소가 일치하는 동안 비교를 계속합니다.
            while (temp1 != null && temp2 != null && temp1.info.equals(temp2.info)) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }

            // temp2가 null이면, lis2의 모든 원소가 lis1의 연속된 부분 수열로 포함된 것입니다.
            if (temp2 == null) {
                return true;
            }

            // lis1의 다음 원소로 이동하여 계속 비교합니다.
            current1 = current1.next;
        }

        // lis1의 모든 원소를 검사한 후에도 lis2를 포함하는 부분 수열을 찾지 못했다면 false를 반환합니다.
        return false;
    }



}

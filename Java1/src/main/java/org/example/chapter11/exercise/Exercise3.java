package org.example.chapter11.exercise;

public class Exercise3 {
    public static void main(String[] args) {
        // 테스트용 리스트 초기화
        ListIntNode head1 = new ListIntNode(1, new ListIntNode(4, new ListIntNode(5)));
        ListIntNode head2 = new ListIntNode(2, new ListIntNode(4, new ListIntNode(6)));

        // 1. 정렬 여부 확인 테스트
        // 주어진 리스트가 이미 정렬되어 있으므로, true를 반환해야 합니다.
        System.out.println("첫 번째 리스트가 정렬되어 있는가? : " + Exercise3.isOrdered(head1)); // true

        // 2. 리스트에서 값 검색 테스트
        // 리스트에 3이 포함되어 있으므로, true를 반환해야 합니다.
        int searchValue = 3;
        System.out.println(searchValue + " 값을 가진 노드가 첫 번째 리스트에 있는가? : " + Exercise3.search(head1, searchValue)); // true

        // 3. 값 삽입 테스트
        // 4를 삽입한 후에도 리스트가 정렬되어 있어야 합니다.
        int insertValue = 4;
        head1 = Exercise3.insert(head1, insertValue);
        System.out.println(insertValue + " 값을 가진 노드 삽입 후 첫 번째 리스트 정렬 여부 : " + Exercise3.isOrdered(head1)); // true

        // 4. 값 삭제 테스트
        // 3을 삭제한 후, 리스트에서 3을 찾을 수 없어야 합니다.
        int deleteValue = 3;
        head1 = Exercise3.delete(head1, deleteValue);
        System.out.println(deleteValue + " 값을 가진 노드 삭제 후 첫 번째 리스트에서 " + deleteValue + " 값을 가진 노드 탐색 : " + Exercise3.search(head1, deleteValue)); // false

        // 5. 리스트 병합 테스트 - 노드 새로 생성
        // 두 리스트를 병합하여 새로운 노드를 생성합니다.
        ListIntNode mergedNewNodes = Exercise3.mergeNewNodes(head1, head2);
        System.out.print("두 리스트 병합 후 새 노드 생성 리스트의 원소: ");
        printList(mergedNewNodes);

        // 6. 리스트 병합 테스트 - 노드 재사용
        // 두 리스트를 병합하여 기존 노드를 재사용합니다.
        ListIntNode mergedReuseNodes = Exercise3.mergeReuseNodes(head1, head2);
        System.out.print("두 리스트 병합 후 노드 재사용 리스트의 원소: ");
        printList(mergedReuseNodes);

        // 7. 두 리스트의 교집합 테스트
        // 두 리스트의 교집합을 찾습니다. 교집합은 비어있어야 합니다.
        ListIntNode intersection = Exercise3.intersect(head1, head2);
        System.out.print("두 리스트의 교집합 리스트의 원소: ");
        printList(intersection);
    }


    public static boolean isOrdered(ListIntNode head) {
        //Todo 3-1 리스트가 정렬되어 있는지 확인
        if (head == null || head.next == null) return true;
        if (head.info > head.next.info) return false;
        return isOrdered(head.next);
    }


    public static boolean search(ListIntNode head, int val) {
        //Todo 3-2 주어진 요소 탐색
        ListIntNode current = head;
        while (current != null && current.info <= val) {
            if (current.info == val) return true;
            current = current.next;
        }
        return false;
    }


    public static ListIntNode insert(ListIntNode head, int val) {
        //Todo 3-3 새 요소 삽입
        if (head == null || head.info > val) return new ListIntNode(val, head);
        head.next = insert(head.next, val);
        return head;
    }

    public static ListIntNode delete(ListIntNode head, int val) {
        //Todo 3-4 요소 삭제
        if (head == null) return null;
        if (head.info == val) return head.next;
        head.next = delete(head.next, val);
        return head;
    }


    public static ListIntNode mergeNewNodes(ListIntNode l1, ListIntNode l2) {
        //Todo 3-5 리스트 병합
        if (l1 == null) return copy(l2);
        if (l2 == null) return copy(l1);
        if (l1.info < l2.info) {
            return new ListIntNode(l1.info, mergeNewNodes(l1.next, l2));
        } else {
            return new ListIntNode(l2.info, mergeNewNodes(l1, l2.next));
        }
    }

    private static ListIntNode copy(ListIntNode head) {
        //Todo 3-7 노드 새로 생성
        if (head == null) return null;
        return new ListIntNode(head.info, copy(head.next));
    }

    public static ListIntNode mergeReuseNodes(ListIntNode l1, ListIntNode l2) {
        //Todo 3-8 노드 재사용을 통한 두 정렬된 리스트 병합
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.info < l2.info) {
            l1.next = mergeReuseNodes(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeReuseNodes(l1, l2.next);
            return l2;
        }
    }

    public static ListIntNode intersect(ListIntNode l1, ListIntNode l2) {
        if (l1 == null || l2 == null) return null;

        // l1의 원소가 l2의 원소보다 작은 경우 l1를 다음으로 이동
        if (l1.info < l2.info) return intersect(l1.next, l2);

        // l2의 원소가 l1의 원소보다 작은 경우 l2를 다음으로 이동
        if (l1.info > l2.info) return intersect(l1, l2.next);

        // 같은 값을 찾은 경우, 교집합에 추가하고 두 리스트 모두 다음으로 이동
        ListIntNode temp = new ListIntNode(l1.info);
        temp.next = intersect(l1.next, l2.next);
        return temp;
    }



    private static void printList(ListIntNode head) {
        ListIntNode current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }







}

package org.chapter.chapter12.연습문제;

public class Store {
    private final int MAX_CAPACITY = 10; // 최대 전시 가능한 물건 수
    private int numberOfItems = 0; // 현재 물건 수
    private int customersInStore = 0; // 매장 내 고객 수

    public Store() {
        // 초기화 코드
    }

    public synchronized void enter() throws InterruptedException {
        while (customersInStore >= 5) {
            wait(); // 매장에 5명 이상 있으면 대기
        }
        customersInStore++;
        System.out.println("고객 입장. 현재 매장 내 고객 수: " + customersInStore);
        notifyAll(); // 다른 스레드에 입장 가능함을 알림
    }

    public synchronized void exit() {
        customersInStore--;
        System.out.println("고객 퇴장. 현재 매장 내 고객 수: " + customersInStore);
        notifyAll(); // 다른 스레드에 퇴장함을 알림
    }

    public synchronized void buy() throws InterruptedException {
        while (numberOfItems == 0) {
            wait(); // 물건이 없으면 대기
        }
        numberOfItems--;
        System.out.println("물건 구매. 남은 물건 수: " + numberOfItems);
        // 필요시 생산자에게 알림
        if (numberOfItems < MAX_CAPACITY) {
            notifyAll();
        }
    }

    public synchronized void sell() throws InterruptedException {
        while (numberOfItems >= MAX_CAPACITY) {
            wait(); // 물건이 가득 차면 대기
        }
        numberOfItems= MAX_CAPACITY;
        System.out.println("물건 입고. 매장 내 물건 수: " + numberOfItems);
        // 소비자에게 알림
        notifyAll();
    }
}

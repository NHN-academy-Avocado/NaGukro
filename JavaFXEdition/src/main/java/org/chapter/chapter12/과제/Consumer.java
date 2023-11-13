package org.chapter.chapter12.과제;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private String name;
    private Store store;
    private String item; // 구매할 물품

    public Consumer(String name, Store store, String item) {
        this.name = name;
        this.store = store;
        this.item = item;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.enter(); // 매장에 입장
                store.buy(item); // 지정된 물품 구매
                store.exit(); // 매장 퇴장
                System.out.println(name + "가 " + item + "을(를) 구매하고 퇴장했습니다.");

                int sleepTime = ThreadLocalRandom.current().nextInt(1, 11) * 1000; // 1~10초 사이의 잠시 대기
                System.out.println(name + "가 다음 구매까지 " + sleepTime / 1000 + "초 대기합니다.");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " 소비자가 중단되었습니다.");
        }
    }
}

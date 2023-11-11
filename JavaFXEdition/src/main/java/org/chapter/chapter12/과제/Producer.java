package org.chapter.chapter12.과제;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private Store store;
    private String item; // 납품할 물품

    public Producer(Store store, String item) {
        this.store = store;
        this.item = item;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.sell(item); // 지정된 물품을 매장에 납품
                int sleepTime = ThreadLocalRandom.current().nextInt(1, 11) * 1000; // 1~10초 사이의 잠시 대기
                System.out.println("생산자가 " + item + "을(를) 납품하고, 다음 납품까지 " + sleepTime / 1000 + "초 대기합니다.");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println("생산자가 중단되었습니다.");
        }
    }
}

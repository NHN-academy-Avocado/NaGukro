package org.chapter.chapter12.과제;

import java.util.List;
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
                int sleepTime = ThreadLocalRandom.current().nextInt(1, 11) * 1000; // 1~10초 사이의 잠시 대기

                List<String> availableItems = store.getAvailableItems();
                if (!availableItems.isEmpty()) {
                    //뭘 구매할지 랜덤으로 Get!
                    String item = availableItems.get(ThreadLocalRandom.current().nextInt(availableItems.size()));
                    store.buy(item); // 무작위로 선택된 물품 구매
                    Thread.sleep(sleepTime);
                    System.out.println(name + "가 " + item + "을(를) 구매하고 퇴장했습니다.");
                }

                store.exit(); // 매장 퇴장
                System.out.println(name + "가 다음 구매까지 " + sleepTime / 1000 + "초 대기합니다.");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " 소비자가 중단되었습니다.");
        }
    }

}

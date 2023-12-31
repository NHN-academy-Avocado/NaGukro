package org.chapter.chapter12.연습문제;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private String name;
    private Store store;

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public void run() {
                int sleepTime = ThreadLocalRandom.current().nextInt(1, 11) * 1000; // 1~10초 사이의 잠시 대기
        try {
            while (true) {
                store.enter(); // 매장에 입장
                Thread.sleep(sleepTime);
                store.buy(); // 물건 구매
                store.exit(); // 매장 퇴장
                System.out.println(name + "가 구매를 마치고 퇴장했습니다.");
                System.out.println(name + "가 다음 구매까지 " + sleepTime / 1000 + "초 대기합니다.");
                Thread.sleep(sleepTime);
            }
        } catch (InterruptedException e) {
            System.out.println(name + " 소비자가 중단되었습니다.");
        }
    }
}

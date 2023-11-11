package org.chapter.chapter12.과제;

public class MarketSimulator {
    public static void main(String[] args) {
        String[] items = {"사과", "바나나", "오렌지"};
        int storePermits = 5; // 매장에 동시에 입장할 수 있는 최대 고객 수
        Store store = new Store(items, 5, storePermits);

        // 각 물품별로 생산자 스레드 생성 및 시작
        for (String item : items) {
            Producer producer = new Producer(store, item);
            new Thread(producer).start();
        }

        // 소비자 스레드 생성 및 시작
        for (int i = 1; i <= 10; i++) {
            String item = items[i % items.length]; // 라운드 로빈 방식으로 물품 선택
            Consumer consumer = new Consumer("소비자 " + i, store, item);
            new Thread(consumer).start();
        }
    }

}

package org.chapter.chapter12.과제;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.stream.Collectors;

public class Store {
    private final int MAX_CAPACITY = 10; // 각 물품별 최대 재고 수
    private Map<String, Integer> inventory; // 각 물품의 재고를 관리하는 Map
    private Map<String, Semaphore> semaphores; // 각 물품에 대한 세마포어

    private Semaphore storeSemaphore; // 매장 전체에 대한 세마포어

    private int storePermits; // 매장에 동시에 입장할 수 있는 최대 고객 수


    public Store(String[] items, int permits, int storePermits) {
        this.storeSemaphore = new Semaphore(storePermits); // 매장 전체 입장 제한
        this.storePermits = storePermits;
        inventory = new HashMap<>();
        semaphores = new HashMap<>();
        for (String item : items) {
            inventory.put(item, 0);
            semaphores.put(item, new Semaphore(permits));
        }
    }

    public  void enter() throws InterruptedException {
        storeSemaphore.acquire(); // 매장에 들어가기 전에 세마포어 획득
        System.out.println("고객 입장. 현재 매장 내 고객 수: " + (storePermits - storeSemaphore.availablePermits()));
    }

    public  void exit() {
        storeSemaphore.release(); // 매장을 나갈 때 세마포어 반환
        System.out.println("고객 퇴장. 현재 매장 내 고객 수: " + (storePermits - storeSemaphore.availablePermits()));
    }

    public void buy(String item) throws InterruptedException {
        Semaphore semaphore = semaphores.get(item);
        semaphore.acquire(); // 해당 물품에 대한 세마포어 획득

        synchronized (this) {
            while (inventory.get(item) == 0) {
                wait(); // 해당 물품이 없으면 대기
            }
            inventory.put(item, inventory.get(item) - 1); // 물품 구매
            System.out.println(item + " 구매. 남은 수량: " + inventory.get(item));
        }

        semaphore.release(); // 세마포어 반환
    }

    public void sell(String item) throws InterruptedException {
        while (inventory.get(item) != MAX_CAPACITY) {
//            wait(); // 해당 물품이 가득 차면 대기
            inventory.put(item, MAX_CAPACITY); // 물품 입고
        System.out.println(item + " 입고. 현재 수량: " + inventory.get(item));
        }
//        notifyAll(); // 소비자에게 알림
    }

    //store에서 구매 가능한 물품 목록 get
    public synchronized List<String> getAvailableItems() {
        return inventory.entrySet().stream()
                .filter(entry -> entry.getValue() > 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}

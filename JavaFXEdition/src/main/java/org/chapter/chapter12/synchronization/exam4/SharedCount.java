package org.chapter.chapter12.synchronization.exam4;

public class SharedCount {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        setCount(getCount() + 1);
    }
}
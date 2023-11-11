package org.chapter.chapter12.synchronization.exam2;

public class SharedCount {
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // tag::synchronized[]
    public synchronized void increment() {
        setCount(getCount() + 1);
    }
    // end::synchronized[]
}
package Lesson3;

import java.util.NoSuchElementException;

public class MyArrayDeq<Item> {
    private int size = 0;
    private Object[] deq = new Object[1];
    private int left = 0;
    private int right = 0;

    //    e
    //    s = 2
    //0 1 2 3
    //i j g h
    //0 1 2 3 4 5 6 7
    //g h i j

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) tmp[i] = deq[(i + left) % deq.length];
        left = 0;
        right = size;
        deq = tmp;
    }

    public void insertRight(Item item) {
        if (size == deq.length) resize(deq.length * 2);
        deq[right++] = item;
        right %= deq.length;
        size++;
    }

    public Item removeLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deq is empty.");
        }
        Item item = (Item) deq[left];
        deq[left] = null;
        size--;
        left = (left + 1) % deq.length;
        if (size == deq.length / 4 && size > 0) resize(deq.length / 2);
        return item;
    }

    public Item peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deq is empty.");
        }
        return (Item) deq[left];
    }

    public Item peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deq is empty.");
        }
        System.out.println("Right: " + right);
        return (Item) deq[right - 1];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) s.append((deq[(i + left) % deq.length] + ", "));
        return s.toString();
    }

}

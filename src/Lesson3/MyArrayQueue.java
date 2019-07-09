package Lesson3;

import java.util.NoSuchElementException;

public class MyArrayQueue<Item> {
    private int size = 0;
    private Object[] queue = new Object[1];
    private int start = 0;//left
    private int end = 0;//right

    //    e
    //    s = 2
    //0 1 2 3
    //i j g h
    //0 1 2 3 4 5 6 7
    //g h i j

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    private void resize(int capacity) {
        Object[] tmp = new Object[capacity];
        for (int i = 0; i < size; i++) tmp[i] = queue[(i + start) % queue.length]; //x % size = [0..size - 1]
        start = 0;
        end = size;
        queue = tmp;
    }

    public void enqueue(Item item) {
        if (size == queue.length) resize(queue.length * 2);
        queue[end++] = item;
        end %= queue.length;
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        Item item = (Item) queue[start];
        queue[start] = null;
        size--;
        start = (start + 1) % queue.length;
        if (size == queue.length / 4 && size > 0) resize(queue.length / 2);
        return item;
    }

    public Item peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty.");
        }
        return (Item) queue[start];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) s.append((queue[(i + start) % queue.length] + ", "));
        return s.toString();
    }
}

package Lesson2;

import java.util.Comparator;
import java.util.Iterator;

public class StudyArrayList<Item> implements Iterable {
    private int size = 0;
    private Object[] list = new Object[1];

    public int getSize() {
        return size;
    }

    public Item get(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        return (Item) list[index];
    }

    public void set(int index, Item item) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        this.list[index] = item;
    }

    public void add(Item item) {
        if (size == list.length) resize(2 * list.length);
        list[size] = item;
        size++;
    }

    private void resize(int capasity) {
        Object[] temp = new Object[capasity];
        for (int i = 0; i < size; i++) temp[i] = list[i];
        list = temp;
    }

    public int indexOf(Item item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index == -1) return false;
        for (int i = index; i < size - 1; i++) list[i] = list[i + 1];
        list[size - 1] = null;
        size--;
        if (size == list.length / 4 && size > 0) resize(list.length / 2);
        return true;
    }

    public boolean contains(Item item) {
        return indexOf(item) != -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size; i++) {
            s.append(list[i] + " ");
        }
        return s.toString();
    }

    @Override
    public Iterator iterator() {
        return new StudyArrayListIterator();
    }

    private class StudyArrayListIterator implements Iterator<Item> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new IndexOutOfBoundsException();
            Item item = (Item) list[cursor];
            cursor++;
            return item;
        }
    }

    // Sorting methods

    public void sortSelection(Comparator<Item> cmp) {
        for (int i = 0; i < size - 1; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                if (less((Item)list[j], (Item)list[min], cmp)) min = j;
            }
            exchange(i, min);
        }
    }

    public void sortSelect() {
        int i, j, mark;
        for (i = 0; i < this.size; i++) {
            mark = i;
            for (j = i + 1; j < this.size; j++) {
                if ((int) list[j] < (int) list[mark]) mark = j;
            }
            exchange(i, mark);
        }
    }


    public void sortInsertion(Comparator<Item> cmp) {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less((Item) list[j], (Item) list[j - 1], cmp)) exchange(j, j - 1);
                else break;
                ;
            }

        }
    }

    private void exchange(int a, int b) {
        Object temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    private boolean less(Item item1, Item item2, Comparator<Item> cmp) {
        return cmp.compare(item1, item2) < 0;
    }
}

package Lesson2;

public class StudyArrayList<Item> {
    private int size = 0;
    private Object[] list = new Object[1];

    public int getSize() {
        return size;
    }

    public Item[] get(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException();
        return (Item[]) list[index];
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

}

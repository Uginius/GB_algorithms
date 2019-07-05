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

}

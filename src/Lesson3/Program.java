package Lesson3;

public class Program {
    public static void main(String[] args) {
        MyArrayQueue<Character> queue = new MyArrayQueue<>();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peekFront());
        queue.dequeue();
        System.out.println(queue.peekFront());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.isEmpty());
        queue.enqueue('f');
        queue.enqueue('g');
        queue.enqueue('h');
        System.out.println(queue);
    }
}

package Lesson3;

public class Program {
    public static void main(String[] args) {
        MyArrayDeq<Character> deq = new MyArrayDeq<>();
        deq.insertRight('a');
        deq.insertRight('b');
        deq.insertRight('c');
        deq.insertRight('d');
        System.out.println(deq);;

        deq.removeRight();
        deq.removeLeft();

        deq.insertLeft('z');
        deq.insertRight('f');
        deq.insertRight('g');
        deq.insertRight('h');
        System.out.println(deq);

        System.out.println(deq.peekLeft());
        System.out.println(deq.peekRight());
    }
}

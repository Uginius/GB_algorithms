package Lesson4;


public class Program {
    public static void main(String[] args) {
        MyLinkedList<Character> linkedList = new MyLinkedList<>();
        linkedList.addLast('a');
        linkedList.addLast('b');
        linkedList.addLast('c');
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.set(1, 'd');
        System.out.println(linkedList.get(1));
        linkedList.addFirst('e');
        linkedList.addLast('f');
        linkedList.add(2, 'g');
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList);
        System.out.println(linkedList.indexOf('z'));
        System.out.println(linkedList.size());
        linkedList.remove('c');
        for (Character c:
             linkedList) {
            System.out.print(c + ", ");
        }

    }
}

package Lesson6;

import java.util.NoSuchElementException;

public class MyTreeMap<Key extends Comparable<Key>, Value> {
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int size; //кол-во узлов в дереве, корнем которого является данный узел

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private Node root = null;

    public boolean isEmpty() {
        return root == null;
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int size() {
        return size(root);
    }

    public Value get(Key key) {
        return get(key, root);
    }

    private Value get(Key key, Node node) {
        if (key == null) throw new IllegalArgumentException("Key can not be null.");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) return node.value;
        //cmp > 0
        if (cmp < 0) return get(key, node.left);
        else return get(key, node.right);
    }

    public void put(Key key, Value value) {
        root = put(key, value, root);
    } //a[key] = value;

    private Node put(Key key, Value value, Node node) {
        if (key == null) throw new IllegalArgumentException("Key can not be null.");
        if (node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);
        if (cmp == 0) node.value = value;
        else if (cmp < 0) node.left = put(key, value, node.left);
        else node.right = put(key, value, node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node max(Node node) {
        if (node.right == null) return node;
        else return max(node.right);
    }

    public Value max() {
        return max(root).value;
    }

    private Node min(Node node) {
        if (node.left == null) return node;
        else return min(node.left);
    }

    public Value min() {
        return min(root).value;
    }

    private Node removeMin(Node node) {
        if (node.left == null) return node.right;
        else node.left = removeMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void removeMin() {
        if (isEmpty()) throw new NoSuchElementException("Map is empty.");
        root = removeMin(root);
    }

    private Node removeMax(Node node) {
        if (node.right == null) return node.left;
        else node.right = removeMin(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void removeMax() {
        if (isEmpty()) throw new NoSuchElementException("Map is empty.");
        root = removeMax(root);
    }

    public void remove(Key key) {
    }

    private Node remove(Key key, Node node) {
        if (key == null) throw new IllegalArgumentException("Key can not be null.");
        if (node == null) return null;
        int cmp = key.compareTo(node.key);
        if (cmp == 0) { //remove
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node tmp = node;
            node = max(node.left);
            node.left = removeMax(tmp.left);
            node.right = tmp.right;
            tmp = null;
        } else if (cmp < 0) node.left = remove(key, node.left);
        else node.right = remove(key, node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }
}

package app.linkedlist;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int size() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public void addFirst(E item) {
        Node<E> nodeItem = new Node<E>(item);
        if (this.size == 0) {
            this.head = nodeItem;
            this.tail = nodeItem;
        } else {
            nodeItem.next = this.head;
            this.head = nodeItem;
        }
        this.size++;
    }

    public void addLast(E item) {
        Node<E> nodeItem = new Node<E>(item);
        Node<E> oldTail = this.tail;
        if (this.size == 0) {
            this.head = nodeItem;
            this.tail = nodeItem;
        } else {
            oldTail.next = nodeItem;
            this.tail = nodeItem;
        }
        this.size++;
    }

    public E removeFirst() {
        if (this.size == 0) {
            throw new UnsupportedOperationException();
        }
        E element = this.head.value;
        this.head = this.head.next;
        this.size--;
        if (size == 0) {
            this.head = null;
            this.tail = null;
        }
        return element;
    }

    public E removeLast() {
        if (this.size == 0) {
            throw new UnsupportedOperationException();
        }
        E element = this.tail.value;
        Node<E> first = this.head;
        if (this.size == 1) {
            first.next = this.tail;
        }
        while (true) {
            if (first.next == this.tail) {
                first.next = null;
                this.tail = first;
                break;
            } else {
                first = first.next;
            }
        }
        this.size--;
        return element;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class Node<T> {

        private T value;
        private Node<T> next;

        private Node(T value) {
            this.value = value;
            this.next = null;
        }

    }

    private class MyIterator implements Iterator<E> {

        private int index;
        private Node<E> currentNode;

        private MyIterator() {
            this.currentNode = head;
        }

        @Override
        public boolean hasNext() {
            if (this.index >= size) {
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E result = this.currentNode.value;
            this.index++;
            this.currentNode = this.currentNode.next;
            return result;
        }

        @Override
        public void remove() {

        }
    }
}

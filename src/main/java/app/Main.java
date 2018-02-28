package app;

import app.linkedlist.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(3);
        printList(myLinkedList);

        myLinkedList.addLast(4);
        myLinkedList.addLast(5);
        myLinkedList.addLast(6);
        printList(myLinkedList);

        myLinkedList.removeFirst();
        myLinkedList.removeFirst();
        printList(myLinkedList);

        myLinkedList.removeLast();
        myLinkedList.removeLast();
        printList(myLinkedList);




    }
    public static void printList(LinkedList<Integer> myLinkedList) {
        System.out.println(myLinkedList.size());
        for (Integer integer : myLinkedList) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}

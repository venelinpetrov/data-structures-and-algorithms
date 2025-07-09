package com.vpe;

public class Main {
    public static void main(String[] args) {
        var linkedList = new LinkedList();

        System.out.println("---Add first---");
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        System.out.println(linkedList);

        System.out.println("---Delete first---");
        linkedList.deleteFirst();
        System.out.println(linkedList);

        System.out.println("---Delete last---");
        linkedList.deleteLast();
        System.out.println(linkedList);

        System.out.println("---Contains---");
        linkedList.addFirst(12);
        linkedList.addLast(33);
        System.out.println(linkedList);
        System.out.println(linkedList.contains(1));
        System.out.println(linkedList.contains(33));

        System.out.println("---Index of---");
        System.out.println(linkedList.indexOf(33));
        System.out.println(linkedList.indexOf(12));
        System.out.println(linkedList.indexOf(0));

        System.out.println("---Reverse---");
        LinkedList linkedList2 = new LinkedList();

        linkedList2.addLast(1);
        linkedList2.addLast(2);
        linkedList2.addLast(3);
        linkedList2.addLast(4);
        linkedList2.addLast(41);

        System.out.println(linkedList2);
        linkedList2.reverse();
        System.out.println(linkedList2);
    }
}
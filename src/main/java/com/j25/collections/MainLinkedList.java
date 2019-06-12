package com.j25.collections;

public class MainLinkedList {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(15);
        myLinkedList.add(20);
        myLinkedList.add(25);
        myLinkedList.add(30);

        System.out.println(myLinkedList);

        myLinkedList.add(1, 100);
        System.out.println(myLinkedList);
        myLinkedList.add(5, 200);
        System.out.println(myLinkedList);

//        myLinkedList.add(0, 300);
//        System.out.println(myLinkedList);
        myLinkedList.add(myLinkedList.size() - 1, 500);
        System.out.println(myLinkedList);

    }
}

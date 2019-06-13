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

        myLinkedList.add(0, 100);
        System.out.println(myLinkedList);
        myLinkedList.add(5, 200);
        System.out.println(myLinkedList);

//        myLinkedList.add(0, 300);
//        System.out.println(myLinkedList);
        myLinkedList.add(myLinkedList.size(), 500);
        System.out.println(myLinkedList);

        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(5));
        System.out.println(myLinkedList.get(myLinkedList.size() - 1));
//        System.out.println(myLinkedList.get(myLinkedList.size()));

        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        myLinkedList.remove(myLinkedList.size() - 1);
        System.out.println(myLinkedList);
        myLinkedList.remove(myLinkedList.size() / 2);
        System.out.println(myLinkedList);
    }
}

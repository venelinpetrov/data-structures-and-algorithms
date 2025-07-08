package com.vpe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Array arr = new Array(3);

        arr.printItems();

        // Insert
        System.out.println("--Insert--");
        arr.insert(5);
        arr.insert(54);
        arr.insert(11);
        arr.insert(12);
        arr.insert(4);
        arr.insert(1);
        arr.insert(31);
        arr.insert(99);
        arr.printItems();

        // Delete
        System.out.println("--Delete--");
        arr.delete(2);

        arr.printItems();

        // Index of
        System.out.println("--Index of--");
        System.out.println(arr.indexOf(54));
        System.out.println(arr.indexOf(99));
        System.out.println(arr.indexOf(100));
    }
}
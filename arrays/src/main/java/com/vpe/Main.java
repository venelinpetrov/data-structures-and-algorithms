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

        // Intersect
        System.out.println("--Intersect--");
        Array arr2 = new Array(3);
        arr2.insert(5);
        arr2.insert(5);
        arr2.insert(444);
        arr2.insert(12);

        arr.intersect(arr2).printItems();

        System.out.println("--Reverse--");
        Array arr3 = new Array(3);
        arr3.insert(1);
        arr3.insert(2);
        arr3.insert(3);
        arr3.reverse();
        arr3.printItems();

        System.out.println("--Insert at--");
        Array arr4 = new Array(4);
        arr4.insert(1);
        arr4.insert(2);
        arr4.insert(3);
        arr4.insert(4);

        arr4.insertAt(77, 1);

        arr4.printItems();
    }
}
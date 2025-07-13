package com.vpe;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Find the first non-repeated character
        HashMap<Character, Integer> map = new HashMap<>();
        var str = "a green apple"; // -> g, because a is repeated

        for (var c : str.toCharArray()) {
            var reps = map.get(c);
            if (reps == null) {
                reps = 0;
            }
            map.put(c, ++reps);
        }

        for (var c : str.toCharArray()) {
            if (map.get(c) == 1) {
                System.out.println(c);
                break;
            }
        }

        // Find the first repeated character
        // green apple -> e
        Set<Character> set = new HashSet<>();
        var str2 = "green apple";

        for (var c : str2.toCharArray()) {
            if (set.contains(c)) {
                System.out.println(c);
                break;
            }
            set.add(c);
        }
        System.out.println("---Hash table---");
        HashTable t = new HashTable();
        t.put(12, "apple");
        t.put(3, "orange");
        t.put(2, "cherry");
        System.out.println(t);

        System.out.println(t.get(12));
        System.out.println(t.get(3));
        System.out.println(t.get(2));

        t.remove(2);

        System.out.println(t);
        // ---------------------------
        // Exercises


        int[] arr = { 1, 2, 2, 3, 3, 3, 4 };
        System.out.println(findMostRepeatedEl(arr));

        int[] arr2 = {1, 7, 5, 9, 2, 12, 3};
        System.out.println(countPairsWithDiffK(arr2, 2));

        System.out.println("--- Two Sum ---");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    private static int findMostRepeatedEl(int[] arr) {
        // 1. Find the most repeated element in an array of integers. What is the time
        // complexity of this method?

        // Input: [1, 2, 2, 3, 3, 3, 4]
        // Output: 3
        if (arr == null) {
            throw new IllegalArgumentException();
        }

        if (arr.length == 0) {
            throw new IllegalStateException();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int num = arr[0];
        int freq = 0;

        for( var item : arr) {
            int count = map.getOrDefault(item, 0) + 1;
            map.put(item, count);

            if (count > freq) {
                freq = count;
                num = item;
            }
        }

        return num;
    }


    public static int countPairsWithDiffK(int[] arr, int k) {
        // 2. Given an array of integers, count the number of unique pairs of integers that have difference k.
        // Input: [1, 7, 5, 9, 2, 12, 3] K=2
        // Output: 4

        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(var num : arr) {
            set.add(num);
        }
        for(var num : set) {
            if (set.contains(num + k)) {
                count++;
            }
        }

        return count;
    }

    public static int[] twoSum(int[] arr, int k) {
        // 3- Given an array of integers, return indices of the two numbers such that they add up to a specific target.
        //Input: [2, 7, 11, 15] - target = 9
        // Output: [0, 1] (because 2 + 7 = 9)
        // Assume that each input has exactly one solution, and you may not use the same element twice

        // num, index
        HashMap<Integer, Integer> map = new HashMap<>();
        var res = new ArrayList<Integer>(2);
        for (int i = 0; i < arr.length; i++) {

            var item = arr[i];

            if (map.containsKey(k - item)) {
                var prevItem = map.get(k - item);
                return new int[]{ prevItem, i };
            }

            map.put(item, i);

        }
        return null;
    }
}
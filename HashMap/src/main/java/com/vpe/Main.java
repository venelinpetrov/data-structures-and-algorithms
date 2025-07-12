package com.vpe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
    }
}
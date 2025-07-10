package com.vpe;

import java.util.Stack;

public class BalancedExpression {
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for(Character c : str.toCharArray()) {
            if (isOpeningBracket(c)) {
                stack.push(c);
            }
            if (isClosingBracket(c) ) {
                if (stack.empty()) {
                    return false;
                }
                var openingBracket = stack.pop();
                if (openingBracket != getOpeningBracket(c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static boolean isOpeningBracket(Character c) {
        return switch (c) {
            case '(', '[', '{', '<' -> true;
            default -> false;
        };
    }
    public static boolean isClosingBracket(Character c) {
        return switch (c) {
            case ')', ']', '}', '>' -> true;
            default -> false;
        };
    }

    public static Character getOpeningBracket(Character c) {
        return switch (c) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            case '>' -> '<';
            default -> null;
        };
    }
}

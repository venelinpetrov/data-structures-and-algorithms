package com.vpe;

public class Main {
    public static void main(String[] args) {
        assert !BalancedExpression.isBalanced(")");
        assert !BalancedExpression.isBalanced("(");
        assert BalancedExpression.isBalanced("(1+1)[2*2]<>");

        System.out.println("---MinStack---");
        var stack = new MinStack();
        stack.push(2);
        stack.push(10);
        stack.push(4);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
    }
}
package com.vpe;

public class Main {
    public static void main(String[] args) {
        assert BalancedExpression.isBalanced("()");
        assert !BalancedExpression.isBalanced("(");
        assert BalancedExpression.isBalanced("(1+1)[2*2]<>");
    }
}
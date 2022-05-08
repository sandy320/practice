package com.wbchao.leetcode;

public class BitTree {

    int value;
    BitTree left;
    BitTree right;

    public BitTree(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BitTree n1 = new BitTree(1);
        BitTree n2 = new BitTree(-5);
        BitTree n3 = new BitTree(2);
        BitTree n4 = new BitTree(0);
        BitTree n5 = new BitTree(3);
        BitTree n6 = new BitTree(-4);
        BitTree n7 = new BitTree(-5);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;

        System.out.println(getMax(n1));

    }

    public static int getMax(BitTree node){
        if(node.right == null && node.left ==null){
            return node.value;
        }
        if(node.left == null){
            return Math.max(node.value,getMax(node.right));
        }
        if(node.right == null){
            return Math.max(node.value,getMax(node.left));
        }

        int temp = Math.max(getMax(node.left), getMax(node.right));

        return Math.max(temp,node.value);

    }
}

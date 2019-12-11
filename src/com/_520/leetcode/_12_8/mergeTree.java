package com._520.leetcode._12_8;

import java.util.Arrays;

public class mergeTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }

    }
    /*
              前序遍历序列 {1,2,4,7,3,5,6,8}
              中序遍历序列 {4,7,2,1,5,3,8,6}
     */
    private static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0)
            return null;
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {

            if (in[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }

    private static void prevOrder(TreeNode node){
        System.out.println(node.val);
        if (node.left != null)
            prevOrder(node.left);
        if (node.right != null) {
            prevOrder(node.right);
        }
    }
    private static void midOrder(TreeNode node){
        if (node.left != null) {
            prevOrder(node.left);
        }
        System.out.println(node.val);
        if (node.right != null) {
            prevOrder(node.right);
        }
    }
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        prevOrder(treeNode);
        System.out.println("----------------------");
        midOrder(treeNode);

    }
}

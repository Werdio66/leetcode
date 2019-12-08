package com._520.leetcode._12_7;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isSymmetric1(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(root);
        while (!nodes.isEmpty()){
            TreeNode t1 = nodes.removeFirst();
            TreeNode t2 = nodes.removeFirst();
            if (t1 == null && t2 == null)
                continue;
            if (t1 == null || t2 == null)
                return false;
            if (t1.val != t2.val)
                return false;

            nodes.add(t1.left);
            nodes.add(t2.right);
            nodes.add(t1.right);
            nodes.add(t2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        return isTrue(root,root);
    }
    private static boolean isTrue(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        return t1.val == t2.val && isTrue(t1.left,t2.right) && isTrue(t1.right,t2.left);
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t6;
        t3.left = t7;
        t3.right = t5;
        IsSymmetric i = new IsSymmetric();
//        System.out.println(i.isSymmetric(t1));
        System.out.println(i.isSymmetric1(t1));
    }
}

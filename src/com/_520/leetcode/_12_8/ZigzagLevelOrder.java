package com._520.leetcode._12_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int cen = 0;
        while (!stack.isEmpty()){
            list.add(new ArrayList<>());

            int length = stack.size();
            for (int i = 0; i < length; i++) {
                TreeNode t = stack.pop();
                list.get(cen).add(t.val);

                if (t.left != null){
                    stack.push(t.left);
                }

                if (t.right != null){
                    stack.push(t.right);
                }
            }
            cen++;
        }
        return list;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder l = new ZigzagLevelOrder();
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
        List<List<Integer>> lists = l.levelOrder(t1);
        System.out.println(lists);
    }
}

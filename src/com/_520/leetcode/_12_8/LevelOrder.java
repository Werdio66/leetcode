package com._520.leetcode._12_8;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<List<Integer>> list = new ArrayList<>();
    // 递归
    public List<List<Integer>> levelOrder1(TreeNode root) {
       if (root == null)
           return null;
       serach(root,0);
       return list;
    }

    private static void serach(TreeNode node, int cen){
        if (list.size() == cen)
            list.add(new ArrayList<>());

        list.get(cen).add(node.val);

        if (node.left != null)
            serach(node.left,cen + 1);

        if (node.right != null)
            serach(node.right,cen + 1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null)
           return list;
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.add(root);
        int cen = 0;
        int count = 1;
        while (!linkedList.isEmpty()){
            list.add(new ArrayList<>());

            int length = linkedList.size();
            for (int i = 0; i < length; i++) {
                TreeNode t = linkedList.removeFirst();
                list.get(cen).add(t.val);

                if (count % 2 == 0){
                    if (t.left != null){
                        linkedList.add(t.left);
                    }

                    if (t.right != null){
                        linkedList.add(t.right);
                    }
                }else {
                    if (t.right != null){
                        linkedList.add(t.right);
                    }
                    if (t.left != null){
                        linkedList.add(t.left);
                    }
                }

            }
            cen++;
            count++;
        }
        return list;
    }

    public static void main(String[] args) {
        LevelOrder l = new LevelOrder();
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

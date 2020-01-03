package com._520.leetcode.demo;

import java.util.ArrayList;

/**
 *  输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 *  路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
        if (root == null)
            return result;
        traversalEveryNode(root, target, 0);
        return result;
    }

    private void traversalEveryNode(TreeNode root,int target, int current){
        if (root == null)
            return;
        current += root.val;
        list.add(root.val);

        if (current == target && root.left == null && root.right == null){
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }

        traversalEveryNode(root.left, target, current);

        traversalEveryNode(root.right, target, current);

        list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        FindPath findPath = new FindPath();
        ArrayList<ArrayList<Integer>> path = findPath.findPath(treeNode1, 22);
        System.out.println(path);
    }
}

package com._520.leetcode.test;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 *  注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Demo {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    private List<TreeLinkNode> linkNodes = new ArrayList<>();
    public TreeLinkNode getNext(TreeLinkNode pNode){
        TreeLinkNode parent = pNode;
        // 找到root结点
        while (parent.next != null){
            parent = parent.next;
        }
        // 中序遍历
        orderTree(parent);
        // 找到给定结点中序遍历的下一个结点
        for (TreeLinkNode linkNode : linkNodes) {
            if (linkNode.val == pNode.val){
                return linkNode;
            }
        }
        int index = 0;
        while (index < linkNodes.size()){
            if (index + 1 < linkNodes.size() && linkNodes.get(index).val == pNode.val) {
                return linkNodes.get(index + 1);
            }
            index++;
        }
        return null;
    }

    public TreeLinkNode getNext1(TreeLinkNode pNode){
        // 如果当前结点的右子树不为空，则当前结点中序遍历的下一个结点是右子树的最左结点
        if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 当前结点的右子树为空，当前结点是父结点的左结点，则当前结点的中序遍历下一个结点是父结点
        if (pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }

        // 当前结点的右子树为空，当前结点是父结点的右结点
        if (pNode.next != null){
            TreeLinkNode node = pNode.next;
            while (node.next != null && node.next.right == pNode){
                node = node.next;
            }
            return node.next;
        }

        return null;
    }
    private void orderTree(TreeLinkNode root){
        if (root.left != null){
            orderTree(root.left);
        }
        linkNodes.add(root);
        if (root.right != null){
            orderTree(root.right);
        }
    }
    public static void main(String[] args) {
    }
}

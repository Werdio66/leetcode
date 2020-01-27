package com._520.leetcode.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Print {

    public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        list.add(pRoot);
        // 记录层
        int leval = 0;
        while (!list.isEmpty()){
            ArrayList<Integer> arrayList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.remove(0);
                arrayList.add(node.val);
                if (node.left != null){
                    list.add(node.left);
                }
                if (node.right != null){
                    list.add(node.right);
                }
            }

            if (leval % 2 != 0){
                Collections.reverse(arrayList);
            }
            lists.add(arrayList);
            leval++;
        }
        return lists;
    }
}

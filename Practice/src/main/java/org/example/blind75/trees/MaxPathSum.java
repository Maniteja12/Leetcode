package org.example.blind75.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxPathSum {

 public static int maxPathSum(TreeNode root) {
            int maxValue[] = new int[1];
            maxValue[0] = Integer.MIN_VALUE;
            maxPathDown(root, maxValue);
            return maxValue[0];
        }
        private static int maxPathDown(TreeNode root, int[] maxValue){
            if(root == null)
                return 0;
            int left = Math.max(0, maxPathDown(root.left, maxValue));
            int right = Math.max(0, maxPathDown(root.right, maxValue));
            maxValue[0] = Math.max(maxValue[0], left + right+ root.val);
            return Math.max(left, right) + root.val;
        }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(-10);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.right = new TreeNode(7);
        node.right.left = new TreeNode(15);
        System.out.println(maxPathSum(node));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}



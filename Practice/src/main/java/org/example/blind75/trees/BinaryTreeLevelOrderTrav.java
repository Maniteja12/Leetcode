package org.example.blind75.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTrav {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> currList = new ArrayList<>();
            for(int i=0;i<levelSize;i++){
                TreeNode node = q.poll();
                currList.add(node.val);
                if(node.left!= null){
                    q.offer(node.left);
                }
                if(node.right!= null){
                    q.offer(node.right);
                }
            }
            res.add(currList);
        }
        return res;
    }
    /*
    Can also be done in recursice way, both take the same time and space complexity - O(n) and O(n)
    */
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> method2(TreeNode root){
        traverse(root, 0);
        return result;
    }
    public void traverse(TreeNode root, int level){
        if(root == null)
            return;
        if(result.size() == level)
            result.add(new ArrayList<>());
        result.get(level).add(root.val);
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
    public String serialize(TreeNode root){
        if(root == null) return " ";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node == null) {
                sb.append("n ");
                continue;
            }
            sb.append(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }
        return sb.toString();
    }
    public TreeNode deserliaze(String data){
        if(data.equals(" ")) return null;
        Queue<TreeNode> q = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i=1;i< values.length;i++){
            TreeNode node = q.poll();
            if(!values[i].equals("n ")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }
            if(!values[++i].equals("n ")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
}



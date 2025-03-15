package org.example.blind75.trees;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public boolean isValidBST(TreeNode root){
        return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean valid(TreeNode node, Integer min, Integer max){
        if(node == null) return true;
        if(!(node.val > min && node.val < max))
            return false;
        return valid(node.left, min, node.val) && valid(node.right, node.val, max);
    }
}

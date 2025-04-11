package org.example.blind75.trees;

import java.util.*;

public class AllNodesDistanceK {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                if(top.left!= null){
                    map.put(top.left.val, top);
                    q.offer(top.left);
                }
                if(top.right!= null){
                    map.put(top.right.val, top);
                    q.offer(top.right);
                }
            }
        }
        Map<Integer, Integer> visited = new HashMap<>();
        q.offer(target);
        while(k > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode top = q.poll();
                visited.put(top.val,1);

                if(top.left!= null && !visited.containsKey(top.left.val))
                    q.offer(top.left);
                if(top.right!= null && !visited.containsKey(top.right.val))
                    q.offer(top.right);
                if(map.containsKey(top.val) && !visited.containsKey(map.get(top.val).val))
                    q.offer(map.get(top.val));
            }
            k--;
        }
        while(!q.isEmpty())
            res.add(q.poll().val);
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)
                )
        );
        System.out.println(distanceK(root, new TreeNode(5), 2));

    }
}


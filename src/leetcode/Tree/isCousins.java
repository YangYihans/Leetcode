package leetcode.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;

public class isCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> dq = new ArrayDeque<>();
        if(root == null || (root.left == null && root.right == null))
            return false;
        dq.add(root);
        while(dq.isEmpty()){
            int size = dq.size();
            List<Integer> path = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                if(node.left != null){
                    dq.add(node.left);
                }
                if(node.right != null){
                    dq.add(node.right);
                }
                path.add(node.val);
            }
            if(!path.isEmpty() && (path.contains(x) && path.contains(y))){
                int index1 = path.indexOf(x);
                int index2 = path.indexOf(y);
                if(Math.abs(index1 - index2) > 1){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}

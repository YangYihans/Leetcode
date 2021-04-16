package leetcode.Tree.traverse;
import org.omg.CORBA.INTERNAL;

import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/14 10:25
 * @Description 102.二叉树的层序遍历
 * BFS思想的应用，借助队列来实现。
 */
public class levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int len = dq.size();
            List<Integer> list  = new ArrayList<>();
            for(int i = 0; i < len; i++){
                TreeNode treeNode = dq.removeFirst();
                list.add(treeNode.val);
                if(treeNode.left != null){
                    dq.add(treeNode.left);
                }
                if(treeNode.right != null){
                    dq.add(treeNode.right);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}

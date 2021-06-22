package leetcode.Offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.*;

/**
 * @Author Yang
 * @Date 2021/5/25 11:42
 * @Description 剑指 Offer 32 - I. 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class levelOrder_32_I {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return new int[]{};
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            for(int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                result.add(node.val);
                if(node.left != null){
                    dq.add(node.left);
                }
                if(node.right != null){
                    dq.add(node.right);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
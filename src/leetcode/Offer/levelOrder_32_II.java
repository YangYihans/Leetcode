package leetcode.Offer;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/5/25 11:48
 * @Description 剑指 Offer 32 - II. 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 */
public class levelOrder_32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            List<Integer> path = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = dq.removeFirst();
                path.add(node.val);
                if(node.left != null){
                    dq.add(node.left);
                }
                if(node.right != null){
                    dq.add(node.right);
                }
            }
            result.add(new ArrayList<>(path));
        }
        return result;
    }
}

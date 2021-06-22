package leetcode.Tree;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/3/24 16:13
 * @Description 230.二叉搜索树中第k个最小的元素
 */
public class kthSmallest {
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k){
        if(root == null){
            return -1;
        }
        process(root);
        int[] nums = res.stream().mapToInt(Integer::intValue).toArray();
        return nums[k-1];
    }
    public void process(TreeNode root){
        if(root == null)
            return;
        process(root.left);
        res.add(root.val);
        process(root.right);
    }
}

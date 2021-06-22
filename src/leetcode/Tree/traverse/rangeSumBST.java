package leetcode.Tree.traverse;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/27 9:15
 * @Description 938. 二叉搜索树的范围和
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和
 */
public class rangeSumBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        List<Integer> list = new ArrayList<>();
        process(root, list);
        int[] nums = list.stream().mapToInt(Integer::intValue).toArray();
        return getSum(nums, low, high);
    }

    private int getSum(int[] nums, int low, int high) {
        if(nums == null){
            return 0;
        }
        int len = nums.length;
        if(low == high){
            high = -1;
        }
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] != low){
                continue;
            }
            if(high == -1){
                return nums[i];
            }
            while(nums[i] <= high){
                sum += nums[i];
                i++;
            }
            break;
        }
        return sum;
    }

    private void process(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }

}

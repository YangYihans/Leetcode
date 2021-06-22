package leetcode.Tree;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @Author Yang
 * @Date 2021/3/30 15:47
 * @Description 构造最大二叉树
 *
 */
public class constructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums){
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = left; i <= right; i++){
            if(max < nums[i]){
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, left, index-1);
        root.right = build(nums, index+1, right);
        return root;
    }

}

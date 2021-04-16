package leetcode.Tree.traverse;
/**
 * @Author Yang
 * @Date 2021/4/14 12:03
 * @Description 129. 求根节点到叶节点数字之和
 */
public class sumNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int i) {
        if(root == null){
            return 0;
        }
        int temp = i * 10 + root.val;
        if(root.right == null && root.left == null){
            return temp;
        }
        return helper(root.left, temp) + helper(root.right, temp);
    }
}

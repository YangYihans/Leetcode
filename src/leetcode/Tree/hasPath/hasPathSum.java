package leetcode.Tree.hasPath;
/**
 * @Author Yang
 * @Date 2021/4/27 9:41
 * @Description 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和 targetSum 。
 */
public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(){

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

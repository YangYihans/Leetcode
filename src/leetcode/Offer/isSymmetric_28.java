package leetcode.Offer;

public class isSymmetric_28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return process(root.left, root.right);
    }

    private boolean process(TreeNode left, TreeNode right) {
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }
        return (left.val == right.val) && process(left.left, right.right) && process(left.right, right.left);
    }
}

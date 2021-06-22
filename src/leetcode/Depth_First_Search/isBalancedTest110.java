package leetcode.Depth_First_Search;

public class isBalancedTest110 {
    boolean flag = true;
    public static void main(String[] args) {
        isBalancedTest110 t1 = new isBalancedTest110();
    }
    public boolean isBalanced(TreeNode root)
    {
        height(root);
        return flag;

    }
    public int height(TreeNode root){
        if(flag && root != null){
            //叶子节点高度为0
            if(root.left == null && root.right == null){
                return 1;
            }
            //非叶子节点
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            if(Math.abs(leftHeight - rightHeight) > 1){
                flag = false;
            }
            return 1 + Math.max(leftHeight, rightHeight);
        }
        return 0;
    }
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }
}

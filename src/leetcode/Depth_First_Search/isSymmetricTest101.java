package leetcode.Depth_First_Search;
/*
力扣101：对称二叉树
给定一个二叉树，检查它是否是镜像对称的。
 */
public class isSymmetricTest101 {
    public static void main(String[] args) {
        isSymmetricTest101 t1 = new isSymmetricTest101();
    }
    public boolean isSymmetric(TreeNode root)
    {
        if(root == null)
            return true;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(TreeNode root, TreeNode root2)
    {
        if(root == null && root2 == null)
            return true;
        if(root == null || root2 == null)
            return false;
        if(root.val != root2.val)
            return false;
        return isMirror(root.left,root2.right) && isMirror(root.right,root2.left);
    }
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x )
        {
            val = x;
        }
    }
}

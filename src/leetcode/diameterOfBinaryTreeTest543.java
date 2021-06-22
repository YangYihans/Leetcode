package leetcode;
/*
力扣543：二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 */
public class diameterOfBinaryTreeTest543 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root)
    {
        if(root != null)
        {
            findDeep(root);
            return max;
        }
        return 0;
    }
    public int findDeep(TreeNode root)
    {
        if(root != null)
        {
            int right = findDeep(root.right);
            int left = findDeep(root.left);
            if(right+left>max)
            {
                max = right + left;
            }
            return Math.max(right,left)+1;
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}

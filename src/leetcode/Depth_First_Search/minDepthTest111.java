package leetcode.Depth_First_Search;

public class minDepthTest111 {
    int minLevel = 1000000;
    public static void main(String[] args) {
        minDepthTest111 t1 = new minDepthTest111();
    }
    public int minDepth(TreeNode root)
    {
        if(root == null)
            return 0;
        return 1;

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
    public void DFS(TreeNode root, int level)
    {
        if(root == null)
            return;

    }
}

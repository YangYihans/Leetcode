package leetcode.Depth_First_Search;

public class maxDepthTest104 {
    int maxLevel = 0;
    public static void main(String[] args) {
        maxDepthTest104 t1 = new maxDepthTest104();
    }
    public int maxDepth(TreeNode root)
    {
        if(root == null)
            return -1;
        DFS(root,1);
        return maxLevel;

    }
    public void DFS(TreeNode root, int level)
    {
        if(root == null)
            return;
        if(level >= maxLevel)
            maxLevel = level;
        DFS(root.left, level+1);
        DFS(root.right, level+1);
    }
    public class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x )
        {
            val = x;
        }
    }

}

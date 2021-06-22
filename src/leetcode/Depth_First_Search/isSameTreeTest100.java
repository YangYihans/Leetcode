package leetcode.Depth_First_Search;

/*
力扣100：判断两个树是否相同
 */
public class isSameTreeTest100 {
    public static void main(String[] args) {
        isSameTreeTest100 t1 = new isSameTreeTest100();
    }
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x)
        {
            val = x;
        }
    }
}

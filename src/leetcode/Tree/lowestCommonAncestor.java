package leetcode.Tree;

/**
 * 二叉搜索树的最近公共祖先
 */
public class lowestCommonAncestor {
    static TreeNode res = null;
    public static void main(String[] args) {

    }

    /**
     * 平衡二叉树的公共祖先
     * 如果两个是一左一右那root就是公共祖先
     * 如果都比左边的小，就往左子树遍历
     * 如果都比右边的小，就往右子树遍历。
     * @param root
     * @param p
     * @param q
     */
    public static void lca(TreeNode root, TreeNode p, TreeNode q)
    {
        if((root.val - p.val) * (root.val - q.val) <= 0)
            res = root;
        else if(root.val < p.val && root.val < q.val)
            lca(root.right,p,q);
        else
            lca(root.left, p, q);
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        lca(root, p, q);
        return res;
    }


    /**
     * 后序遍历的思想。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestorCommon(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null || p == root || q == root)
            return root;
        TreeNode left = lowestCommonAncestorCommon(root.left,p,q);
        TreeNode right = lowestCommonAncestorCommon(root.right, p ,q);
        if(left == null) return left;
        if(right == null) return right;
        return root;
    }

}

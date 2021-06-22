package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class perOrderUnRecur {
    public static void main(String[] args)
    {

    }
    public static List<Integer> perOrderUnRecur(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    /**
     * 递归的方式实现始终是中打印。
     * @param root
     * @param res
     */
    //前序：中左右
    public static void helper(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
    //中序：左中右
    public static void helper1(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right,res);
    }
    //后序：左右中
    public static void helper2(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val = x;
    }
}
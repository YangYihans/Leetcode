package leetcode.Tree;
/**
 * @Author Yang
 * @Date 2021/3/30 11:55
 * @Description 226.对树进行翻转
 */
public class invertTree {
    public TreeNode invertTree(TreeNode root){
        // base case
        if(root == null){
            return root;
        }
        /**** 前序遍历的位置 ****/
        // root节点需要交换它的左右子节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 让左右节点继续交换他们的子节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}

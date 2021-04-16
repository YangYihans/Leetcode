package leetcode.Tree.traverse;
/**
 * @Author Yang
 * @Date 2021/4/14 10:25
 * @Description 100.判断两个二叉树是否相同
 */
public class isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        // 递归
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

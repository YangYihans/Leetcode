package leetcode.Tree;
/**
 * @Author Yang
 * @Date 2021/3/30 16:14
 * @Description 98.验证一棵树是不是二叉搜索树
 */
public class isValidBST {
    public boolean isValidBST(TreeNode root){
        return condition(root, null, null);
    }

    /**
     * @Author Yang
     * @Date 2021/3/30 16:20
     * @Description 98.判断是否是二叉搜索树
     */
    public boolean condition(TreeNode root, TreeNode min, TreeNode max){
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min.val){
            return false;
        }
        if(max != null && root.val >= max.val){
            return false;
        }
        return condition(root.left, min, root) && condition(root.right, root, max);
    }

    /**
     * @Author Yang
     * @Date 2021/3/30 16:21
     * @Description 700. 二叉搜索树的搜索 ，返回以该节点为根的子树
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        else if(root.val < val){
            return searchBST(root.right, val);
        }else{
            return searchBST(root.left, val);
        }
    }

    /**
     * @Author Yang
     * @Date 2021/3/30 16:47
     * @Description 701. 二叉搜索树的插入。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val < val){
            root.right =  insertIntoBST(root.right, val);
        }else{
            root.left =  insertIntoBST(root.left, val);
        }
        return root;
    }

    /**
     * @Author Yang
     * @Date 2021/3/30 16:52
     * @Description 450. 删除二叉树的节点
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val == key){
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }
            TreeNode newMid = findNode(root.right);
            root.val = newMid.val;
            root.right = deleteNode(root.right, newMid.val);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    public TreeNode findNode(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}

package leetcode.Offer;

public class mirrorTree_27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}

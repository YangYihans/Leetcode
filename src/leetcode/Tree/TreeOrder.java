package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的遍历，非递归
 */
public class TreeOrder {
    public void preOrder(TreeNode root)
    {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            System.out.println(node);
            //因为栈是先进后出，所以应该是先压右孩子，再压左孩子
            if(root.right != null)
                stack.push(node.right);
            if(root.left != null)
                stack.push(node.left);
        }
    }

    public void postOrder(TreeNode root)
    {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> helper = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            helper.push(node);
            if(root.left != null)
                stack.push(root.left);
            if(root.right != null)
                stack.push(root.right);

        }
        while(!helper.isEmpty())
        {
            System.out.println(helper.pop().val + " ");
        }
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p =root;
        ArrayList<Integer> list = new ArrayList<>();
        while(p != null || !stack.isEmpty()){
            //一直走到最左边的左孩子
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            list.add(p.val);
            p = p.right;
        }
        return list;
    }
}

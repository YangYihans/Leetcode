package leetcode.Tree.traverse;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.rmi.PortableRemoteObject;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/25 9:22
 * @Description 897. 递增顺序搜索树
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class increasingBST {
    public TreeNode increasingBST(TreeNode root){
        Deque<Integer> res = new ArrayDeque<>();
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        process(root, res);
        return build(res);
    }

    public static void process(TreeNode root, Deque<Integer> res){
        if(root == null){
            return;
        }
        process(root.left, res);
        res.add(root.val);
        process(root.right, res);
    }

    public static TreeNode build(Deque<Integer> res){
        TreeNode end = null;
        if(!res.isEmpty()){
            int pop = res.removeLast();
            end = new TreeNode(pop);
        }
        TreeNode result = null;
        while(!res.isEmpty()){
            int pop = res.removeLast();
            result = new TreeNode(pop, null, end);
            end = result;
        }
        return result;
    }


}

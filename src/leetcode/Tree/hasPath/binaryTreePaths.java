package leetcode.Tree.hasPath;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/28 9:46
 * @Description 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null){
            return null;
        }
        StringBuilder path = new StringBuilder();
        process(root, res, path);
        return res;
    }
    public void process(TreeNode root, List<String>res, StringBuilder path){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            path.append(root.val);
            res.add(path.toString());
            path.deleteCharAt(path.length()-1);
            return;
        }
        if(root.left != null){
            path.append(root.val);
            process(root.left, res, path);
            path.deleteCharAt(path.length()-1);
        }
        if(root.right != null){
            path.append(root.val);
            process(root, res, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}

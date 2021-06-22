package leetcode.Tree.hasPath;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/4/28 9:31
 * @Description 113. 路径总和 II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径
 * 思路：标准的树的dfs遍历，可以套用递归思想的模板。
 */
public class pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null){
            return res;
        }
        process(root, res, path, targetSum);
        return res;
    }

    public static void process(TreeNode root, List<List<Integer>> res, List<Integer> path, int targetSum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null) {
            if (targetSum == root.val) {
                path.add(root.val);
                res.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }
            return;
        }
        if(root.left != null){
            path.add(root.val);
            process(root.left, res, path, targetSum-root.val);
            path.remove(path.size()-1);
        }
        if(root.right != null){
            path.add(root.val);
            process(root.right, res, path, targetSum-root.val);
            path.remove(path.size()-1);
        }
    }
}

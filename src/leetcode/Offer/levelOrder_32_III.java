package leetcode.Offer;
import java.util.*;
/**
 * @Author Yang
 * @Date 2021/5/25 11:53
 * @Description 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class levelOrder_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Stack<TreeNode> stackOdd = new Stack<>();
        Stack<TreeNode> stackEven = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        stackOdd.push(root);
        int levelNum = 1;
        while(!stackOdd.isEmpty() || !stackEven.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            if(levelNum%2 == 1)
            {
                while(!stackOdd.isEmpty())
                {
                    TreeNode node = stackOdd.pop();
                    level.add(node.val);
                    if(node.left != null)
                        stackEven.push(node.left);
                    if(node.right != null)
                        stackEven.push(node.right);
                }
            }
            else
            {
                while(!stackEven.isEmpty())
                {
                    TreeNode node = stackEven.pop();
                    level.add(node.val);
                    if(node.right != null)
                        stackOdd.push(node.right);
                    if(node.left != null)
                        stackOdd.push(node.left);
                }
            }
            if(!level.isEmpty())
                res.add(level);
            levelNum++;
        }
        return res;
    }
}

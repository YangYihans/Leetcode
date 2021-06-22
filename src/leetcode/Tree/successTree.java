package leetcode.Tree;

import java.util.*;

/**
 * 二叉树的层序遍历
 */
public class successTree {
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if(root != null)
        {
            dfs(res, root, 0);
        }
        return res;
    }
    public void dfs(List<List<Integer>> res, TreeNode node, int level)
    {
        if(res.size() - 1 < level)
        {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        if(node.left != null)
        {
            dfs(res, node.left, level+1);
        }
        if(node.right != null)
        {
            dfs(res, node.right, level+1);
        }
    }

    /**
     * 先创建一个队列，然后根放大队列中去。
     * 当队列不为空开始循环遍历
     * 先将队列头出队，加入到链表中去。然后将它的左右子树分别入队。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode cur = q.peek();
                q.poll();
                if(cur == null)
                    continue;
                level.add(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            if(!level.isEmpty())
                res.add(level);
        }
        return res;
    }
    
    public List<Integer> levelOrder2(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left != null)
                queue.offer(node.left);
            if(node.right != null)
                queue.offer(node.right);

        }

        return res;

    }
}

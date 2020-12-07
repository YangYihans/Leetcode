import javax.swing.*;
import java.util.*;

public class Tree {
    public static List<Integer> perOrderUnRecur(TreeNode root)
    {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    /**
     * 使用递归的方式实现树的前序遍历，中序遍历和后序遍历
     * 递归的方式实现始终是中打印。
     * @param root
     * @param res
     */
    //前序：中左右
    public static void helper(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        res.add(root.val);
        helper(root.left, res);
        helper(root.right, res);
    }
    //中序：左中右
    public static void helper1(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right,res);
    }
    //后序：左右中
    public static void helper2(TreeNode root, List<Integer> res)
    {
        if(root == null)
            return;
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }

    /**
     * @Author Yang
     * @Date 2020/12/6 11:08
     * @Description 二叉树的锯齿层次遍历
     * 使用两个栈来分别模拟 二叉树从左到右遍历和从右到左遍历
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        /**
         * stack1 : right --> left
         * stack2 : left  --> right
         */
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        int level = 1;
        /**
         * 这里两个栈交替为空
         */
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(level % 2 == 1){
                while(!stack1.isEmpty()){
                    TreeNode temp = stack1.pop();
                    list.add(temp.val);
                    /**
                     * 这里需要判断是否为空的情况，否则会报空指针的异常。
                     */
                    if(temp.left != null){
                        stack2.push(temp.left);
                    }
                    if(temp.right != null){
                        stack2.push(temp.right);
                    }
                }
            }else{
                while(!stack2.isEmpty()){
                    TreeNode temp = stack2.pop();
                    list.add(temp.val);
                    if(temp.right != null){
                        stack1.push(temp.right);
                    }
                    if(temp.left != null){
                        stack1.push(temp.left);
                    }
                }
            }
            level++;
            if(!list.isEmpty()){
                result.add(list);
            }
        }
        return result;
    }

    /**
     * 普通的二叉树的层序遍历
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

    /**
     * @Author Yang
     * @Date 2020/12/6 11:32
     * @Description 根据前序遍历和中序遍历中构建二叉树
     * 前序： 中左右。
     * 中序： 左中右
     */
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder == null || inorder == null){
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 递归的方式生成子树
     * @param preorder 前序遍历坐标
     * @param preLeft  前序遍历的左起点
     * @param preRight 前序遍历的右终点
     * @param inorder  中序遍历的坐标
     * @param inLeft   中序遍历的左起点
     * @param inRight  中序遍历的右起点
     * @return
     */
    public TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight){
        if(preLeft > preRight || inLeft > inRight){
            return null;
        }
        int pivot = preorder[preLeft];  // 前序遍历序列的第一个节点
        TreeNode node = new TreeNode(pivot);
        int pivotIndex = inLeft;  // 初始化中序遍历起始位置
        /**
         * 找到前序遍历的节点在中序遍历中的位置。
         * 找中点
         */
        while(inorder[pivotIndex] != pivot){
            pivotIndex++;
        }
        /**
         * 构建左子树，
         *  * preorder中的左子树的坐标为 [preLeft, pivotIndex - inLeft + preLeft]
         *  * inorder 中的左子树的坐标为 [inLeft, pivotIndex - 1]
         *
         * 构建右子树
         *  * preorder中的右子树坐标为 [pivotIndex - inLeft + preLeft + 1, preRight]
         *  * inorder 中的右子树坐标为 [pivotIndex + 1, inRight]*
         */
        node.left = buildTree(preorder, preLeft + 1, pivotIndex - inLeft + preLeft, inorder, inLeft, pivotIndex-1);
        node.right = buildTree(preorder, pivotIndex - inLeft + preLeft + 1, preRight, inorder, pivotIndex + 1, inRight);
        return node;
    }

    /**
     * @Author Yang
     * @Date 2020/12/7 10:38
     * @Description 二叉搜索树中第K小的元素
     * 二叉搜索的树的中序遍历是由小到大排序的，只需要迭代k次就能找到第k小的元素
     */
    public static int time = 0;
    public static int result = 0;
    public int kthSmallest(TreeNode root, int k){
        if(root == null){
            return -1;
        }

        /*
        List<Integer> help = new ArrayList<>();
        search(root, help);
        int[] result = help.stream().mapToInt(Integer::intValue).toArray();
        return result[k-1];
        */

        search(root, k);
        return result;
    }
    public void search(TreeNode root, List<Integer> help){
        if(root == null){
            return;
        }
        search(root.left, help);
        help.add(root.val);
        search(root.right, help);
    }

    /**
     * 含有剪枝的中序遍历
     * @param root 根节点
     * @param k    遍历次数
     * time++ 放在左子树遍历后，这样才是中序遍历。
     */
    public void search(TreeNode root, int k){
        //剪枝
        if(root == null || time > k) return;
        search(root.left, k);
        time++;
        if(time == k)
            result = root.val;
        search(root.right, k);
    }

}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x)
    {
        val = x;
    }
}
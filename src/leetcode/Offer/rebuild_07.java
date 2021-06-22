package leetcode.Offer;

import java.util.HashMap;

public class rebuild_07 {
    int[] preorder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return process(0, 0, inorder.length - 1);
    }

    /**
     *
     * @param pre_root_index: 根节点在前序遍历中的下标
     * @param in_left_index:  该节点在中序遍历的左边界
     * @param in_right_index: 该节点在中序遍历的右边界
     * @return
     */
    public TreeNode process(int pre_root_index, int in_left_index, int in_right_index){
        if(in_left_index < in_right_index){
            return null;
        }
        int in_root_index =  map.get(preorder[pre_root_index]);
        TreeNode node = new TreeNode(preorder[pre_root_index]);
        node.left = process(pre_root_index + 1, in_left_index, in_root_index - 1);
        node.right = process(pre_root_index + in_root_index - in_left_index + 1, in_root_index + 1, in_right_index);
        return node;
    }

}


class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val = x;
    }
}
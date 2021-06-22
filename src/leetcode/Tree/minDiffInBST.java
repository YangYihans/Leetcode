package leetcode.Tree;

import java.util.*;
import java.util.ArrayList;

/**
 * @Author Yang
 * @Date 2021/4/13 9:09
 * @Description 783. 二叉搜索树节点最小距离
 */
public class minDiffInBST {
    public static int minDiffInBST(TreeNode root) {
        if(root == null){
                return 0;
            }
            List<Integer> list = new ArrayList<>();
        process(root, list);
            int[] res = list.stream().mapToInt(Integer::intValue).toArray();
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < res.length; i++){
                int temp = res[i] - res[i-1];
                min = Math.min(min, temp);
            }
        return min;
    }

    public static void process(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }
}

package leetcode.Array.prefix;
/**
 * @Author Yang
 * @Date 2021/5/12 9:51
 * @Description 307. 区域和检索 - 数组可修改
 * 给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。
 * 多次修改某个数求区间和————树状数组
 */
public class NumArray_II {
    int[] tree;
    int lowbit(int x){
        return x & -x;
    }

    int query(int x){
        int ans = 0;
        for(int i = x; i > 0; i -= lowbit(i)){
            ans += tree[i];
        }
        return ans;
    }

    void add(int x, int u){
        for(int i = x;  i <= n; i += lowbit(i)){
            tree[i] += u;
        }
    }

    int[] nums;
    int n;

    public NumArray_II(int[] _nums) {
        nums = _nums;
        n = nums.length;
        tree = new int[n + 1];
        for(int i = 0; i < n; i++){
            add(i+1, nums[i]);
        }
    }

    // 将 nums[index] 的值更新为 val
    public void update(int index, int val) {
        add(index+1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right+1) - query(left);
    }
}

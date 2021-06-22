package leetcode;
/*
力扣55题
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例 1:
输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。

 */
public class canJumpTest55 {
    public static void main(String [] args)
    {
        canJumpTest55 t1 = new canJumpTest55();
        int [] nums = new int[]{3,2,1,0,4};
        System.out.println(t1.canJump(nums));
        System.out.println(t1.canJump1(nums));
        System.out.println(t1.canJump2(nums));
    }
    /*
    自底向上的模式
    从后向前遍历，从倒数第二的位置开始，初始化每一点只跳一个单位。
    如果该点处对应的跳跃距离>=需要的距离,还是默认跳一步，即该点的后继是无论如何都可以达到的。
    如果小于1，那么在跳跃过程中就必须越过这点，它的上一个点的跳跃距离就要加一。
    终止条件：在最初始的位置，如果跳跃距离不为1，即没有满足上一个点需要的跳跃距离的条件，则意味着失败，否则是成功的。
     */
    boolean canJump(int [] nums)
    {
        int n = 1;
        for(int i = nums.length-2; i >= 0; i--)
        {
            if(nums[i]>=n)
            {
                n=1;
            }
            else
                n++;
            if(i == 0 && n > 1)
                return false;
        }
        return true;
    }
    /*
    回溯法：
    从第一个位置跳到所有位置的解决方案，从第一个位置开始，模拟从这个位置可以跳到的所有的位置，然后再在新跳到的位置，模拟能跳到的所有的方案
    以此类推，直到得到最大的距离，如果仍然没有到达终点，则递归回初始点继续。
    会超时。
     */
    boolean canJump1(int [] nums)
    {
        return jump(0,nums);
    }
    boolean jump(int position, int [] nums1)
    {
        if(position == nums1.length-1)
            return true;
        int maxPosition = Math.min(position+nums1[position],nums1.length-1); //当前节点能够跳到的最远的距离
        if(maxPosition == nums1.length-1)
            return true;
        for(int currentPosition = position+1; currentPosition <= maxPosition; currentPosition++)
        {
            if(jump(currentPosition,nums1))
            {
                return true;
            }
        }
        return false;
    }
    /*
    贪心
    将能够到达最后位置的点记录下来称为“好点”，每一个节点检测是否存在一步就能跳跃到“好点”的位置，如果是则记录下来，
    最后确认左侧好点的最小的位置是否是初始点，如不是则不存在能跳到最后的方法。
     */
    boolean canJump2(int [] nums)
    {
        int goodPos = nums.length-1;
        for(int i = nums.length-1; i >= 0; i--)
        {
            if(nums[i]+i >= goodPos)
                goodPos = i;
        }
        return goodPos==0;
    }
}

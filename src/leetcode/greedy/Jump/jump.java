package leetcode.greedy.Jump;
/**
 * @Author Yang
 * @Date 2021/4/10 15:13
 * @Description 45. 跳跃游戏 II
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
 */
public class jump {
    public static int jump(int[] nums){
        int len = nums.length;
        int end = 0, farthest = 0;
        int jumps = 0;
        //不访问最后一个元素，这是因为在访问最后一个元素之前，我们的边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了
        for(int i = 0; i < len - 1; i++){
            farthest = Math.max(i + nums[i], farthest);
            if(i == end){
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

}

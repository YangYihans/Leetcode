package leetcode.slideWindow;

import java.util.*;

public class slideWindow {
    public int characterReplacement(String s, int k){
        if(s == null)
            return 0;
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        int left = 0;
        int right = 0;
        int historyCharMax = 0;
        for(; right <= left; right++){
            int index = chars[right] - 'A';
            map[index]++;
            historyCharMax = Math.max(historyCharMax, map[index]);
            if(right - left + 1 > historyCharMax + k){
                map[chars[left] - 'A']--;
                left++;
            }
        }
        return chars.length - left;
    }

    /**
     * @Author Yang
     * @Date 2021/3/31 12:05
     * @Description 239.滑动窗口的最大值
     */
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(k == 1){
            return nums;
        }
        List<Integer> list = new ArrayList<Integer>();
        Deque<Integer> dq = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[i]){
                dq.removeLast();
            }
            if(!dq.isEmpty() && i - dq.getFirst() > k -1){
                dq.removeFirst();
            }
            dq.addLast(i);
            if(i >= k -1){
                list.add(nums[dq.getFirst()]);
            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(maxSlidingWindow(new int[]{7,2,4}, 2));
    }
}

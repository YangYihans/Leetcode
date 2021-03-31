import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈思想合集
 */
public class monotonicStack {
    /**
     * @Author Yang
     * @Date 2020/12/2 10:38
     * @Description 移掉K位数字，使得剩下的数字最小
     */
    public String removeKdigits(String num, int k){
        if(k == 0)
            return num;
        if(k == num.length())
            return "0";
        ArrayDeque<Character> ad = new ArrayDeque<>();
        String res = "";
        for(char digit : num.toCharArray()){
            /**
             * 双端队列不为空 且删除次数大于0 且队尾元素比当前插入的元素大
             */
            while(!ad.isEmpty() && k > 0 && digit < ad.getLast()){
                ad.removeLast();
                k--;
            }
            ad.addLast(digit);
        }
        for(int i = 0; i < k; i++){
            ad.removeLast();
        }
        while(ad.size() > 0 && ad.getFirst() == '0'){
            ad.removeFirst();
        }
        if(ad.isEmpty()){
            return "0";
        }
        while(!ad.isEmpty()){
            res += ad.poll();
        }
        return res;
    }

    public String removeKDigits(String num, int k){
        if(k == num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        String res = "";
        StringBuilder result = new StringBuilder();
        for(char digit : num.toCharArray()){
            while(!stack.isEmpty() && k > 0 && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k > 0){
            stack.pop();
            k--;
        }
        while (!stack.isEmpty()){
            result.append(stack.peek());
            stack.pop();
        }
        while(result.length() > 0 && result.charAt(result.length()-1) == '0'){
            result.deleteCharAt(result.length()-1);
        }
        if(result.length() == 0){
            return "0";
        }
        return result.reverse().toString();
    }

    /**
     * @Author Yang
     * @Date 2020/12/2 11:57
     * @Description 去除重复字母，需要保证返回结果的字典序最小，要求不能打乱其他字母的顺序
     * 还是利用的单调栈的思想
     */
    public String removeDuplicateLetters(String s){
        Stack<Character> stack = new Stack<>();
        String result = "";
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char digit = chars[i];
            if(stack.contains(digit)){
                continue;
            }
            /**
             * 栈不为空， 栈顶元素大于当前元素， 栈顶元素在当前索引后还存在， 入栈。
             * s.indexOf(stack.peek(), i) 通过i可以指定起始索引的位置
             */
            while(!stack.isEmpty() && digit < stack.peek() && s.indexOf(stack.peek(), i) != -1){
                stack.pop();
            }
            stack.push(digit);
        }
        /**
         * 倒序输出栈中的元素
         */
        while(!stack.isEmpty()){
            result = stack.peek() + result;
            stack.pop();
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/2 14:39
     * @Description 拼接最大数。现在从这两个数组中选出 k (k <= m + n) 个数字拼接成一个新的数，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[k];
        Arrays.fill(result, -1);
        /**
         * start : len1 取值的起始最小值。 （最少取几个）
         * end：len1 取值的终止的最大值。 （最多取几个）
         * 遍历start - end 得到nums1的个数取值区间
         * 用k相减就可以得到nums2的个数取值区间
         */
        int start = Math.max(0, k-len2);
        int end = Math.min(k, len1);
        for(int i = start; i <= end; i++){
            int[] seq1 = pickMax(nums1, i);
            int[] seq2 = pickMax(nums2, k - i);
            int[] temp = mergeNum(seq1, seq2);
            if(compare(temp, 0, result, 0)){
                for(int j = 0; j < k; j++){
                    result[j] = temp[j];
                }
            }
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/2 14:51
     * @Description 单调栈的思想，取出len个nums中的最大值
     * 最后要在stack中得到len个数， 所以在单调递减栈中应该是要丢弃k-len个数。
     */
    public int[] pickMax(int[] nums, int len){
        int num_len = nums.length;
        if(num_len < len){
            return nums;
        }
        int drop_len = num_len - len;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && drop_len > 0 && nums[i] > stack.peek()){
                stack.pop();
                drop_len--;
            }
            stack.push(nums[i]);
        }
        while(drop_len > 0){
            stack.pop();
            drop_len--;
        }
        for(int i = 0; i < stack.size(); i++){
            result[i] = stack.get(i);
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/2 15:22
     * @Description 归并排序的思想
     * 不同之处是要考虑相同元素时，应该考虑其后面的元素的大小顺序
     */
    public int[] mergeNum(int[] nums1, int[] nums2){
        int[] result = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while(cur < result.length){
            if(compare(nums1, p1, nums2, p2)){
                result[cur] = nums1[p1];
                p1++;
            }else{
                result[cur] = nums2[p2];
                p2++;
            }
            cur++;
        }
        return result;
    }

    public boolean compare(int[] nums1, int p1, int[] nums2, int p2){
        if(p2 >= nums2.length)
            return true;
        if(p1 >= nums1.length)
            return false;
        if(nums1[p1] > nums2[p2]){
            return true;
        }else if(nums1[p1] < nums2[p2]){
            return false;
        }else{
            return compare(nums1, p1+1, nums2, p2+1);
        }
    }

    /**
     * @Author Yang
     * @Date 2021/3/31 11:36
     * @Description 496.下一个更大的元素
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2){
        if(nums1.length == nums2.length && nums2.length == 1){
            return new int[]{-1};
        }
        Stack<Integer> stack = new Stack<>();
        int[] next = new int[nums2.length];
        int[] res = new int[nums1.length];
        Arrays.fill(next, -1);
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                next[stack.peek()] = nums2[i];
                stack.pop();
            }
            stack.push(i);
        }
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    res[i] = next[j];
                }
            }
        }
        return res;
    }


    /**
     * @Author Yang
     * @Date 2021/3/31 11:55
     * @Description 503.下一个更大的元素II 数组是环形的
     */
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);  //默认值为-1
        Stack<Integer> stack = new Stack<>();  // stack中存放的是索引
        for(int i = 0; i < 2 * len; i++){
            int num = nums[i % len];
            while(!stack.isEmpty() && num > nums[stack.peek()]){
                res[stack.pop()] = num;
            }
            if(i < len){
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    }
}

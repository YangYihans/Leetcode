package March;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;
import com.sun.jndi.toolkit.ctx.AtomicContext;
import org.omg.CORBA.INTERNAL;
import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.*;

public class solution {
    /**
     * @Author Yang
     * @Date 2021/3/8 11:02
     * @Description 分割回文串， 将s分割成一些子串，使得每个子串都是回文串。
     */
    public static List<List<String>> partition(String s){
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        dfs(chars, 0, len, stack, res);
        return res;
    }

    static void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res){
        if(index == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = index; i < len; i++){
            if(!checkPalindrom(chars, index, i)){
                continue;
            }
            path.addLast(new String(chars, index, i+1-index));
            dfs(chars, i+1, len, path, res);
            path.removeLast();
        }
    }

    private static boolean checkPalindrom(char[] chars, int left, int right) {
       while(left < right){
           if(chars[left] != chars[right]){
               return false;
           }
           right--;
           left++;
       }
       return true;
    }

    /**
     * @Author Yang
     * @Date 2021/3/8 11:04
     * @Description 最长回文子串
     */
    public static String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len; j++){
                if(j - i + 1 > maxLen && checkPalindrom(chars, i, j)){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    public static String longestPalindrome2(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else{
                    if((j-1) - (i+1) < 2){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin+maxLen);
    }

    /**
     * @Author Yang
     * @Date 2021/3/9 21:05
     * @Description 1047.删除字符串中所有重复相邻项
     */
    public static String removeDuplicates(String S){
        int len = S.length();
        if(len < 2){
            return S;
        }
        return isDuplicate(S);

    }
    public static String isDuplicate(String s){
        if(s == null)
            return "";
        int len = s.length();
        char[] charsArray = s.toCharArray();
        for(int i = 0; i < len-1; i++){
            if(charsArray[i] == charsArray[i+1]){
                s = s.substring(0, i) + s.substring(i+2, len);
                return isDuplicate(s);
            }
        }
        return s;
    }

    public static String isDuplicate1(String S){
        Stack<Character> stack = new Stack<>();
        char[] charsArray = S.toCharArray();
        for(char s : charsArray){
            if(!stack.isEmpty() && stack.peek() == s){
                stack.pop();
            }else{
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.toString().equals("") ? "" : sb.toString();
    }

    /**
     * @Author Yang
     * @Date 2021/3/9 21:59
     * @Description
     * 可以遍历一次数组，如果元素是单调递减的（则他们的「下一个更大元素」相同），我们就把这些元素保存，直到找到一个较大的元素；
     * 把该较大元素逐一跟保存了的元素比较，如果该元素更大，那么它就是前面元素的「下一个更大元素」
     */
    public static int[] nextGreaterElements(int[] nums){
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

    /**
     * @Author Yang
     * @Date 2021/3/10 23:27
     * @Description 224.基本计算器
     * 考察的是栈。
     */
    public static int calculate(String s){
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 9:42
     * @Description 227.基本计算器II
     * 考察的是栈。
     */
    public static int calculate_1(String s){
        Stack<Integer> stack = new Stack<>();
        s = s.trim();
        char[] charsArray = s.toCharArray();
        char sign = '+';
        int res = 0;
        int len = s.length();
        int i = 0;
        int num = 0;
        while(i < len){
            if(charsArray[i] == ' '){
                i++;
                continue;
            }
            if(charsArray[i] >= '0'){
                num = num * 10 + charsArray[i] - '0';
            }if(charsArray[i] < '0' || i == len - 1){ // 判断当前是符号，或者是最后一个数， 就该进行符号运算了
                /**
                 * 这里的符号都是这个数之前的符号，所以+就直接入栈，-就取相反数入栈
                 * * / 都是栈顶的元素和这个数进行操作。
                 */
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*' || sign == '/'){
                    int temp = sign == '*' ? stack.peek() * num : stack.peek() / num;
                    stack.pop();
                    stack.push(temp);
                }
                sign = charsArray[i];
                num = 0;
            }
            i++;
        }
        for(int j = 0; j < stack.size(); j++){
            res += stack.elementAt(j);
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 10:56
     * @Description 150.逆波兰表达式
     */
    public static int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        int num = 0;
        for(int i = 0; i < len; i++){
            char[] charArray = tokens[i].toCharArray();
            if(charArray.length > 1){
                int index = 0;
                if(charArray[index] >= '0'){
                    while(index < charArray.length && charArray[index] >= '0'){
                        num = num * 10 - '0' + charArray[index];
                        index++;
                    }
                    stack.push(num);
                }else{
                    index = 1;
                    while(index < charArray.length && charArray[index] >= '0'){
                       num = num * 10 - '0' + charArray[index];
                       index++;
                    }
                    stack.push(-num);
                }
                num = 0;
            }else{
                if(charArray[0] >= '0'){
                    stack.push(Integer.parseInt(tokens[i]));
                }else if(charArray[0] == '+'){
                    int temp = stack.pop() + stack.pop();
                    stack.push(temp);
                }else if(charArray[0] == '-'){
                    int temp = stack.pop();
                    temp = stack.pop() - temp;
                    stack.push(temp);
                }else if(charArray[0] == '*'){
                    int temp = stack.pop();
                    temp = stack.pop() * temp;
                    stack.push(temp);
                }else{
                    int temp = stack.pop();
                    temp = stack.pop() / temp;
                    stack.push(temp);
                }
            }
        }
        return stack.pop();
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 11:39
     * @Description 739.每日温度
     * 单调栈的思想: 栈里面保存的是下标
     */
    public static int[] dailyTemperatures(int[] T){
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        int[] res = new int[len];
        Arrays.fill(res, 0);
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && T[stack.peek()] < T[i]){
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 12:04
     * @Description 494.目标和
     * 深度优先遍历的思想。
     */
    private static int count = 0;
    private static int sum = 0;
    public static int findTargetSumWays(int[] nums, int S){
        dfs(0, nums, S);
        return count;
    }

    public static void dfs(int cur, int[] nums, int S){
        if(cur == nums.length){
            if(S == sum){
                count++;
            }
            return;
        }
        sum += nums[cur];
        dfs(cur+1, nums, S);
        sum -= nums[cur];

        sum -= nums[cur];
        dfs(cur+1, nums, S);
        sum += nums[cur];
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 16:35
     * @Description 581.最短无序子数组
     */
    public static int findUnsortedSubarray(int[] nums){
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int end = 0;
        int start = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] < max){
                end = i;
            }else{
                max = nums[i];
            }
            if(nums[len-1-i] > min){
                start = len - 1 - i;
            }else{
                min = nums[len - 1 - i];
            }
        }
        return end - start + 1;
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 17:25
     * @Description 1.两数之和
     * map: key -> nums[i]  value -> index
     */
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++){
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{i, map.get(temp)};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * @Author Yang
     * @Date 2021/3/11 17:37
     * @Description 15.三数之和
     */
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 3){
            return res;
        }
        int left, right;
        for(int i = 0; i < nums.length; i++){
            left = i + 1;
            right = nums.length - 1;
            if(nums[i] > 0){
                break;
            }
            if(i > 0 || nums[i] == nums[i+1]){
                continue;
            }
            while(left < right){
                if(nums[left] + nums[right] + nums[i] == 0){
                    res.add(Arrays.asList(nums[left], nums[right], nums[i]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/12 10:09
     * @Description 331. 验证二叉树的前序序列化
     * 可以用图的思想，入度和出度
     * 字符串类型相比较一定要用equals
     */
    public static boolean isValidSerialization(String preorder){
        if(preorder.equals("#")){
            return true;
        }
        int in_degree = 0, out_degree = 0;
        String[] split = preorder.split(",");
        int len = split.length;
        for(int i = 0; i < len; i++){
            if(i == 0){
                if(split[i] == "#"){
                    return false;
                }
                out_degree += 2;
                continue;
            }
            if(split[i].equals("#")){
                in_degree += 1;
            }
            else{
                in_degree += 1;
                out_degree += 2;
            }
            if(i != len - 1 && in_degree >= out_degree)
                return false;
        }
        return in_degree == out_degree;
    }

    /**
     * @Author Yang
     * @Date 2021/3/12 10:57
     * @Description 3.无重复字符的最大子串
     * 滑动窗口的思想考察
     */
    public static int lengthOfLongestSubstring(String s){
        if(s == ""){
            return 0;
        }
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = chars.length;
        int start = 0;
        int end = 0;
        int ans = 0;
        while(end < len){
            if (map.containsKey(chars[end])) {
//                int index;
//                index = map.get(chars[end]);
//                start = Math.max(start, index + 1);   // start的改变可能会导致原来在map中的值不在窗口中了 。
//                index = end;
//                map.put(chars[end], index);
                start = Math.max(start, map.get(chars[end]) + 1);
            }
            map.put(chars[end], end);
            ans = Math.max(ans, end - start + 1);
            end++;
        }
        return ans;
    }

    /**
     * @Author Yang
     * @Date 2021/3/12 11:21
     * @Description 剑指59 - I 找出滑动窗口中的最大值。
     * 单调栈的思想去做。
     */
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0, j = 0; i < nums.length; i++) {
            if(!queue.isEmpty() && i - queue.peek() >= k) {
                queue.poll();
            }
            while(!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k - 1) {
                res[j++] = nums[queue.peek()];
            }
        }

        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/15 9:52
     * @Description 54.螺旋矩阵 按照顺时针螺旋顺序打印出矩阵内的所有的元素。
     *
     */
    public static List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int row_start = 0, col_start = 0, row_end = m, col_end = n;
        List<Integer> res = new ArrayList<>();
        while(row_start <= row_end){
            for(int j = col_start; j <= col_end; j++){
                res.add(matrix[row_start][j]);
            }
            row_start++;
            /**
             * if判断是很有必要的。 不然会重复计算。
             * if判断让最后一点最快跳出。
             */
            if(row_start > row_end)
                break;
            for(int i = row_start; i <= row_end; i++){
                res.add(matrix[i][col_end]);
            }
            col_end--;
            if(col_end < col_start)
                break;
            for(int j = col_end; j >= col_start; j--){
                res.add(matrix[row_end][j]);
            }
            row_end--;
            if(row_end < row_start)
                break;
            for(int i = row_end; i >= row_start; i--){
                res.add(matrix[i][col_start]);
            }
            col_start++;
            if(col_start > col_end)
                break;
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/15 11:16
     * @Description 5.最长回文子串
     * 中心扩展法
     */
    public static String longestPalindrome_center(String s){
        if(s == null || s.length() < 2)
            return s;
        int len = s.length();
        char[] chars = s.toCharArray();
        int max_length = 0, start = 0;
        for(int i = 0; i < len-1; i++){
            int odd_len = getLongest(chars, i, i);
            int even_len = getLongest(chars, i, i+1);
            int max_temp = Math.max(odd_len, even_len);
            if(max_length < max_temp){
                max_length = max_temp;
                start = i - (max_length - 1) / 2;
            }
        }
        return s.substring(start, start+max_length);
    }
    
    /**
     * @Author Yang
     * @Date 2021/3/15 15:09
     * @Description 647.回文子串
     * 中心拓展法进行拓展，然后temp是用来记录每一次拓展是否是回文的。
     */
    public static int countSubstrings(String s){
        if(s == null || s.length() < 2){
            return 0;
        }
        int len = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        for(int i = 0; i < len; i++){
            res += isCountSubstring(chars, i, i) + isCountSubstring(chars, i, i+1);
        }
        return res;
    }

    private static int getLongest(char[] chars, int left, int right) {
        int len = chars.length;
        while(left >= 0 && right < len){
            if(chars[left] == chars[right]){
               left--;
               right++;
            }else{
                break;
            }
        }
        return right - left - 1;
    }

    private static int isCountSubstring(char[] chars, int left, int right){
        int len = chars.length;
        int temp = 0;
        if(right == len || left < 0)
            return 0;
        while(left >= 0 && right < len){
            if(chars[left] != chars[right]){
                break;
            }
            left--;
            right++;
            temp++;
        }
        return temp;
    }

    /**
     * @Author Yang
     * @Date 2021/3/15 16:22
     * @Description 516.最长回文子序列
     * dp的思想
     */
    public static int longestPalindromeSubseq(String s){
        if(s == null)
            return 0;
        int len = s.length();
        char[] chars = s.toCharArray();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        for(int i = len - 1; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(chars[i] == chars[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][len-1];
    }

    /**
     * @Author Yang
     * @Date 2021/3/16 10:29
     * @Description 59.螺旋矩阵II
     */
    public static int[][] generateMatrix(int n){
        if(n == 1)
            return new int[][]{{1}};
//        List<Integer> res = new ArrayList<>();
        int[][] res = new int[n][n];
        int row_start = 0, col_start = 0, row_end = n - 1, col_end = n - 1;
        int index = 1;
        while(row_start <= row_end){
            for(int j = col_start; j <= col_end; j++){
                res[row_start][j] = index++;
            }
            row_start++;
            if(row_start > row_end){
                break;
            }
            for(int i = row_start; i <= row_end; i++){
                res[i][col_end] = index++;
            }
            col_end--;
            if(col_end < col_start){
                break;
            }
            for(int j = col_end; j >= col_start; j--){
                res[row_end][j] = index++;
            }
            row_end--;
            if(row_end < row_start){
                break;
            }
            for(int i = row_end; i >= row_start; i--){
                res[i][col_start] = index++;
            }
            col_start++;
            if(col_start > col_end)
                break;
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/16 10:31
     * @Description 9.回文数
     */
    public static boolean isPalindrome(int x){
        if(x < 0)
            return false;
        String res = String.valueOf(x);
        char[] chars = res.toCharArray();
        int len = chars.length;
        int left = 0, right = len - 1;
        while(left < right){
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * @Author Yang
     * @Date 2021/3/16 10:53
     * @Description 11.盛水最多的容器
     * 移动指针后，底部的宽变小，要使容器的面积增大，只能选择容器的高较大的方向移动。
     */
    public static int maxArea(int[] height){
        int left = 0, right = height.length - 1;
        int max = 0;
        while(left < right){
            int temp = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, temp);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    /**
     * @Author Yang
     * @Date 2021/3/16 11:09
     * @Description 14.最长的公共前缀
     * 确定一个字符串，然后每次进行比较，对结果进行截取。
     */
    public String longestCommonPrefix(String[] strs){
        int len = strs.length;
        if(len == 0){
            return "";
        }
        if(len == 1) {
            return strs[0];
        }
        String res = strs[0];
        for(int i = 1; i < len; i++){
            int j = 0;
            for(; j < res.length() && j < strs[i].length(); j++){
                if(res.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            res = res.substring(0, j);
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/16 11:41
     * @Description 15.三数之和
     */
    public List<List<Integer>> threeSum_test(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len < 3)
            return res;
        for(int i = 0; i < len; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                if(nums[i] + nums[right] + nums[left] == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
                else if(nums[i] + nums[left] + nums[right] < 0){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/16 12:05
     * @Description 16.最接近的三数之和。
     *
     */
    public static int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int len = nums.length;
        int final_diff = Integer.MAX_VALUE;
        int res = 0;
        if(len == 3){
            return nums[0] + nums[1] + nums[2];
        }
        for(int i = 0; i < len; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int temp = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(temp - target);
                if(diff < final_diff){
                    res = temp;
                    final_diff = diff;
                }
                if(temp > target){
                    right--;
                }
                else if(temp < target){
                    left++;
                }else{
                    return temp;   // 对于相等的情况 直接进行返回， 否则会超时一直循环
                }
            }
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/17 10:20
     * @Description 20.有效括号
     */
    public static boolean isValid(String s){
        if(s==null || s.length() < 2){
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(' || chars[i] == '[' || chars[i] == '{'){
                stack.push(chars[i]);
            }else if(chars[i] == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(chars[i] == '}'){
                if(!stack.isEmpty() && stack.peek() == '{'){
                    stack.pop();
                }else{
                    return false;
                }
            }else {
                if(!stack.isEmpty() && stack.peek() == '['){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode current = new ListNode(-1);
        ListNode res = current.next;
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            }else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){
            current.next = l1;
        }
        if(l2 != null){
            current.next = l2;
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/17 10:59
     * @Description 23.合并k个链表
     */
    public ListNode mergeKLists(ListNode[] lists){
        if(lists == null || lists.length == 0)
            return null;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0; i < lists.length; i++){
            ListNode list = lists[i];
            while(list != null){
                pq.add(list);
                list = list.next;
            }
        }
        while(!pq.isEmpty()){
            current.next = pq.poll();
            current = current.next;
        }
        current.next = null;   // Error - Found cycle in the ListNode
        return dummy.next;
    }

    /**
     * @Author Yang
     * @Date 2021/3/17 11:55
     * @Description 26.删除有序数组的重复项
     * right对应的元素和left相同时，不断向右移动， 当不同时进行复制。
     * 整个题的思路是将不同的元素移动到数组的前端。
     */
    public int removeDuplicates(int[] nums){
        if(nums.length < 2){
            return nums.length;
        }
        int len = nums.length;
        int left = 0;
        int right = left + 1;
        while(right < len){
            if (nums[right] != nums[right - 1]) {
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left+1;
    }

    /**
     * @Author Yang
     * @Date 2021/3/17 12:07
     * @Description 33.搜索排序数组
     */
    public static int search(int[] nums, int target){
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && target < nums[mid]){ // [left , target , mid)
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(nums[mid] <= target && target <= nums[right]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * @Author Yang
     * @Date 2021/3/17 21:13
     * @Description 79.最小覆盖子串
     * 滑动窗口
     */
    public static String minWindow(String s, String t){
        int s_len = s.length();
        int t_len = t.length();
        if(s_len == 0 || t_len == 0 || s_len < t_len){
            return "";
        }
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for(char c : t_char){  // 记录t中所有的元素
            tFreq[c]++;
        }
        int distance = 0;  //滑动窗口中包含多少T中的字符，超过就不重复计算。
        int minLen = s_len+1;
        int begin = 0;
        int left = 0;
        int right = 0;
        while(right < s_len){
            if(tFreq[s_char[right]] == 0){  // t中不包含的元素就直接right++
                right++;
                continue;
            }
            if(winFreq[s_char[right]] < tFreq[s_char[right]]){   // t中含有的元素且滑动窗口中没有或者数量不够的情况
                distance++;
            }
            winFreq[s_char[right]]++;
            right++;

            // 左边界向右移动
            while(distance == t_len){  // 滑动窗口中包含了t中所有的元素
                if(right - left < minLen){  // 比最短的距离小就记录长度和起始的位置
                    minLen = right - left;
                    begin = left;
                }

                if(tFreq[s_char[left]] == 0){  //t中没有的元素就直接跳过 left++
                    left++;
                    continue;
                }
                if(winFreq[s_char[left]] == tFreq[s_char[left]]){  // 移除当前left对应的元素就不满足条件了 所以distance--
                    distance--;
                }
                winFreq[s_char[left]]--;
                left++;
            }
        }
        if(minLen == s_len+1){
            return "";
        }
        return s.substring(begin, begin + minLen);
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 9:40
     * @Description 92.翻转链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right){
        Stack<ListNode> stack = new Stack<>();
        if(head == null){
            return head;
        }
        int count = 1;
        ListNode curr = head;
        ListNode first = head;
        ListNode var_first = first;
        ListNode end = new ListNode(-1);
        ListNode dummy = new ListNode(-1);
        ListNode var = dummy;
        while(curr != null){
            if(count >= left && count <= right){
                first.next = null;
                stack.push(curr);
            }
            else if(count > right){
                end.next = curr;
                break;
            }
            curr = curr.next;
            first = first.next;
            count++;
        }
        while(!stack.isEmpty()){
            var.next = new ListNode(stack.pop().val);
            var = var.next;
        }
        var.next = end.next;
        first.next = dummy.next;
        return var_first.next;
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 18:05
     * @Description 206.翻转链表
     */
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode pro = null;
        ListNode cur = head;
        while(cur != null){
            pro = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pro;
        }
        return pre;
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 20:00
     * @Description 43.字符串相乘
     */
    public static String multiply(String num1, String num2){
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        if(len1 < 0 || len2 < 0){
            return "";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int carry = 0; // 进位
        int[] res = new int[len1 + len2 + 2];
        Arrays.fill(res, 0);
        for(int i = len1; i >= 0; i--){
            for(int j = len2; j >= 0; j--){
                int num1_bit = chars1[i] - '0', num2_bit = chars2[j] - '0';
                int temp = num1_bit * num2_bit + carry;
                res[i+j+1] += temp % 10;
                carry = temp / 10;
                if(res[i+j+1] >= 10){  //上下进位
                    res[i+j+1] = res[i+j+1] % 10;
                    carry += 1;
                }
                if(j == 0 && carry != 0){  //最高位进位
                    res[i+j] = carry;
                    carry = 0;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(; start < res.length; start++){
            if(res[start] == 0){
                continue;
            }
            break;
        }
        if(start == res.length)  // 和0相乘的情况
            return "0";
        for(; start < res.length; start++){
            sb.append(res[start]);
        }
        return sb.toString();
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 20:42
     * @Description 415.字符串相加
     */
    public static String addStrings(String num1, String num2){
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1 < 0 || len2 < 0){
            return "";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int carry = 0;
        int len = len1 > len2 ? len1 : len2;
        int[] res = new int[len + 1];
        int i = len1 - 1,  j = len2 - 1;
        while(i >= 0 && j >= 0){
            int nums1_bit = chars1[i] - '0', nums_bit2 = chars2[j] - '0';
            int temp = nums1_bit + nums_bit2 + carry;
            res[len] = temp % 10;
            carry = temp / 10;
            len--;
            i--;
            j--;
        }
        while(i >= 0){
            int temp = chars1[i] - '0' + carry;
            res[len] = temp % 10;
            carry = temp / 10;
            len--;
            i--;
        }
        while(j >= 0){
            int temp = chars2[j] - '0' + carry;
            res[len] = temp % 10;
            carry = temp / 10;
            len--;
            j--;
        }
        if(carry != 0){
            res[len] = carry;
        }
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(; start < res.length; start++){
            if(res[start] == 0){
                continue;
            }
            break;
        }
        if(start == res.length){
            return "0";
        }
        for(; start < res.length; start++){
            sb.append(res[start]);
        }
        return sb.toString();
    }

    public static String addStrings_2(String num1, String num2){
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        if(len1 < 0 || len2 < 0)
            return "";
        int i = len1, j = len2;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >=0 || carry != 0){
            if(i >= 0){
                carry += chars1[i--] - '0';

            }
            if(j >= 0){
                carry += chars2[j--] - '0';
            }
            sb.append(carry % 10);
            carry = carry / 10;
        }
        return sb.reverse().toString();
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 21:39
     * @Description 67.二进制求和
     */
    public String addBinary(String a, String b){
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        if(len1 < 0 || len2 < 0){
            return "";
        }
        int i = len1, j = len2, carry = 0;
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0){
            if(i >= 0){
                carry += chars1[i--] - '0';
            }
            if(j >= 0){
                carry += chars2[j--] - '0';
            }
            sb.append(carry % 2);
            carry = carry / 2;
        }
        return sb.reverse().toString();
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 22:10
     * @Description 46.全排列
     */
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        boolean[] used = new boolean[nums.length];
        tracking(nums, nums.length, 0, used, path, res);
        return res;
    }

    public static void tracking(int[] nums, int len, int depth, boolean[] used, List<Integer>path, List<List<Integer>> res){
        if(len == depth){
            res.add(new ArrayList<>(path)); // new ArrayList<>(path) 必须 不然是[][][][][]
            return;
        }
        for(int i = 0; i < len; i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                tracking(nums, len, depth+1, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 23:05
     * @Description 47.全排列II
     *
     */
    public static List<List<Integer>> permuteUnique(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            return res;
        }
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[len];
        tracking_unique(nums, len, 0, used, path, res);
        return res;
    }

    public static void tracking_unique(int[] nums, int len, int depth, boolean[] used, List<Integer> path, List<List<Integer>> res){
        if(len == depth){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            tracking_unique(nums, len, depth+1, used, path, res);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    /**
     * @Author Yang
     * @Date 2021/3/18 23:32
     * @Description 53.最大子序和
     */
    public static int maxSubArray(int[] nums){
        int res = nums[0];
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(sum > 0)
            {
                sum += nums[i];
            }
            else
            {
                sum = nums[i];
            }
            res = Math.max(sum,res);
        }
        return res;
    }

    /**
     * @Author Yang
     * @Date 2021/3/19 10:03
     * @Description 61.旋转链表
     * 给定一个链表，将链表的每个节点向右移动k个位置
     */
    public ListNode rotateRight(ListNode head, int k){
        ListNode slow = head;
        ListNode fast = head;
        ListNode current = head;
        int len = 0;
        if(head == null){  // head为null的情况
            return head;
        }
        while(current != null){
            current = current.next;
            len++;
        }
        len = k % len;
        if(len == 0){  // len = 0的情况
            return head;
        }
        while (fast.next != null){  //快慢指针的思想
            fast = fast.next;
            len--;
            if(len < 0){
                slow = slow.next;
            }
        }
        ListNode end = slow.next;  //后半截链表
        slow.next = null;   // 前半截链表
        fast.next = head;   // 拼接
        return end;
    }

    /**
     * @Author Yang
     * @Date 2021/3/19 10:19
     * @Description 62.不同路径
     */
    public static int uniquePaths(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1;i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * @Author Yang
     * @Date 2021/3/19 10:25
     * @Description 70.爬楼梯
     */
    public static int climbStairs(int n){
        int[] dp = new int[n+1];
        if(n == 0)
            return 0;
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * @Author Yang
     * @Date 2021/3/19 10:32
     * @Description 78.子集
     */
    public List<List<Integer>> subsets(int[] nums){
        if(nums == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path =  new ArrayList<>();
        tracking_subsets(nums, 0, path, result);
        return result;
    }

    public void tracking_subsets(int[] nums, int start, List<Integer> path, List<List<Integer>> result){
        result.add(new ArrayList<>(path));
        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            tracking_subsets(nums, i+1, path, result);
            path.remove(path.size() - 1);
        }
    }

    public static int test(int n, int[] a, int[] b){
        Deque<Integer> dq = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && a[dq.getLast()] > a[i]){
                if(dq.size() >= 3){
                    list.add(new ArrayList<>(dq));
                }
                dq.removeLast();
            }
            dq.addLast(i);
        }
        int len = list.size();
        for(int i = 0; i < len; i++){
            List<Integer> temp = list.get(i);
            List<Integer> second = new ArrayList<>();
            for(int j = 0; j < temp.size(); j++){
                second.add(b[temp.get(j)]);
            }
            int[] ints = second.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(ints);
            int min_temp = ints[0] + ints[1] + ints[2];
            min = Math.min(min, min_temp);
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * @Author Yang
     * @Date 2021/3/20 9:51
     * @Description 150.逆波兰表达式求值
     */
    public static int evalRPN_1(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        int len = tokens.length;
        int num = 0;
        for(int i = 0; i < len; i++){
            char[] chars = tokens[i].toCharArray();
            if(chars.length > 1){
                if(chars[0] >= '1'){  // 正数的情况
                    int index = 0;
                    while(index < chars.length){
                        num = num * 10 - '0' + chars[index];
                        index++;
                    }
                    stack.push(num);
                }
                else{  //负数情况
                    int index = 1;
                    while(index < chars.length){
                        num = num * 10 - '0' + chars[index];
                        index++;
                    }
                    stack.push(-num);
                }
                num = 0;
            }else{
                if(chars[0] >= '0'){
                    stack.push(chars[0] - '0');
                }else if(chars[0] == '+'){
                    stack.push(stack.pop() + stack.pop());
                }else if(chars[0] == '-'){
                    int temp = stack.pop();
                    stack.push(stack.pop() - temp);
                }else if(chars[0] == '*'){
                    stack.push(stack.pop() * stack.pop());
                }else{
                    int temp = stack.pop();
                    stack.push(stack.pop() / temp);
                }
            }
        }
        return stack.pop();
    }


    /**
     * @Author Yang
     * @Date 2021/3/20 10:15
     * @Description 88.合并有序数组
     */
    public void merge(int[] nums1, int m, int[] nums2, int n){
        int len1 = m - 1, len2 = n - 1, len = m + n - 1;
        while(len1 >= 0 && len2 >= 0){
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        while(len2 >= 0 ){
            nums1[len--] = nums2[len2--];
        }
    }


    /**
     * @Author Yang
     * @Date 2021/3/23 9:43
     * @Description 104。二叉树的最大深度
     */
    int maxDepth = 0;
    public int maxDepth(TreeNode root){
        if(root == null)
            return 0;
        dfs(root, 1);
        return maxDepth;

    }
    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        if(depth > maxDepth){
            maxDepth = depth;
        }
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);
    }

    /**
     * @Author Yang
     * @Date 2021/3/23 10:25
     * @Description 111.二叉树的最小深度
     */
    int minDepth = Integer.MIN_VALUE;
    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0){
            return right + 1;
        }
        if(right == 0){
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }

    /**
     * @Author Yang
     * @Date 2021/3/23 10:35
     * @Description 121.买卖股票的最佳时机
     * 只能交易一次。
     */
    public int maxProfit(int[] prices){
        if(prices == null){
            return 0;
        }
        int minInput = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            minInput = Math.min(minInput, prices[i]);
            max = Math.max(max, prices[i] - minInput);
        }
        return max;

    }

    public int maxProfitI_DP(int[] prices){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            // 今天不持股的情况 ---  昨天不持股保持  昨天持股今天卖出
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            // 今天持股的情况 ----- 昨天持股保持 今天购买股票
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len-1][0];
    }

    /**
     * @Author Yang
     * @Date 2021/3/23 11:07
     * @Description 122.买卖股票的最佳时期II
     * 可以进行多次买入卖出 多次交易
     */
    public int maxProfitII(int[] prices){
        if(prices == null){
            return 0;
        }
        int max = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] - prices[i-1] > 0){
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }

    public int maxProfitII_DP(int[] prices){
        if(prices == null){
            return 0;
        }
        int len = prices.length;
        if(len < 2){
            return 0;
        }
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            // 0 持有现金  1 持有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);  // 这里是因为可以进行多次交易
        }
        return dp[len-1][0];
    }

    /**
     * @Author Yang
     * @Date 2021/3/23 12:20
     * @Description 123.买卖股票的最佳时机III
     * 最多可以完成两笔交易。
     */




    /**
     * @Author Yang
     * @Date 2021/3/24 9:58
     * @Description 456.132模式
     * i < j < k 满足 ai < ak < aj
     */
    public static boolean find132pattern(int[] nums){
        int len = nums.length;
        if(len < 3){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int two = Integer.MIN_VALUE;
        for(int i = len-1; i >= 0; i--){
            if(nums[i] >= two){
                while(!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                    two = nums[stack.peek()];
                    stack.pop();
                }
                stack.push(i);
            }
            else {
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
//        LRUCache lruCache = new LRUCache(1);
//        lruCache.put(1,1);
//        lruCache.put(2,3);
    }
}

class MyHashSet{
    private List<Integer> list;
    public MyHashSet() {
        list = new LinkedList<>();
    }

    public void add(int key) {
        if(list.isEmpty() || !list.contains(key)){
            list.add(key);
        }
    }

    public void remove(int key) {
        if(list.contains(key)){
            list.remove(list.indexOf(key));
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return list.contains(key);
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(){}
    TreeNode(int val){
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;
    public LRUCache(int capacity){
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    public int get(int key){
        return super.getOrDefault(key, -1);
    }
    public void put(int key, int value){
        super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}


class LRUCache_1{
    private HashMap<Integer, Integer> map;
    private int capacity;
    public LRUCache_1(int capacity){
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        makeOrder(key);
        return map.get(key);
    }

    public void put(int key, int val){
        if(map.containsKey(key)){
            map.put(key, val);
            makeOrder(key);
            return;
        }
        if(map.size() >= capacity){
            Integer next = map.keySet().iterator().next();
            map.remove(next);
        }
        map.put(key, val);
    }

    private void makeOrder(int key) {
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}

package leetcode;


import org.w3c.dom.html.HTMLIsIndexElement;
import sun.security.krb5.internal.tools.Klist;

import java.util.*;

public class solution {
    public static void main(String[] args) {

        /*String S = "";
        System.out.println(partitionLabels(S));*/

        /*String name = "pyplrz";
        String typed = "ppyypllr";
        System.out.println(isLongPressedName(name, typed));*/

        /*int[] A = new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,263,264,265,266,267,268,269,270,271,272,273,274,275,276,277,278,279,280,281,282,283,284,285,286,287,288,289,290,291,292,293,294,295,296,297,298,299,300,301,302,303,304,305,306,307,308,309,310,311,312,313,314,315,316,317,318,319,320,321,322,323,324,325,326,327,328,329,330,331,332,333,334,335,336,337,338,339,340,341,342,343,344,345,346,347,348,349,350,351,352,353,354,355,356,357,358,359,360,361,362,363,364,365,366,367,368,369,370,371,372,373,374,375,376,377,378,379,380,381,382,383,384,385,386,387,388,389,390,391,392,393,394,395,396,397,398,399,400,401,402,403,404,405,406,407,408,409,410,411,412,413,414,415,416,417,418,419,420,421,422,423,424,425,426,427,428,429,430,431,432,433,434,435,436,437,438,439,440,441,442,443,444,445,446,447,448,449,450,451,452,453,454,455,456,457,458,459,460,461,462,463,464,465,466,467,468,469,470,471,472,473,474,475,476,477,478,479,480,481,482,483,484,485,486,487,488,489,490,491,492,493,494,495,496,497,498,499,500,498,497,496,495,494,493,492,491,490,489,488,487,486,485,484,483,482,481,480,479,478,477,476,475,474,473,472,471,470,469,468,467,466,465,464,463,462,461,460,459,458,457,456,455,454,453,452,451,450,449,448,447,446,445,444,443,442,441,440,439,438,437,436,435,434,433,432,431,430,429,428,427,426,425,424,423,422,421,420,419,418,417,416,415,414,413,412,411,410,409,408,407,406,405,404,403,402,401,400,399,398,397,396,395,394,393,392,391,390,389,388,387,386,385,384,383,382,381,380,379,378,377,376,375,374,373,372,371,370,369,368,367,366,365,364,363,362,361,360,359,358,357,356,355,354,353,352,351,350,349,348,347,346,345,344,343,342,341,340,339,338,337,336,335,334,333,332,331,330,329,328,327,326,325,324,323,322,321,320,319,318,317,316,315,314,313,312,311,310,309,308,307,306,305,304,303,302,301,300,299,298,297,296,295,294,293,292,291,290,289,288,287,286,285,284,283,282,281,280,279,278,277,276,275,274,273,272,271,270,269,268,267,266,265,264,263,262,261,260,259,258,257,256,255,254,253,252,251,250,249,248,247,246,245,244,243,242,241,240,239,238,237,236,235,234,233,232,231,230,229,228,227,226,225,224,223,222,221,220,219,218,217,216,215,214,213,212,211,210,209,208,207,206,205,204,203,202,201,200,199,198,197,196,195,194,193,192,191,190,189,188,187,186,185,184,183,182,181,180,179,178,177,176,175,174,173,172,171,170,169,168,167,166,165,164,163,162,161,160,159,158,157,156,155,154,153,152,151,150,149,148,147,146,145,144,143,142,141,140,139,138,137,136,135,134,133,132,131,130,129,128,127,126,125,124,123,122,121,120,119,118,117,116,115,114,113,112,111,110,109,108,107,106,105,104,103,102,101,100,99,98,97,96,95,94,93,92,91,90,89,88,87,86,85,84,83,82,81,80,79,78,77,76,75,74,73,72,71,70,69,68,67,66,65,64,63,62,61,60,59,58,57,56,55,54,53,52,51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        System.out.println(A.length);
        System.out.println(longestMountain(A));*/

        int[] nums1 = new int[]{2,3,1,3,2,4,6,7,9,2,1};
        int[] nums2 = new int[]{2,1,4,3,9,6};
       /* int [] res= smallerNumbersThanCurrent(nums);

        System.out.println(2.3-3.0e-3);*/

       /*System.out.println(majorityElement(nums));*/
       /* merge(nums1,3, nums2,3);*//*
        for(int i = 0; i < nums1.length; i++){
            System.out.println(nums1[i]);
        }*/
        //System.out.println(maxProfit(nums1));

       /* String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));*/

      /* int [][] grid = new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(islandPerimeter(grid));*/

        /*char[] chars = new char[]{'h','e','l','l','o'};
        reverseString(chars);
        System.out.println(chars);*/

        /*String s = "aadadaad";
        System.out.println(firstUniqChar(s));*/

       /* String[] words = new String[]{"oath","pea","eat","rain"};
        char[][] board = new char[][]{{'o','a','a','n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        System.out.println(findWords(board, words));*/

        //System.out.println(findKthLargest(nums1, 4));
        int[] nums = new int[]{10};
        int [][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        String num = "10200";
        System.out.println(largestNumber(nums));



    }
    public static List<Integer> partitionLabels(String S){
        int[] last_idx = new int[26];
        int len = S.length();
        char[] s_char = S.toCharArray();
        for(int i = 0; i < len; i++){
            last_idx[s_char[i] - 'a'] = i;  //记录该字母最后一次出现的位置。
        }
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i = 0; i < len; i++){
            end = Math.max(end, last_idx[s_char[i] - 'a']);
            if(i == end){  // 元素只出现一次的情况
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    /*
     * 925. 长按输入**/
    public static boolean isLongPressedName(String name, String typed){
        if(name == null || typed == null)
            return false;
        char[] chars_name = name.toCharArray();
        char[] chars_typed = typed.toCharArray();
        int j = 1;
        int i = 1;
        if(chars_name[0] != chars_typed[0])
            return false;
        for(; i < chars_name.length; i++){
          if(j < chars_typed.length && chars_name[i] == chars_typed[j]){
              j++;
              continue;
          }
          else{ //chars_name[i] != chars_typed[j]
              while(j < chars_typed.length && chars_typed[j-1] == chars_typed[j]){
                  j++;
              }
              if(j >= chars_typed.length ||chars_name[i] !=  chars_typed[j])
                  return false;
              j++;
          }
        }
        j = j -1;
        while(j < chars_typed.length -1){
            if(chars_typed[j] != chars_typed[j+1])
                return false;
            j++;
        }
        return true;
    }


    public boolean isPalindrome(ListNode head){
        if(head == null)
            return true;
        if(head.next == null)
            return true;
        if(head.next.next == null)
            return head.val == head.next.val;
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null){
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;
        }
        while(head != null && prev != null){
            if(head.val != prev.val){
                return false;
            }
            head = head.next;
            prev = prev.next;
        }
        return true;

    }

    /**
     * 845 数组中最长的山脉
     * 先找到峰顶，然后分别向两边扩展
     * @param A
     * @return
     */
    public static int longestMountain(int[] A){
        if(A == null || A.length < 2){
            return 0;
        }
        int result = 0;
        for(int i = 1; i < A.length-1; i++){
            if(A[i-1] < A[i] && A[i] > A[i+1]){
                int left = i - 1;
                int right = i + 1;
                while(left > 0 && A[left] > A[left - 1]){
                    left--;
                }
                while(right < A.length - 1 && A[right] > A[right + 1]){
                    right++;
                }
                result = result >= (right - left + 1) ? result : (right - left + 1);
            }
        }
        return result;
    }

    /**
     * 1365 有多少小于当前数字的数字
     * 计数排序
     * @param nums
     * @return
     */
    public static int[] smallerNumbersThanCurrent(int[] nums){
        int[] res = new int[101];
        for(int i = 0; i < nums.length; i++){
            res[nums[i]]++;
        }
        for(int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        for(int i = 0; i < nums.length; i++){
            int temp = nums[i];
            nums[i] = temp == 0 ? 0 : res[temp-1];
        }
        return nums;
    }

    /**
     * 144 二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){
        if(root == null)
            return null;
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }
    public void preOrder(TreeNode root, List<Integer> result){
        if(root == null)
            return;
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    /**
     * 数组中出现次数大于一半的多数元素
     * 摩尔投票法
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int result = 0 ;
        int major = 0;
        for(int i = 0; i < nums.length; i++){
            if(major == 0){
                result = nums[i];
                major++;
                continue;
            }
            if(result == nums[i]){
                major++;
            }
            if(result != nums[i]){
                major--;
            }
        }
        return result;
    }

    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while(i < row && j >= 0){
            if(matrix[i][j] > target){
                j--;
                continue;
            }
            if(matrix[i][j] < target){
                i++;
                continue;
            }
            if(matrix[i][j] == target)
                return true;
        }
        return false;
    }

    /**
     * 合并两个有序数组，使用了额外的空间，且新增了一次遍历。
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(n == 0)
            return;
        int[] res = new int[m+n];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < m && j < n){
            if(nums1[i] < nums2[j]) {
                res[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            if(nums1[i] >= nums2[j]){
                res[k] = nums2[j];
                j++;
                k++;
                continue;
            }
        }
        while(i < m){
            res[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            res[k] = nums2[j];
            j++;
            k++;
        }
        for(int l = 0; l < nums1.length; l++){
            nums1[l] = res[l];
        }
        return;

    }

    /**
     * 1027 独一无二的出现次数，是否每个数的出现此时都是独一无二的。
     * @param arr
     * @return
     */
    public static boolean uniqueOccurrences(int[] arr){
        int length = arr.length;
        if(length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < length; i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
                continue;
            }
            int val = map.get(arr[i]);
            map.put(arr[i], val+1);
        }
        int len = map.size();
        Set<Integer> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }

    /**
     * 买卖股票的最佳时机
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int length = prices.length;
        for(int i = 0; i < length - 1; i++){
            if(prices[i] <= prices[i+1]){
                maxProfit += prices[i+1] - prices[i];
                continue;
            }
        }
        return maxProfit;
    }


    /**
     * 129 求根到叶子节点数字之和
     * @param root
     * @return
     */
    static int sum = 0;
    public static int sumNumbers(TreeNode root){
        if(root == null)
            return 0;
        preOrder(root, 0);
        return sum;
    }
    public static void preOrder(TreeNode root, int sub_sum){
        sub_sum = sub_sum * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += sub_sum;
            return;
        }
        preOrder(root.left, sub_sum);
        preOrder(root.right, sub_sum);
    }

    /**
     * 验证回文串，只是比较小写字母和数字，其他的忽略，
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s){
        if(s.length() == 0 || s == null || s.length() == 1){
            return true;
        }
        s = s.trim();
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(!((chars[left] >= 'a' && chars[left] <= 'z') || (chars[left] >= '0' && chars[left] <= '9'))){
                left++;
                continue;
            }
            if(!((chars[right] >= 'a' && chars[right] <= 'z') || (chars[right] >= '0' && chars[right] <= '9'))){
                right--;
                continue;
            }
            if(chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 岛屿的周长 求岛屿的周长
     * @param grid
     * @return
     */
    public static int islandPerimeter(int[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    result += 4;
                    if(i > 0 && grid[i-1][j] == 1){
                        result -= 2;
                    }
                    if(j > 0 && grid[i][j-1] == 1){
                        result -= 2;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 翻转字符串
     * @param s
     */
    public static void reverseString(char[] s){
        if(s == null || s.length == 0)
            return;
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return;
    }

    /**
     * 字符串中的第一个唯一的字符
     * @param s
     * @return
     */
    public static int firstUniqChar(String s){
        if(s == null || s.length() == 0)
            return -1;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int right = 1;
        while(right < chars.length){
            if(set.contains(chars[left])){  //针对情况"aadadaad"
                left++;
                right = left + 1;
                continue;
            }else{
                if(chars[left] == chars[right]){
                    set.add(chars[left]);
                    left++;
                    right = left + 1;
                    continue;
                }else{
                    right++;
                    continue;
                }
            }

        }
        if(set.contains(chars[left]))  // 针对情况"cc"
            return -1;
        return left;
    }

    /**
     * 单词搜索， 找出同时在二维网格和字典中的单词
     * @param board
     * @param words
     * @return
     */
    public static List<String> findWords(char[][] board, String[] words){
        if(words == null || words.length == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            String word = words[i];
            char[] chars = word.toCharArray();
            int index = 0;
            boolean flag = false;
            for(int row = 0; row < board.length; row++){
                for(int col = 0; col < board[0].length; col++){
                    if(chars[index] != board[row][col]){
                        continue;
                    }
                    else {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        flag = BFS(board, chars, row, col, index, visited);
                        if(flag == true){
                            result.add(word);
                            break;
                        }
                    }
                }
                if(flag == true)
                    break;
            }
        }
        result.sort(Comparator.naturalOrder());  //将result按单词顺序来进行排序。
        return result;
    }
    public static boolean BFS(char[][]board, char[] chars, int i , int j, int k, boolean[][] visited){

        if(i < 0 || i == board.length || j < 0 || j == board[0].length || k == chars.length || board[i][j] != chars[k] || visited[i][j]){
           return false;
        }
        visited[i][j] = true;  // 通过visited来限定不重复
        if(k == chars.length - 1)  // 完成单词长度之后匹配成功
           return true;
        boolean flag =  BFS(board, chars, i+1, j, k+1, visited) || BFS(board, chars, i-1, j, k+1, visited) || BFS(board, chars, i, j-1, k+1, visited)
               || BFS(board, chars, i, j+1, k+1, visited);
        visited[i][j] = false;  // 将记录清空  如果是可重复的直接上面即可
        return flag;
    }

    /**
     * 单词拆分  动态规划
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict){
        boolean[] result = new boolean[s.length()+1];
        result[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(result[j] && wordDict.contains(s.substring(j,i))){
                    result[i] = true;
                    break;
                }
            }
        }
        return result[s.length()];
    }

    /**
     * 349 两个数组的交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2){
        HashSet<Integer> set = new HashSet<>();
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[]{};
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                if(!result.contains(nums2[i])){
                    result.add(nums2[i]);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 乘积最大子数组，数组中乘积最大的连续子数组
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums){
        int max = Integer.MIN_VALUE;
        int max_positive = 1;
        int max_negative = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                int temp = max_positive;
                max_positive = max_negative;
                max_negative = temp;
            }
            max_positive = Math.max(max_positive * nums[i], nums[i]);
            max_negative = Math.min(max_negative * nums[i], nums[i]);
            max = Math.max(max_positive, max);
        }
        return max;
    }

    /**
     * 旋转数组，给定一个数组，将数组的元素向右移动k个单位
     * 需要掌握一个宏观的思想，不要纠结于具体的每一个步骤。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        int j = 0;
        int[] nums_1 = new int[len-k];
        int[] nums_2 = new int[k];
        for(int i = 0; i < (len - k); i++){
            nums_1[i] = nums[i];
        }
        for(int i = (len-k); i < len; i++){
            nums_2[j] = nums[i];
            j++;
        }
        for(j = 0; j < nums_2.length; j++){
            nums[j] = nums_2[j];
        }
        for(int i = 0; i < nums_1.length; i++){
            nums[j] = nums_1[i];
            j++;
        }
        return;
    }

    public static void rotate_reverse(int[] nums, int k){
        int len = nums.length;
        k = k % len;
        reverse(nums,  0, len-1);  // 整体翻转
        reverse(nums,  0, k-1);  // 前段局部翻转
        reverse(nums,  k, len-1);   //后段局部翻转

    }
    public static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static boolean validMountainArray(int[] A){
        int len = A.length;
        if(A == null || len <= 2)
            return false;
        for(int i = 1; i < len - 1; i++){
            if(A[i-1] < A[i] && A[i] > A[i+1]){
                int left = i - 1;
                int right = i + 1;
                while(left > 0 && A[left] > A[left - 1]){
                    left--;
                }
                while(right < len - 1 && A[right] > A[right + 1]){
                    right++;
                }
                if(left == 0 && right == len - 1)
                    return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                continue;
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * 移动零，将所有的0移动到数组的末尾，所有的操作都是原地操作
     * @param nums
     */
    public static void moveZeroes(int[] nums){
        int len = nums.length;
        int left = 0;
        while (left < len ){
            if(nums[left] != 0){
                left++;
                continue;
            }else{
                int right = left + 1;
                while(right < len && nums[right] == 0){
                    right++;
                }
                if(right == len  && nums[right-1] == 0)
                    break;
                swap(left, right, nums);
                left++;
            }
        }
    }
    public static void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    /**
     * 两个数组的交集，重复的元素统计输出的次数。
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num : nums1){
            list1.add(num);
        }
        for(int num : nums2){
            if(list1.contains(num)){
                list2.add(num);
                list1.remove(list1.indexOf(num));

            }
        }
        return list2.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 递增的三元子序列： 是序列不是子数组，所以需要记录最小值和第二小的值不断迭代，只要能找出第三个大的值就成立。
     * 因为是顺序读取的。
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= first){
                first = nums[i];
            }else if(nums[i] <= second){
                second = nums[i];
            }else {
                return true;
            }
        }
        return false;
    }

    /**
     * 除自身以外数组的乘积，不要使用除法，且在O(n)时间完成。
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums){
        int len = nums.length;
        int[] prefix = new int[len];
        int[] suffix = new int[len];
        int[] res = new int[len];
        for(int i = 0; i < len; i++){
            if(i == 0){
                prefix[i] = 1;
            }else {
                prefix[i] = prefix[i-1] * nums[i-1];
            }
        }
        for(int i = len-1; i >= 0; i--){
            if(i == len -  1){
                suffix[i] = 1;
            }else{
                suffix[i] = suffix[i+1] * nums[i+1];
            }
        }
        for(int i = 0; i < len; i++){
            res[i] = prefix[i] * suffix[i];
        }
        return  res;
    }

    /**
     * 127 单词接龙。 根据wordList中的单词，每次将beginWord改变一位，看是否能变成endWord
     * @param beginWord 起始单词
     * @param endWord   终止单词
     * @param wordList  要查询的单词列表
     * @return          需要变换的次数
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        boolean[] marked = new boolean[wordList.size()+1];
        int layer = 1;
        while(!queue.isEmpty()){
            layer++;
            int size = queue.size();
            while(size > 0){
                String current = queue.poll();
                for(int i = 0; i < wordList.size(); i++){
                    if(marked[i]){
                        continue;
                    }
                    String dic = wordList.get(i);
                    if(canChange(dic, current)){
                        if(dic.equals(endWord))
                            return layer;
                        queue.add(dic);
                        marked[i] = true;
                    }
                }
                size--;
            }
        }
        return 0;
    }
    public boolean canChange(String s, String t){
        int len = s.length();
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }

    /**
     * 找出未排序数组中第k个最大的元素
     * 使用的是快排的分治思想
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        int target = len - k;
        while(true){
            int partition = partition(nums, left, right);
            if(partition == target)
                return nums[partition];
            else if(partition < target){
                left = partition + 1;
            }
            else
                right = partition - 1;
        }
    }
    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int local = left;
        for(int i = left + 1; i < nums.length; i++){
            // 分区， local之前的 <  pivot
            if(nums[i] < pivot){
                local++;
                swap(nums, local, i);
            }
        }
        // 交换 使分区成立
        swap(nums, local, left);
        return local;

    }
    public static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;

    }

    /**
     * 使用堆的方法来做
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_heap(int[] nums, int k){
        int len = nums.length;
        if(k <= len - k){
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b)-> a - b);
            for(int i = 0 ; i < k ; i++){
                minHeap.add(nums[i]);
            }
            for(int i = k; i < len; i++){
                if(nums[k] > minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[k]);
                }
            }
            return minHeap.poll();
        }
        else {
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (a, b) -> b -a);
            for(int i = 0 ; i < k; i++){
                maxHeap.add(nums[i]);
            }
            for(int i = k ; i < len; i++){
                if(nums[k] < maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.add(nums[k]);
                }
            }
            return maxHeap.poll();
        }
    }

    /**
     * 最近的k个点， 运用优先队列的思想，其实和上道题本质是一样的，只是判断入队的条件是不同的。
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest(int[][] points, int K){
        PriorityQueue<int[]> heap = new PriorityQueue<>(K, (a,b) -> a[0]*a[0] + a[1]*a[1] - b[0]* b[0] - b[1]*b[1]);
        for(int[] i : points){
            heap.add(i);
        }
        int [][] result = new int[K][2];
        for(int i = 0 ; i < K; i++){
            result[i][0] = heap.peek()[0];
            result[i][1] = heap.peek()[1];
            heap.poll();
        }
        return result;
    }

    /**
     * 下一个排列
     * @param nums
     */
    public void nextPermutation(int[] nums){
        boolean flag = false;
        int firstIndex = -1;
        int secondIndex = -1;
        if(nums == null || nums.length == 0)
            return;
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i+1] > nums[i]){
                flag = true;
                firstIndex = i;
                break;
            }
        }
        if(!flag){
            reverse(nums, 0, nums.length-1);
            return;
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > nums[firstIndex]){
                secondIndex = i;
                break;
            }
        }
        swap(firstIndex, secondIndex, nums);
        reverse(nums, firstIndex+1, nums.length-1);

    }

    public int kthSmallest(int[][] matrix, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b)-> a-b);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length; j++){
                heap.add(matrix[i][j]);
            }
        }
        return heap.poll();
    }

    /**
     * 328 奇偶链表，将奇数位的节点和偶数位的节点分别排放在一起。
     * 注意理解 ： 链表中的head odd 等这些看做指针。
     * @param head
     * @return
     */
    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode odd = head;
        ListNode odd_head = odd;
        ListNode evne = head.next;
        ListNode evne_head = evne;
        while(odd.next != null && evne.next != null){
            odd.next = evne.next;
            odd = odd.next;
            evne.next = odd.next;
            evne = evne.next;
        }

        odd.next = evne_head;
        return odd_head;
    }

    /**
     * 前k个高频元素
     * 1.用hashMap记录数组中的元素和它对应的出现次数。
     * 2.创建一个小根堆，大小为k，超过k时将堆顶的元素的次数和新加的元素次数比较判断是否入堆。
     * 3.将堆中的元素存储到数组中返回。
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });  //小顶堆
        for(int key : map.keySet()){
            if(pq.size() < k){
                pq.add(key);
            }else{
                if(map.get(pq.peek()) < map.get(key)){
                    pq.poll();
                    pq.add(key);
                }
            }
        }
        int[] result = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            result[i] = pq.poll();
            i++;
        }
        return result;
    }

    /**
     * 计数排序
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2){
       int[] count = new int[1001];
       List<Integer> list = new ArrayList<>();
       for(int arr : arr1){
           count[arr]++;
       }
       for(int arr : arr2){
           int times = count[arr];
           for(int i = 0; i < times; i++){
               list.add(arr);
           }
       }
       for(int i = 0; i < count.length; i++){
           if(list.contains(i) || count[i] == 0){
               continue;
           }else{
               for(int j = 0; j < count[i]; j++){
                   list.add(i);
               }
           }
       }
       return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 滑动窗口取最大值。
     * 方法一：维护一个大顶堆，每次只需要打印大顶堆的点即可。
     * 但是会超时
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, (a, b) -> b - a);
        for(int i = 0; i < k; i++){
            heap.add(nums[i]);
        }
        int[] result = new int[nums.length-k+1];
        result[0] = heap.peek();
        int j = 1;
        for(int i = 1; i < nums.length - k + 1; i++){
            heap.remove(nums[i-1]);
            heap.add(nums[i+k]);
            result[j] = heap.peek();
            j++;
        }
        return result;
    }

    /**
     * 维护一个单调栈，栈中的元素是单调递减的。所以要求的最大值，就是栈顶的元素。
     * 为了方便判断滑动窗口是否将最大值滑出，存入栈的是下标而不是数组中的元素。
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow_monotonicStack(int[] nums, int k){
        int lo = 0;
        int hi = 0;
        int[] res = new int[nums.length-k+1];
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        while(hi < nums.length){
            if(hi - lo < k){
                insert(ad, nums, hi++);
            }else{
                res[lo] = nums[ad.getFirst()];
                if(ad.getFirst() == lo++){
                    ad.removeFirst();
                }
            }
        }
        res[lo] = nums[ad.getFirst()];
        return res;
    }

    /**
     * 单调性的保证。
     * @param ad
     * @param nums
     * @param i
     */
    public static void insert(ArrayDeque<Integer> ad, int[] nums, int i){
        while(!ad.isEmpty() && nums[ad.getLast()] < nums[i]){
            ad.removeLast();
        }
        ad.add(i);
    }

    /**
     * 402.移除掉K位数字。 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小
     * 1.维护一个单调递增的栈，并记录操作的次数。
     * 2.操作次数不够，需要将队尾的元素删除剩下次数次。
     * 3.对于前导0的处理。
     * 4.判断队列是否为空。
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k){
        if(k == 0){
            return num;
        }
        if(k == num.length()){
            return "0";
        }
        ArrayDeque<Character> ad = new ArrayDeque<>();
        String res = "";
        // 维护一个单调递增的栈，当数组元素比队尾元素小将队尾元素弹出，否则入队，记录操作的次数
        for(char digit : num.toCharArray()){
            while(!ad.isEmpty() && k > 0 && digit < ad.getLast()){
                ad.removeLast();
                k--;
            }
            ad.addLast(digit);
        }
        // 如果还没有删除K个值，直接将队尾元素删除剩下的次数即可
        for(int i = 0; i < k; i++){
          ad.removeLast();
        }
        // 去除前导0的情况
        while(ad.size() > 0 && ad.getFirst() == '0'){
            ad.removeFirst();
        }
        // 栈中的元素为空的情况直接放回，（这种情况是栈内的元素全为0，都被当成前导0删除了）
        if(ad.isEmpty()){
            return "0";
        }
        // 输出
        while(!ad.isEmpty()){
            res += ad.pollFirst();
        }
        return res;
    }

    public static int[][] reconstructQueue(int[][] people) {
        if(people.length == 0 || people[0].length == 0)
            return  new int[0][0];
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int length = people.length;
        int [][] res = new int[length][];
        List<int[]> list = new ArrayList<>();
        for(int[] i : people){
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }

    /**
     * 在R*C的矩阵中给出某点r0，c0，将矩阵中的所有点按照和该点的距离排序
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    public static int[][] allCellsDistOrder(int R, int C, int r0, int c0){
        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                list.add(new int[]{i,j});
            }
        }
        int[][] ints = list.toArray(new int[list.size()][]);
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return Math.abs(o1[0]-r0) + Math.abs(o1[1]- c0) - Math.abs(o2[0]-r0) - Math.abs(o2[1]-c0);
            }
        });
        return ints;
    }

    /**
     * 二叉搜索树的第k的小元素。
     * 二叉搜索树本来都是已经排好序的，只需要对其进行中序遍历就可以获得从小到大排列的元素。
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k){
        if(root == null)
            return 0;
        List<Integer> res = new ArrayList<>();
        midSearch(root, k, 0, res);
        return res.get(res.size()-1);
    }
    public void midSearch(TreeNode root, int k, int step, List<Integer>res){
        if(root == null || k == step)
            return;
        midSearch(root.left, k, step++, res);
        res.add(root.val);
        midSearch(root.right, k, step++, res);

    }

    /**
     * 134.加油站.
     * 判断油量和路程的关系，只有油量 >= 路程消耗的情况才能跑完全程。
     * 然后判断当前是否为负，就选下一个节点开始。 因为此时的条件是肯定能跑完全程的、
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost){
        int[] rest = new int[gas.length];
        int count = 0;
        for(int i = 0; i < gas.length; i++){
            rest[i] = gas[i] - cost[i];
            count += rest[i];
        }
        if(count < 0)
            return -1;
        int current = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){
            current += rest[i];
            if(current < 0){
                current = 0;
                start = i + 1;
            }
        }
        return start < gas.length ? start : -1;
    }

    /**
     * 最大数。 A,B如果有相同的开头，那么比较A+B和B+A的大小
     * @param nums
     * @return
     */
    public static String largestNumber(int[] nums){
        String[] nums_string = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            nums_string[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(nums_string, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String A = o1 + o2;
                String B = o2 + o1;
                return B.compareTo(A);
            }
        });
        String result = "";
        for(int i = 0; i < nums.length; i++){
            result += nums_string[i];
        }
       if(result.charAt(0) == '0'){
           return "0";
       }
        return result;
    }

    /**
     * 376. 摆动排序，相邻两数的差值正负交替，返回作为摆动排序的最长子序列。
     * @param nums
     * @return
     */


}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
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
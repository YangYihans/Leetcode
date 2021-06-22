package leetcode.primary_algo;

import java.sql.RowId;
import java.util.*;

public class solution {
    public static void main(String[] args) {
        String[] input = new String[]{"eat","tea","tan", "ate", "nat", "bat"};
        //groupAnagrams(input);
        ListNode head = new ListNode(5);
        ListNode current = head;
        for(int i = 4; i >= 0; i--){
            head.next = new ListNode(i);
            head = head.next;
        }
        int[] nums = new int[]{1,2,3,3,4,5};
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
       // topKFrequent(words, 2);
//       String s = "ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor";
//       String t = "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj";
//       findTheDifference(s, t);

       int[] a = new int[]{1,2,3,4,5,6,7};
       delete_first(a);
    }

    /**
     * 原地删除排序数组中的重复项
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums){
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int left = 0;
        int right = left + 1;
        while(right < nums.length){
            if(right < nums.length && nums[left] == nums[right]){
                right++;
            }else{
                left++;
                nums[left] = nums[right];
                right++;
            }

        }
        return left+1;
    }

    /**
     * 旋转数组， 从宏观上来思考这个旋转
     * 先整体翻转，然后以k为节点对前后两段依次进行翻转
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k){
        if(nums == null || nums.length <= 1){
            return;
        }
        k = k % nums.length;
        if(k == 0)
            return;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            right--;
            left++;
        }
    }

    /**
     * 判断数组中是否存在重复元素
     * 使用set集合类型来存放nums中的值，判断是否存在重复
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    /**
     * 三数之和，在未排序的数组中，找出三数之和为0的所有组合。
     * 先将数组进行排序。
     * 当检测的值>0 直接终止。
     * 左右双指针，对三种情况进行判断。
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        if(nums == null || nums.length < 3)
            return new ArrayList<>();
       int left, right;
       List<List<Integer>> res = new ArrayList<>();
       for(int i = 0; i < nums.length; i++){
           left = i + 1;
           right = nums.length - 1;
           if(nums[i] > 0){
               break;
           }
           if(i > 0 && nums[i] == nums[i-1]){
               continue;
           }
           while(left < right){
               if(nums[i] + nums[left] + nums[right] == 0){
                   res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                   while(left < right && nums[left] == nums[left + 1]){
                       left++;
                   }
                   while(left < right && nums[right] == nums[right - 1]){
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
    * @Description: 如果matrix矩阵中有一个为0，则该行该列都为0
    * @Param: [matrix]
    * @return: void
    * @Author: yangyihan
    * @Date: 2020/11/18 23:37
    */
    public void setZeroes(int[][] matrix){
        if(matrix.length == 0)
            return;
        boolean[][] valid = new boolean[matrix.length][matrix[0].length];
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] != 0){
                    continue;
                }else{
                    search(valid, i, j);
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(valid[i][j]){
                    matrix[i][j] = 0;
                }
            }
        }
        return;
    }
    public void search(boolean[][] valid, int row, int col){
        for(int i = 0; i < valid.length; i++){
            valid[i][col] = true;
        }
        for(int j = 0; j < valid[0].length; j++){
            valid[row][j] = true;
        }
        return;
    }

    /**
    * @Description: 字母异位词分组，找出字母相同但是排列不同的字母
    * @Param: [strs]
    * @return: java.util.List<java.util.List<java.lang.String>>
    * @Author: yangyihan
    * @Date: 2020/11/19 9:53
     * 设置一个hash表，key = 字母序排列的单词， value = 各个单词
     * 然后将每个key依次打印出来。
    */
    public static List<List<String>> groupAnagrams(String[] strs){
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            if(map.containsKey(temp)){
                map.get(temp).add(strs[i]);
            }else {
                map.put(temp, Arrays.asList(strs[i]));
            }
        }
        for(String key : map.keySet()){
            list.add(map.get(key));
        }
        return list;
    }

    /**
    * @Description: 对链表进行插入排序
    * @Param: [head]
    * @return: leetcode.primary_algo.ListNode
    * @Author: yangyihan
    * @Date: 2020/11/20 9:59
    */
    public ListNode insertionSortList(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode precursor;
        while(head != null && head.next != null){
            if(head.val <= head.next.val){
                head = head.next;
            }else{
                precursor = dummy;
                while(precursor.next.val < head.next.val){
                    precursor = precursor.next;
                }
                ListNode current = head.next;
                head.next = current.next;
                current.next = precursor.next;
                precursor.next = current;
            }
        }
        return dummy.next;
    }

    /**
    * @Description: 排序链表，将链表按照升序排列。
    * @Param: [head]
    * @return: leetcode.primary_algo.ListNode
    * @Author: yangyihan
    * @Date: 2020/11/21 10:28
     * 归并排序的经典例题，三步走的策略
     * 1.快慢指针找到中点
     * 2.递归调用mergeSort。
     * 3.合并两个链表
     *
    */
    public static ListNode sortList(ListNode head){
        return mergeSort(head);
    }
    public static ListNode mergeSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        ListNode left;
        ListNode right;
        // 1. 快慢指针找到中点
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        // 递归后半段链表
        right = mergeSort(slow.next);
        slow.next = null;
        // 递归前半段链表
        left = mergeSort(head);
        return mergeList(left, right);
    }
    public static ListNode mergeList(ListNode left, ListNode right){
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        // 简单的双路排序
        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left;
                left = left.next;
            }else{
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        // 将剩下的添加到后面
        current.next = left == null? right : left;
        return dummy.next;
    }

    /**
    * @Description: 移动零，将所有的零移动到数组的末尾，且保持非零元素的相对顺序不变
    * @Param:
    * @return:
    * @Author: yangyihan
    * @Date: 2020/11/21 11:34
     * 将非零元素依次填入数组，统计非零元素的个数，直接在数组后面添加0即可。
    */
    public static void moveZeroes(int[] nums){
        if(nums.length == 0 || nums == null)
            return;
        int index = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
            }else {
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i = 0; i < count; i++){
            nums[index] = 0;
            index++;
        }
        return;
    }

    /**
    * @Description: 无重复字符的最长子串
    * @Param: [s]
    * @return: int
    * @Author: yangyihan
    * @Date: 2020/11/22 15:55
     * 使用滑动窗口的方法。
    */
    public static int lengthOfLongestSubstring(String s){
        if(s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        map.put(chars[0], 1);
        int current_size = 1;
        int index = 0;
        int max = 1;
        for(int i = 1; i < chars.length; i++){
            if(!map.containsKey(chars[i])){
                current_size++;
                map.put(chars[i], i+1);
            }else if(map.containsKey(chars[i]) && index < map.get(chars[i])){
                index = map.get(chars[i]);
                current_size = i - index + 1;
                map.remove(chars[i]);
                map.put(chars[i], i+1);
            }
            if(max < current_size){
                max = current_size;
            }
        }
        return max;
    }

    /**
    * @Description: 用最少数量的箭射爆气球， 其实是算相交的区间
    * @Param: [points]
    * @return: int
    * @Author: yangyihan
    * @Date: 2020/11/23 10:42
     * 本质的思想是求交集，两个区间如果有交集就更新他们的区间范围。
     * 如果有新的区间没有落在交集，就将交集更新为新的区间
    */
    public static int findMinArrowShots(int[][] points){
        if(points.length < 2)
            return points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] range = new int[]{points[0][0], points[0][1]};
        int result = 1;
        for(int i = 1; i < points.length; i++){
            // 交集
            if(points[i][0] <= range[1]){
                range[0] = Math.max(range[0], points[i][0]);
                range[1] = Math.min(range[1], points[i][1]);
            }else {
                range[0] = points[i][0];
                range[1] = points[i][1];
                result++;
            }
        }
        return result;
    }
    public static int findMinArrowShots_sort(int[][] points){
        if(points.length < 2)
            return points.length;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int result = 1;
        int distance = points[0][1];
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > distance) {
                result++;
                distance = points[i][1];
            }
        }
        return result;
    }

    /**
    * @Description: 完全二叉树的节点个数
    * @Param: [root]
    * @return: int
    * @Author: yangyihan
    * @Date: 2020/11/24 10:56
    */
    public int countNodes(TreeNode root){
        if(root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            count++;
            if(poll.left != null){
                queue.add(poll.left);
            }
            if(poll.right != null){
                queue.add(poll.right);
            }
        }
        return count;
    }
    public int countNode_method2(TreeNode root){
        int height = treeHeight(root);
        if(height == 0 || height == 1){
            return height;
        }
        /* 如果右子树的高度 = 树的高度 - 1 说明左子树是满二叉树
        *  这时候需要计算右子树的高度
        * */
        if(treeHeight(root.right) == height - 1){
            return (1<<(height-1)) + countNode_method2(root.right);
        }else {
            return (1 << (height-2)) + countNode_method2(root.left);
        }
    }
    // 递归计算树的高度
    public int treeHeight(TreeNode root){
        return root == null ? 0 : treeHeight(root.left) + 1;
    }

    /*
    454. 四数相加
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D){
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int a : A){
            for(int b : B){
                if(map.containsKey(a+b)){
                    map.put(a+b, map.get(a+b)+1);
                }else{
                    map.put(a+b, 1);
                }
            }
        }
        for(int c : C){
            for(int d : D){
                if(map.containsKey(-(c+d))){
                    res += map.get(-(c+d));
                }
            }
        }
        return res;
    }

    /*
    164. 最大间距
     */
    public int maximumGap(int[] nums){
        if(nums.length < 2)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = nums.length;
        for(int i = 0; i < len; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(min == max){
            return 0;
        }
        // len - 1 个桶
        int[] bucket_min = new int[len - 1];
        int[] bucket_max = new int[len - 1];
        Arrays.fill(bucket_max, -1);
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        // 确认桶之间的间隔
        int interval = (int)Math.ceil((double) (max - min) / (len - 1));
        for(int i = 0; i < len; i++){
            int index = (nums[i] - min) / interval;
            if(nums[i] == min || nums[i] == max){
                continue;
            }
            bucket_max[index] = Math.max(nums[i], bucket_max[index]);
            bucket_min[index] = Math.min(nums[i], bucket_min[index]);
        }
        int maxGap = 0;
        // preMax 表示前一个桶的最大值
        int preMax = min;
        for (int i = 0; i < len - 1; i++) {
            // 表示某一个桶为空
            // 但凡某一个桶不为空，都会在前面的数据中更新掉bucketMax的值
            if (bucket_max[i] == -1) continue;
            maxGap = Math.max(bucket_min[i] - preMax, maxGap);
            preMax = bucket_max[i];
        }
        // [1,10000000]
        maxGap = Math.max(maxGap, max - preMax);
        return maxGap;
    }
    /**
     * @Author Yang
     * @Date 2020/11/28 10:24
     * @Description 翻转对
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
     * 本质上是求数组中的逆序对，核心的思想就是归并排序。
     * 先求最小单元是否存在逆序，统计逆序对的个数，然后将它排序避免重复计算
     * 在以合并后的单元为最小单元以此来进行比较。
     */
    public static int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        return reversePairsRecursive(nums, 0, nums.length - 1);
    }

    public static int reversePairsRecursive(int[] nums, int left, int right) {
        if (left == right) {
            return 0;
        } else {
            int mid = (left + right) / 2;
            int n1 = reversePairsRecursive(nums, left, mid);
            int n2 = reversePairsRecursive(nums, mid + 1, right);
            int ret = n1 + n2;

            // 首先统计下标对的数量
            int i = left;
            int j = mid + 1;
            while (i <= mid) {
                while (j <= right && (long) nums[i] > 2 * (long) nums[j]) {
                    j++;
                }
                ret += j - mid - 1;
                i++;
            }

            // 随后合并两个排序数组
            int[] sorted = new int[right - left + 1];
            int p1 = left, p2 = mid + 1;
            int p = 0;
            while (p1 <= mid || p2 <= right) {
                if (p1 > mid) {
                    sorted[p++] = nums[p2++];
                } else if (p2 > right) {
                    sorted[p++] = nums[p1++];
                } else {
                    if (nums[p1] < nums[p2]) {
                        sorted[p++] = nums[p1++];
                    } else {
                        sorted[p++] = nums[p2++];
                    }
                }
            }
            for (int k = 0; k < sorted.length; k++) {
                nums[left + k] = sorted[k];
            }
            return ret;
        }
    }

    /**
     * @Author Yang
     * @Date 2020/11/28 11:01
     * @Description 数组中的逆序对
     * 本质上和上一题的思想是一样的
     */
//    public int reversePairs(int[] nums){
//        if(nums == null || nums.length == 0){
//            return 0;
//        }
//
//    }
//    public int reversePairsMerge(int[] nums, int left, int right){
//        if(left == right)
//            return 0;
//        int mid = (left + right) / 2;
//        int num1 = reversePairsMerge(nums, left, mid);
//        int num2 = reversePairsMerge(nums, mid+1, right);
//        int result = num1 + num2;
//        int i = mid;
//        int j = right;
//
//    }
    /**
     * 归并排序的经典例题
     */
    public static void merge(int[] nums, int start, int end){
        if(start == end)
            return;
        int mid = start + (end- start) / 2;
        // 递归分块
        merge(nums, start, mid);
        merge(nums, mid+1, end);
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        // 大小比较赋值到temp中
        while(i <= mid && j <= end){
            temp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while(i <= mid){
            temp[index++] = nums[i++];
        }
        while(j <= end){
            temp[index++] = nums[j++];
        }
        // 将temp数组复制到nums数组中，分别确定起始位置和长度
        System.arraycopy(temp,0, nums, start, end-start+1);
    }

    /**
     * @Author Yang
     * @Date 2020/11/28 15:06
     * @Description 数组中的逆序对，使用的就是归并排序的思想。
     */
    public static int reversePairs_1(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        return reversePairsMerge(nums, 0, nums.length-1);
    }
    public static int reversePairsMerge(int[] nums, int start, int end){
        if(start == end){
            return 0;
        }
        int mid = start + (end - start) / 2;
        int num1 = reversePairsMerge(nums, 0, mid);
        int num2 = reversePairsMerge(nums, mid+1, end);
        int result = num1 + num2;
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int index = 0;
        while(i <= mid && j <= end){
            result += nums[i] <= nums[j] ? j - (mid + 1) : 0;
            temp[index++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        // 当前半部分还没有排列完 说明还是存在逆序对的
        while(i <= mid){
            result += j - (mid + 1);
            temp[index++] = nums[i++];
        }
        // 当后半部分还没有排列完 这时候就不存在逆序对了
        while(j <= end){
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, end-start+1);
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/11/29 10:31
     * @Description 能组成三角形线段的最大周长
     */
    public int largestPerimeter(int[] A){
        Arrays.sort(A);
        int right = A.length - 1;
        int mid = right - 1;
        int left = right - 2;
        while(left >= 0){
            if (A[left] + A[mid] > A[right]) {
                return A[left] + A[mid] + A[right];
            }
            right--;
            mid = right - 1;
            left = mid - 1;
        }
        return 0;
    }

    /**
     * @Author Yang
     * @Date 2020/11/29 10:32
     * @Description 计算右侧小于当前元素的个数
     */
    public List<Integer> countSmaller(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        int[] temp = new int[len];
        int[] res = new int[len];
        // 创建索引数组
        int[] index = new int[len];
        for(int i = 0; i < len; i++){
            index[i] = i;
        }
        mergeAndCountSmaller(nums, 0, nums.length-1, index, temp, res);
        for(int i = 0; i < len; i++){
            result.add(res[i]);
        }
        return result;
    }
    public void mergeAndCountSmaller(int[] nums, int left, int right, int[] index, int[] temp, int[] res){
        if(left == right)
            return;
        int mid = left + (right - left) / 2 ;
        mergeAndCountSmaller(nums, left, mid, index, temp, res);
        mergeAndCountSmaller(nums, mid + 1, right, index, temp, res);
        // 如果归并数组是有序的， 就不需要进行合并
        if(nums[index[mid]] <= nums[index[mid+1]]){
            return;
        }
        mergeOfTwoSortedArr(nums, left, mid, right, index, temp, res);
    }
    public void mergeOfTwoSortedArr(int[] nums, int left, int mid, int right, int[] index, int[] temp, int[] res){
        for(int i = left;  i <= right; i++){
            temp[i] = index[i];
        }
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k++){
            if (i > mid) {
                index[k] = temp[j];
                j++;
            } else if (j > right) {
                index[k] = temp[i];
                i++;
                res[index[k]] += (right - mid);
            } else if (nums[temp[i]] <= nums[temp[j]]) {
                // 注意：这里是 <= ，保证稳定性
                index[k] = temp[i];
                i++;
                res[index[k]] += (j - mid - 1);
            } else {
                index[k] = temp[j];
                j++;
            }
        }
    }
    
    /**
     * @Author Yang
     * @Date 2020/11/29 11:19
     * @Description 递增的三元子序列
     * 这道题两个等号的关键，避免重复元素对结果造成干扰
     */
    public boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length < 3)
            return false;
        int first = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            // 确定第一个数 在i之前都是单调递减或者是波动的
            if(nums[i] <= first){
                first = nums[i];
            }else if(nums[i] <= middle){ // 确定第二个数
                middle = nums[i];
            }else{  // 第三个数存在就返回true
                return true;
            }
        }
        return false;
    }

    /**
     * @Author Yang
     * @Date 2020/11/29 12:09
     * @Description 回文子串
     * 给定一个字符串，统计这个字符串中回文串的个数。
     * 使用的是中心扩展的方法。
     * 中心的选择： 中心有两种，一种是单中心，对应的回文串是奇数的情况， 一种是双中心，对应的回文串是偶数的情况。
     * 这两种中心就可以组成所有的中心情况。
     * 这两种中心的个数分别是 len（单） + len - 1 （双） = 2 * len - 1；
     * left、right分别对应的是左右两个指针，奇数的时候初始指向的是相同位置， 偶数的时候指向的是不同的位置。
     * 然后向左右两侧开始遍历即可。
     * 本题是统计回文串的个数，所以只要有符合条件的，result++。
     */
    public int countSubstrings(String s){
        if(s == null)
            return 0;
        int result = 0;
        char[] chars = s.toCharArray();
        for(int center = 0; center < s.length() * 2 - 1; center++){
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < s.length() && chars[left] == chars[right]){
                left--;
                right++;
                result++;
            }
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/11/29 12:21
     * @Description 最长回文子串
     * 和上一题是相同类型的。
     *
     */
    public static String longestPalindrome(String s){
        if(s == null)
            return "";
        String result = "";
        int max = Integer.MIN_VALUE;
        char[] chars = s.toCharArray();
        for(int center = 0; center < 2 * chars.length - 1; center++){
            int left = center / 2;
            int right = left + center % 2;
            while(left >= 0 && right < chars.length && chars[left] == chars[right]){
                left--;
                right++;
            }
            int len = right - left - 1;
            if(len > result.length()){
                result = s.substring(left+1, right);
            }
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/11/30 10:45
     * @Description 将字符串重排，使得相邻字符不是重复元素
     */
    public static String reorganizeString(String S){
        HashMap<Character, Integer> map = new HashMap<>();
        // 统计字符串中字符出现次数
        for(Character c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        StringBuilder result = new StringBuilder(S.length());
        // 根据字符出现个数 构建一个大顶堆
        for(Map.Entry<Character, Integer> m : map.entrySet()){
            maxHeap.add(m);
        }
        Map.Entry<Character, Integer> pre = null;
        while(!maxHeap.isEmpty()){
            Map.Entry<Character, Integer> cur = maxHeap.poll();
            // 构建的是大顶堆 所以能保证最大的两个交替进行重构
            if(pre != null && pre.getValue() > 0){
                maxHeap.offer(pre);
            }
            result.append(cur.getKey());
            cur.setValue(cur.getValue()-1);
            pre = cur;
        }
        return result.length() == S.length() ? result.toString() : "";
    }

    /**
     * @Author Yang
     * @Date 2020/11/30 10:51
     * @Description 数组中的第K个最大元素
     */
    public int findKthLargest(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        for(int i = 0; i < nums.length; i++){
            heap.offer(nums[i]);
        }
        while(k > 1){
            heap.poll();
            k--;
        }
        return heap.poll();
    }

    /**
     * @Author Yang
     * @Date 2020/12/1 10:27
     * @Description  在排序数组中查找元素的第一个和最后一个位置
     * 使用二分法确定区间的初始位置，然后分别向左右进行遍历
     */
    public static int[] searchRange(int[] nums, int target){
        if(nums.length == 0 || nums == null)
            return new int[]{-1,-1};
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < target){
                left = mid + 1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid;
                right = mid;
                while(left > 0 && nums[left] == nums[left-1]){
                    left--;
                }
                while(right < nums.length-1 && nums[right] == nums[right+1]){
                    right++;
                }
                result[0] = left;
                result[1] = right;
                return result;
            }
        }
        return new int[]{-1, -1};
    }

    public static int[] searchRange_v2(int[] nums, int target){
        if(nums.length == 0 || nums == null)
            return new int[]{-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        if(nums[left] != target){
            return new int[]{-1, -1};
        }
        int[] res = new int[2];
        res[0] = left;
        right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] <= target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        res[1] = left - 1;
        return res;
    }
    
    /**
     * @Author Yang
     * @Date 2020/12/2 10:08
     * @Description 最接近原点的K个点
     * 用小顶堆的思想来做。
     */
    public int[][] kClosest(int[][] points, int K){
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] a, int[] b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for(int[] i : points){
            heap.add(i);
        }
        int[][] result = new int[K][2];
        for(int i = 0; i < K; i++){
            int[] poll = heap.poll();
            result[i][0] = poll[0];
            result[i][1] = poll[1];
        }
        return result;
    }
    
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
     * @Date 2020/12/3 10:18
     * @Description 计算质数， 统计所有小于n的质数的个数
     * 方法是：埃氏筛
     */
    public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * @Author Yang
     * @Date 2020/12/3 10:49
     * @Description 丑数，只包含质因数2，3，5的正整数。
     */
    public boolean isUgly(int num){
        if(num < 1)
            return false;
        while(num % 5 == 0){
            num /= 5;
        }
        while(num % 3 == 0){
            num /= 3;
        }
        while(num % 2 == 0){
            num /= 2;
        }
        return num == 1;
    }

    /**
     * @Author Yang
     * @Date 2020/12/4 10:30
     * @Description 分割数组为连续子序列， 要求每个序列是由小到大排列，且长度不小于3。
     */
    public static boolean isPossible(int[] nums){
        /**
         * Map： key —— num， value —— 优先队列，存放的是以当前key开始的子串的长度，维护的是一个小根堆
         * 小根堆：保证下一个数来的时候，子串长度最小的能够先匹配，尽快达到3.(贪心思想)。
         */
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, new PriorityQueue<>());
            }
            if(map.containsKey(num - 1)){
                // len是当前最短的子串的长度
                int len = map.get(num - 1).poll();
                /**
                 * 如果当前的key只对应一个value。那么将这个key删除。
                 * 因为下一次是在key+1的基础上进行操作。
                 */
                if(map.get(num - 1).isEmpty()){
                    map.remove(num - 1);
                }
                /**
                 * 如果当前key对应的value有多个，那么只将最短的value取出来做+1操作。
                 * 其他的value仍可以在下一个key中添加，所以就不能remove。
                 */
                map.get(num).offer(len + 1);
            }else{
                /**
                 * 如果map中没有num-1的key， 那么直接将num存入map
                 * 它就是下一个子序列的开始。
                 */
                map.get(num).offer(1);
            }
        }
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : entrySet) {
            PriorityQueue<Integer> queue = entry.getValue();
            if (queue.peek() < 3) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Author Yang
     * @Date 2020/12/4 11:17
     * @Description 前K个高频元素
     * 小顶堆的思想，前K个元素直接添加，后面的元素大的才添加进去。
     */
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int key : map.keySet()){
            if(heap.size() < k){
                heap.add(key);
            }else {
                if(map.get(heap.peek()) < map.get(key)){
                    heap.poll();
                    heap.add(key);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        while(!heap.isEmpty()){
            result[index++] = heap.poll();
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/4 12:06
     * @Description 前K个高频单词
     */
    public static List<String> topKFrequent(String[] words, int k){
        Map<String, Integer> map = new HashMap<>();
        /**
         * 1.统计频率
         */
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        /**
         * 2.建立小根堆
         */
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1) != map.get(o2)){
                    return map.get(o1) - map.get(o2);
                }
                return o2.compareTo(o1);
            }
        });
        /**
         * 3.将结果写入小根堆
         */
        for(String key : map.keySet()){
            heap.add(key);
            if (heap.size() > k)
                heap.poll();
        }
        List<String> result = new ArrayList<>();
        while(!heap.isEmpty()){
            result.add(heap.poll());
        }
        /**
         * key 少了这一步就是逆序了
         */
        Collections.sort(result, ((o1, o2) -> map.get(o1) - map.get(o2) == 0 ? o1.compareTo(o2) : map.get(o2) - map.get(o1)));
        return result;
    }


    /**
     * @Author Yang
     * @Date 2020/12/6 10:06
     * @Description 杨辉三角
     */
    public List<List<Integer>> generate(int numRows){
        if(numRows == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        int[][] arr = new int[numRows][numRows];
        for(int i = 0; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
                list.add(arr[i][j]);
            }
            result.add(list);
        }
        return result;
    }

    /**
     * @Author Yang
     * @Date 2020/12/9 9:55
     * @Description 62.不同路径，从左上到右下的不同路径的数量
     */
    public int uniquePaths(int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    /**
     * @Author Yang
     * @Date 2020/12/10 10:13
     * @Description 柠檬水找零
     */
    public boolean lemonadeChange(int[] bills){
        if(bills == null || bills.length == 0){
            return true;
        }
        if(bills[0] != 5)
            return false;
        int[] count_coin = new int[]{1,0,0};
        for(int i = 1; i < bills.length; i++){
            if(bills[i] == 5){
                count_coin[0]++;
            }
            else if(bills[i] == 10){
                if(count_coin[0] > 0){
                    count_coin[0]--;
                    count_coin[1]++;
                }else {
                    return false;
                }
            } else {
                if(count_coin[1] > 0 && count_coin[0] > 0){
                    count_coin[0]--;
                    count_coin[1]--;
                }else if(count_coin[0] > 3){
                    count_coin[0] -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @Author Yang
     * @Date 2020/12/11 10:32
     * @Description Dota2参议院
     */
    public String predictPartyVictory(String senate){
        Deque<Integer> Radiant = new LinkedList<>();
        Deque<Integer> Dire = new LinkedList<>();
        char[] chars = senate.toCharArray();
        int len = senate.length();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 'R'){
                Radiant.add(i);
            }else {
                Dire.add(i);
            }
        }
        while(!Radiant.isEmpty() && !Dire.isEmpty()){
            int R = Radiant.pollFirst();
            int D = Dire.pollFirst();
            /**
             * 加len是为了这轮跟其他的继续比较
             */
            if(R < D){
                Radiant.addLast(R + len);
            }else{
                Dire.addLast(D + len);
            }
        }
        return Radiant.isEmpty()? "Dire" : "Radiant";
    }

    /**
     * @Author Yang
     * @Date 2020/12/14 10:03
     * @Description 字母异位词分组
     */
    public List<List<String>> groupAnagrams(String[] strs, String x){
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i = 0; i < strs.length; i++){
            char[] a = strs[i].toCharArray();
            Arrays.sort(a);
            String s = new String(a);
            if(map.containsKey(s)){
                List<String> list = map.get(s);
                list.add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(s, list);
            }
        }
        for(String s : map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }
    
    /**
     * @Author Yang
     * @Date 2020/12/15 9:50
     * @Description 738.单词递增
     * 找出不大于当前数数字的单带哦递增的元素
     */
    public int monotoneIncreasingDigits(int N){
        String s = String.valueOf(N);
        int len = s.length();
        char[] chars = s.toCharArray();
        int flag = len;
        for(int i = len - 1; i >= 1; i--){
            if(chars[i] < chars[i-1]){
                flag = i;
                chars[i-1]--;
            }
        }
        for(int i = flag; i < len; i++){
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }

    /**
     * @Author Yang
     * @Date 2020/12/16 10:03
     * @Description 290.单词规律
     */
    public static boolean wordPattern(String pattern, String s) {
        if(pattern == null || s == null){
            return false;
        }
        String[] digit = s.split(" ");
        if(digit.length != pattern.length()){
            return false;
        }
        HashMap<String, Character> map = new HashMap<>();
        for(int i = 0; i < pattern.length(); i++){
            char value = pattern.charAt(i);
            String key = digit[i];
            if(map.containsKey(key)){
               if(!map.get(key).equals(value)){
                   return false;
               }
            }else{
                if(map.containsValue(value)){
                    return false;
                }
                map.put(key, value);
            }
        }
        return true;
    }

    /**
     * @Author Yang
     * @Date 2020/12/16 10:40
     * @Description 205.同构字符串
     */
    public boolean isIsomorphic(String s, String t){
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            char value = t.charAt(i);
            if(map.containsKey(key)){
                if(!map.get(key).equals(value)){
                    return false;
                }
            }else {
                if(map.containsValue(value)){
                    return false;
                }
                map.put(key, value);
            }
        }
        return true;
    }

    /**
     * @Author Yang
     * @Date 2020/12/18 15:07
     * @Description 找不同
     */
    public static char findTheDifference(String s, String t) {
        if(s == null){
            return t.charAt(0);
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] s_char = s.toCharArray();
        char[] t_char = t.toCharArray();
        for(int i = 0; i < s.length(); i++){
            map.put(s_char[i], map.getOrDefault(s_char[i], 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            if(map.containsKey(t_char[i])){
                int count = map.get(t_char[i]) - 1;
                if(count < 0){
                    return t_char[i];
                }
                map.put(t_char[i], count);
            }else{
                return t_char[i];
            }
        }
        return ' ';
    }

    /**
     * @Author Yang
     * @Date 2020/12/19 18:05
     * @Description 旋转图像
     */
    public void rotate(int[][] matrix){
        if(matrix == null || matrix.length == 0)
            return;
        int row_start = 0;
        int row_end = matrix.length - 1;
        while(row_start < row_end){
            int col_start = row_start;
            int col_end = row_end;
            while(col_start < col_end){
                int temp = matrix[row_start][col_start];
                matrix[row_start][col_start] = matrix[row_end][col_start];
                matrix[row_end][col_start] = matrix[row_end][col_end];
                matrix[row_end][col_end] = matrix[row_start][col_end];
                matrix[row_start][col_end] = temp;
            }
            row_start++;
            row_end--;
        }
        return;
    }

    public static int[] delete_first(int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add(nums[i]);
        }
        list.remove(list.indexOf(0));
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public double  getDistance(double aLon,double alat,double zLon,double zlat) {
        Long length=null;
        int Ri = 6371;
        Double d = ( Ri * Math.acos(Math.sin(alat*(Math.PI/180))*Math.sin(zlat*(Math.PI/180)) +
                Math.cos(alat*(Math.PI/180))*Math.cos(zlat*(Math.PI/180))*Math.cos((aLon - zLon)*(Math.PI/180))));
        length = Math.round(d*1000);
        return length;
    }

    /**
     * @Author Yang
     * @Date 2021/1/15 12:08
     * @Description 387.字符串中的第一个唯一字符
     */
    public int firstUniqChar(String s){
        if(s == null || s.length() == 0)
            return -1;
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : chars){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < chars.length; i++){
            if(map.get(chars[i]) == 1)
                return i;
        }
        return -1;
    }

    /**
     * @Author Yang
     * @Date 2021/1/16 11:26
     * @Description 455.发饼干
     */
    public int findContentChildren(int[] g, int[] s){
        int child = 0;
        int cookie = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(child < g.length && cookie < s.length){
            if(g[child] <= s[cookie]){
                child++;
            }
            cookie++;
        }
        return child;
    }
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
import java.util.*;

/**
 * 小顶堆的基础例题， 基本的做题思想。
 * 前K个最大最小的元素：
 *   * 1. 统计频率——hashmap。
 *   * 2. 创建小/大顶堆， new Comparator中指定比较逻辑。
 *   * 3. 将hashmap中的值写入到堆中。
 *   * 4. 将堆中的元素弹出输出到指定的数据结构中。
 *
 */
public class heap {
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
     * @Date 2020/12/6 10:20
     * @Description 根据字符出现频率排序。
     * 给定一个字符串，将字符串中的字符按照出现频率的逆序进行排序。
     */
    public String frequencySort(String s){
        if(s == null || s.length() == 0)
            return s;
        Map<Character, Integer> map = new HashMap<>();
        for(char digit : s.toCharArray()){
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }
        PriorityQueue<Character> heap = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for(Character key : map.keySet()){
            heap.add(key);
        }
        String result = "";
        while(!heap.isEmpty()){
            char digit = heap.poll();
            int index = map.get(digit);
            while(index > 0){
                result += digit;
                index--;
            }
        }
        return result;
    }
}

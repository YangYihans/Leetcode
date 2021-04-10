package leetcode.Design;

import java.util.LinkedList;
import java.util.List;

/*
面试59-II 队列的最大值
请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 */
public class MaxQueue {

    private List<Integer> list;
    private List<Integer> maxList;

    public MaxQueue()
    {
        list = new LinkedList<>();
        maxList = new LinkedList<>();
    }

    public int max_value()
    {
        if(maxList.isEmpty())
            return -1;
        return maxList.get(0);
    }

    /**
     * 每次对于最大队列的操作是：当小的数遇到大的数，那么队列中小数全部删除只保留大的数。大数后面的小树又依次添加。
     * @param value
     */
    public void push_back(int value)
    {
        list.add(value);
        while(!maxList.isEmpty() && maxList.get(maxList.size()-1) < value)
        {
            maxList.remove(maxList.size()-1);
        }
        maxList.add(value);
    }

    /**
     * 每次弹出的时候和最大队列的第一个数比较，小就直接弹出，相同就一起弹出。
     * @return
     */
    public int pop_front()
    {
        if(list.isEmpty())
            return -1;
        int pop = list.get(0);
        list.remove(0);
        if(maxList.get(0) == pop)
            maxList.remove(0);
        return pop;
    }
}

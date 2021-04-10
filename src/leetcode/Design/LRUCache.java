package ByteDance.design;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer> {
    private int capacity;
    public LRUCache(int capacity)
    {
        //true：按照读取顺序排序
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    public int get(int key)
    {
        return super.getOrDefault(key,-1);
    }
    public void put(int key, int value)
    {
        super.put(key,value);
    }

    //原方法是移除最近最少访问条件之一。通过此方法可以实现不同的缓存策略。默认是返回false
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }
}



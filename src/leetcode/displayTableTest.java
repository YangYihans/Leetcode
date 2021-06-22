package leetcode;

import java.util.*;

public class displayTableTest {
    public static void main(String[] args) {
        displayTableTest t1 = new displayTableTest();

    }
    public List<List<String>> displayTable(List<List<String>> orders)
    {
        //int [] tableNum  =  new int[orders.size()+1];
        String[] foodItem = new String[orders.size()+1];
        HashSet<String> hashSet = new HashSet<>();
        for(List list : orders)
        {
            int index = (int) list.get(1);
            String food = (String) list.get(2);
            hashSet.add(food);
            foodItem[index] += "+" + food;
        }
        List<List<String>> res = new LinkedList<>();
        List<String> list = new ArrayList<>();
        list.add("Table");
        Iterator<String> iterator = hashSet.iterator();
        while(iterator.hasNext())
        {
            String next = iterator.next();
            list.add(next);
        }
        res.add(list);
        return res;
    }
}

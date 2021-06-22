import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class has {
    public static void main(String[] args) {
        Hashtable<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("3",4);
        hashtable.put("2",2);
        hashtable.put("3",2);
        process(hashtable);
    }

    private static void process(Hashtable<String, Integer> hashtable) {
        if (hashtable == null){
            return;
        }
        String key = null;
        Integer integer = null;
        Iterator iterator  = hashtable.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            key = (String) entry.getKey();
            integer = (Integer)entry.getValue();
            System.out.println(key + " -- " + integer.intValue());
        }
    }

}

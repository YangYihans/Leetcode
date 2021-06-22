import java.sql.SQLOutput;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class learn {
    public static void main(String[] args) {
        String a = new String("ab");
        String b = new String("ab");
        String c = "ab";
        String d = "a";
        String e = new String("b");
        String f = d + e;
        System.out.println(a.intern() == b);   // false
        System.out.println(a.intern() == b.intern());  // true
        System.out.println(a.intern() == c);  // true
        System.out.println(a.intern() == f);  // false

    }
}

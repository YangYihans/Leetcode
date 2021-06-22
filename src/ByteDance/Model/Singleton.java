package ByteDance.Model;

/**
 * 饿汉式
 */
public class Singleton {
    private static Singleton singleton = new Singleton();
    private Singleton(){}
    public static Singleton getSingleton()
    {
        return singleton;
    }
}

/**
 * 双重校验单例模式
 */
/*
public class Singleton{
    private static volatile Singleton singleton;
    private Singleton(){}
    public static Singleton getSingleton()
    {
        if(singleton == null)
        {
            synchronized (Singleton.class)
            {
                if(singleton == null)
                    singleton = new Singleton();
            }
        }
        return singleton;
    }
}
*/

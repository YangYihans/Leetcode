package Design_pattern.Proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class XiaoHong {
    public static void main(String[] args) {
        ChannelFactory channelFactory = new ChannelFactory();
        SellProxyFactory sellProxyFactory = new SellProxyFactory(channelFactory);
        SellPerfume sellPerfume = (SellPerfume) Proxy.newProxyInstance(channelFactory.getClass().getClassLoader(),
                channelFactory.getClass().getInterfaces(), sellProxyFactory);
        sellPerfume.sellPerfume(1999.99);
    }
    /**
     * @Author Yang
     * @Date 2021/4/7 21:48
     * @ClassLoader loader:    加载动态代理类的类加载器。
     * @Class<?>[] interfaces: 代理类实现的接口，可传入多个接口。
     * InvocationHandler h：   指定代理类的调用处理程序，即调用接口中的方法时，会找到该代理工厂h，执行invoke()方法。
     */
}

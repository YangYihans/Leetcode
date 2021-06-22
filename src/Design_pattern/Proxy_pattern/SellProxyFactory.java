package Design_pattern.Proxy_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SellProxyFactory implements InvocationHandler {
    /* 代理的真实对象 */
    private Object realObject;

    public SellProxyFactory(Object realObject){
        this.realObject = realObject;
    }

    @Override
    /**
     * @Author Yang
     * @Date 2021/4/7 21:33
     * @Object proxy:  代理对象
     * @Method method: 真正执行的方法
     * @Object[] args: 调用第二个参数method时传入的参数列表值。
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingBefore();
        Object obj = method.invoke(realObject, args);
        doSomethingAfter();
        return obj;
    }

    private void doSomethingAfter() {
        System.out.println("执行代理后的额外操作...");
    }

    private void doSomethingBefore() {
        System.out.println("执行代理前的额外操作...");
    }


}

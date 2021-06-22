package Design_pattern.Proxy_pattern;

public class ChannelFactory implements SellPerfume {
    @Override
    public void sellPerfume(double price) {
        System.out.println("成功购买香奈儿的香水, 价格是：" + price + "元");
    }
}

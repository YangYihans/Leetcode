package leetcode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/*42.接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。

示例:
输入: [0,1,0,2,1,0,1,3,2,1,2,1]
输出: 6

思路：双指针找边界，两边界的最小值确定为高度，边界之间的值和边界的高度做差得到雨水量。
找边界的条件：先确定数组第一个不为零的数字为左边界，然后再找右边界，
如果有柱子比左边界高，选定为右边界，直接跳出，计算此时两个边界之间的雨水量；
如果右边的柱子没有左边的边界高，那么就计算出右边柱子的最大值取出作为右边界；
然后将上一次的右边界作为下一次的左边界，依次查找。
 */
public class trapTest {
    public static void main(String [] args)
    {
        trapTest t1 = new trapTest();
        int[] a = new int[]{5,2,1,3,1,5};
        System.out.println(t1.trap(a));
    }
    public int trap(int[] height)
    {
        int n = height.length;
        if(height == null)
            return -1;
        int i = 0;
        int l = 0;
        for(i=0; i<n; i++)
        {
            if(height[i] != 0)
            {
                l = i;
                break;
            }
        }

        int r = l + 1;
        int edgeHeight;
        int sum = 0;

        while (l < r && l < n-1)
        {
            int max = 0;
            for(i = l+1; i <= n-1; i++)
            {
                if(height[i]>height[l])
                {
                    r = i;
                    break;
                }

                if(height[i]>max)
                {
                    max = height[i];
                    r = i;
                }
            }
            if(height[l] < height[r])
                edgeHeight = height[l];
            else
                edgeHeight = height[r];
            for(i = l+1; i < r; i++)
            {
                if(height[i]>edgeHeight)
                    height[i] = edgeHeight; //超过高度的块设置为边界一样高不影响计算
                sum = sum + edgeHeight-height[i];
            }
            l = r;
            r = l + 1;
        }
        return sum;
    }
}

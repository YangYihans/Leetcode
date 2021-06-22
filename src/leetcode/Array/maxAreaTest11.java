package leetcode.Array;
/*
11.盛最多水的容器
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class maxAreaTest11 {
    public static void main(String[] args) {
        maxAreaTest11 t1 = new maxAreaTest11();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(t1.maxArea(height));
    }

    /**
     * 要么宽度大，要么高度高
     * @param height
     * @return
     */
    public int maxArea(int[] height)
    {
        int len = height.length;
        if(len == 2)
            return Math.min(height[0],height[1]);
        int left = 0;
        int right = len-1;
        int area = 0;
        int maxArea = 0;
        while(left < right)
        {
            int width = right - left;
            int high = Math.min(height[left], height[right]);
            area = width * high;
            maxArea = area > maxArea? area : maxArea;
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;

    }
}

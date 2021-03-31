package leetcode.Binary_Search;
/**
 * @Author Yang
 * @Date 2021/3/31 15:25
 * @Description 875.爱吃香蕉的珂珂
 * 从最大值向左侧逼近。
 */
public class minEatingSpeed {
    public static int minEatingSpeed(int[] piles, int h){
        int left = 1, right = getMax(piles) + 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canFinish(piles, mid, h)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean canFinish(int[] piles, int mid, int h) {
        int time = 0;
        for(int pile : piles){
            time += Math.ceil((double) pile / mid);
        }
        return time <= h;
    }

    private static int getMax(int[] piles) {
        int max = 0;
        for(int pile : piles){
            if(pile >= max){
                max = pile;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }
}

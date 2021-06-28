package leetcode.Binary_Search;
/**
 * @Author Yang
 * @Date 2021/3/31 15:44
 * @Description 1011.在D天内能送达包裹的能力 ，包裹是不能拆分的
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * 传送带上的第 i个包裹的重量为weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 */
public class shipWithinDays {
    public static int shipWithinDays(int[] weights, int D) {
        int left = getMax(weights), right = getSum(weights);
        while(left < right){
            int mid = left + (right - left) / 2;
            if(canCarry_II(mid, weights, D)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

//    private static boolean canCarry_I(int[] weights, int mid, int d) {
//        int day = 0, patch = 0, i = 0, len = weights.length;
//        while(i < len){
//           if(patch + weights[i] <= mid){
//               patch += weights[i++];
//               continue;
//           }
//           day++;
//           patch = 0;
//        }
//        return day+1 <= d;
//    }

    public static boolean canCarry_II(int mid, int[] weights, int days){
        int real_day = 1, sum = 0, index = 0, len = weights.length;
        while(index < len){
            if(sum <= mid){
                sum += weights[index];
                index++;
            }else{
                sum = 0;
                index = index - 1;
                real_day++;
            }
        }
        /**
         * 最后一次计算的后处理，可能存在加上最后一天的重量后sum超出的情况，这时需要对real_day + 1;
         */
        real_day = sum > mid ? real_day + 1 : real_day;
        return real_day <= days;
    }

    private static int getSum(int[] weights) {
        int sum = 0;
        for(int weight : weights){
            sum += weight;
        }
        return sum;
    }

    private static int getMax(int[] weights) {
        int max = 0;
        for(int weight : weights){
            if(weight > max){
                max = weight;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4}, 3));
    }

}

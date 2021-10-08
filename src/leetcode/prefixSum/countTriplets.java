package leetcode.prefixSum;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 */
public class countTriplets {
    public static int countTriplets(int[] arr){
        int len = arr.length;
        int[] sum = new int[len + 1];
        for(int i = 1; i <= len; i++){
            sum[i] = sum[i-1] ^ arr[i-1];
        }
        int result = 0;
        for(int i = 1; i <= len; i++){
            for(int j = i + 1; j <= len; j++){
                for(int k = j; k <= len; k++){
                    int left = sum[j-1] ^ sum[i-1];
                    int right = sum[k] ^ sum[j-1];
                    if(left == right){
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countTriplets(new int[]{2, 3, 1, 6, 7}));
    }
}

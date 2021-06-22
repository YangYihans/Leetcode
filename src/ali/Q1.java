package ali;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(totalNum(6, new int[]{1,2,2,2,3,5}));
    }
    public static int totalNum(int n, int [] nums){
        int left = 0, right = 1;
        if(n == 1){
            return 1;
        }
        int cnt = 1;
        int diff = 0;
        while(right < n){
            if(nums[left] != nums[right]){
                cnt++;
                left = right;
                right++;
                continue;
            }
            while(right < n && nums[left] == nums[right]){
                right++;
            }
            if(right < n &&  nums[right] - nums[left]  <= 1){
                diff = 1;
            }
            else{
                if(right == n - 1){
                    diff = right - left;
                }else{
                    diff = right - left - 1;
                }
            }
            cnt += Math.min(diff, 2);
            left = right;
            right++;
        }
        return cnt;
    }
}

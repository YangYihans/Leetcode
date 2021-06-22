package leetcode.Binary_Search;

public class hIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int left = 0, right = len - 1, res = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int count = len - mid;
            if(count <= citations[mid]){
                res = count;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return res;
    }
}

package leetcode.Offer;

import java.util.Stack;

public class reversePrint_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while(current != null){
            stack.push(current.val);
            current = current.next;
        }
        int len = stack.size();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++){
            nums[i] = stack.pop();
        }
        return nums;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

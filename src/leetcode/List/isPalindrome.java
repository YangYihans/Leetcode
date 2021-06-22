package leetcode.List;

/**
 * @Author Yang
 * @Date 2021/3/30 11:28
 * @Description 判断链表是否是回文的
 * 树其实也是链表
 * 所以树的遍历结构可以用到链表中。 来实现正序和倒序输出链表
 */
public class isPalindrome {
    ListNode left;
    public boolean isPalindrome(ListNode head){
        if(head == null){
            return true;
        }
        left = head;
        return traverse(head.next);
    }

    private boolean traverse(ListNode right) {
        if(right == null){
            return true;
        }
        boolean res = traverse(right.next);
        res = res && (right.val == left.val);
        left = left.next;
        return res;
    }
}

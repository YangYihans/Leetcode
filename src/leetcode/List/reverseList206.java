//package leetcode.List;
///**
// * 力扣206题，将链表逆序
// * 思路：准备一个额外的栈，第一次将链表中的数据读到栈中，第二次遍历将栈中的数据重新写入到链表中，即可完成逆序
// */
//
//import java.util.Stack;
//
//public class reverseList206 {
//    public static void main(String[] args) {
//        reverseList206 t1 = new reverseList206();
//        ListNode listNode = new ListNode(1);
//        for(int i = 2; i <= 5; i++){
//            listNode.add(i);
//        }
//        //t1.reverseN(listNode, 3).print();
//        t1.reverseBetween(listNode, 2,4).print();
//    }
//
//    /**
//     * 不能新建一个ListNode会有空指针异常。
//     * @param head
//     * @return
//     */
//    public ListNode reverseList(ListNode head)
//    {
//
//        ListNode cur = head;
//        Stack<Integer> temp = new Stack<>();
//        while(cur != null)
//        {
//            temp.push(cur.val);
//            cur = cur.next;
//        }
//        cur = head;
//        while(!temp.isEmpty())
//        {
//            cur.val = temp.pop();
//            cur = cur.next;
//        }
//        return head;
//    }
//
//    public ListNode reverseListI(ListNode head){
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode last = reverseListI(head.next);
//        head.next.next = head;
//        head.next = null;
//        return last;
//    }
//
//    public ListNode reverseBetween(ListNode head, int left, int right){
//        if(head == null || left == right){
//            return head;
//        }
//        if(left == 1){
//            return reverseN(head, right);
//        }
//        head.next = reverseBetween(head.next, left-1, right-1);
//        return head;
//    }
//
//    /**
//     * @Author Yang
//     * @Date 2021/3/28 12:12
//     * @Description 翻转链表的前n个节点
//     */
//    private ListNode successor = null;  // 后继节点
//    public ListNode reverseN(ListNode head, int n){
//        if(n == 1){
//            successor = head.next;
//            return head;
//        }
//        ListNode last = reverseN(head.next, n-1);
//        head.next.next = head;
//        head.next = successor;
//        return last;
//    }
//}
//class ListNode
//{
//    int val;
//    ListNode next;
//    ListNode(int x)
//    {
//        val = x;
//    }
//    public void add(int newval) {
//        ListNode newNode = new ListNode(newval);
//        if(this.next == null)
//            this.next = newNode;
//        else
//            this.next.add(newval);
//    }
//    public void print() {
//        System.out.print(this.val);
//        if(this.next != null)
//        {
//            System.out.print("-->");
//            this.next.print();
//        }
//    }
//}

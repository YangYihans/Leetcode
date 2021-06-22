package leetcode.List;
/**
 * @Author Yang
 * @Date 2021/3/24 17:28
 * @Description 237.删除指定节点
 * 指定某一个节点，对其进行删除。
 * 没有告诉节点的前一个节点，那么就将下一个节点复制给待删除的节点。
 * 然后删除待删除的节点的下一个节点即可。
 */
public class deleteNode {
    public void deleteNode(ListNode node){
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

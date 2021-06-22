package leetcode.Tree;
/**
 * @Author Yang
 * @Date 2021/3/30 15:19
 * @Description 116. 填充每个节点的下一个右侧节点指针
 *
 */
public class connect {
    public Node connect(Node root){
        if(root == null){
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;

    }

    private void connectTwoNode(Node left, Node right) {
        if(left == null || right == null){
            return;
        }
        left.next = right;
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        connectTwoNode(left.right, right.left);
    }


}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};


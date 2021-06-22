本节是对二叉树进行遍历的汇总，以及遍历衍生出来的相关题型
```java
/* 二叉树遍历框架 */
class Tree{
    void traverse(TreeNode root) {
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }
}
```
写树相关的算法，简单说就是，先搞清楚当前root节点该做什么，
然后根据函数定义递归调用子节点，递归调用会让孩子节点做相同的事情。
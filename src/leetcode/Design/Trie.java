package leetcode.Design;
/**
 * @Author Yang
 * @Date 2021/4/14 9:29
 * @Description 208.前缀树的设计实现
 * 前缀树得构建，主要的是next节点是一个数组存放的是所有可能的节点的值。
 * 每次从根节点开始判断，对于插入操作遇到不存在就进行新建插入， 对于搜索操作遇见不存在就直接返回false。
 */
public class Trie {
        /** Initialize your data structure here. */
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] ch = word.toCharArray();
            // 从根节点开始向下构建
            TrieNode node = root;
            for(int i = 0; i < ch.length; i++){
                int u = ch[i] - 'a';
                // 判断node节点得子集中是否存在了ch[i]， 不存在就创建
                if(node.next[u] == null){
                    node.next[u] = new TrieNode();
                }
                node = node.next[u];
            }
            node.setIsEnd(true);
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < chars.length; i++){
                int u = chars[i] - 'a';
                if(node.next[u] == null){
                    return false;
                }
                node = node.next[u];
            }
            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode node = root;
            for(int i = 0; i < chars.length; i++){
                int u = chars[i] - 'a';
                if(node.next[u] == null){
                    return false;
                }
                node = node.next[u];
            }
            return true;
        }
}

class TrieNode{
    // 标识该节点是否是字符串的结束节点
    boolean isEnd = false;
    // 26个小写字母 当前节点的孩子节点
    TrieNode[] next = new TrieNode[26];
    // 设置当前节点为一个字符串的结束节点
    public void setIsEnd(boolean isEnd){
        this.isEnd = isEnd;
    }
}

package Algorithm.trieTree;

import com.sun.org.apache.xml.internal.utils.Trie;

public class TrieTree {
    private static class TrieNode {
        public int end; // 有多少段序列以该节点为结尾
        public int pass; // 有多少段序列经过该节点
        public TrieNode[] nexts; // 如果字符种类过多，可以使用TreeMap，或者HashMap

        public TrieNode() {
            end = 0;
            pass = 0;
            nexts = new TrieNode[26]; // 表示可能有的二十六个分支
        }
    }

    private final TrieNode root;

    /*
        添加小写串的序列：
        思路：遍历串，从root出发，如果存在串上序列对应的节点就走到串，否则就新建
     */
    public boolean insert(String s) {
        if(s == null) return false;
        char[] chs = s.toCharArray();
        TrieNode node = root;
        node.pass ++;
        for(char c : chs) {
            int index = c - 'a';
            if(node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node.pass ++;
            node = node.nexts[index];
        }
        node.end ++;
        return true;
    }

    public boolean delete(String s) {
        if(s == null || search_word(s) < 1) return false;
        char[] chs = s.toCharArray();
        TrieNode node = root;
        node.pass --;
        for(char c : chs) {
            TrieNode next = node.nexts[c - 'a'];
            if(--next.pass == 0) {
                node.nexts[c - 'a'] = null;
                // C++需要手动释放内存；Java代码在此处直接返回即可
            }
            node = next;
        }
        node.end --;
        return true;
    }

    public int search_word(String s) {
        if(s == null) return 0;
        char[] chs = s.toCharArray();
        TrieNode node = root;
        for(char c : chs) {
            TrieNode next = node.nexts[c - 'a'];
            if(next == null) return 0;
            node = next;
        }
        return node.end;
    }

    public int search_prefix(String s) {
        if(s == null) return 0;
        char[] chs = s.toCharArray();
        TrieNode node = root;
        for(char c : chs) {
            TrieNode next = node.nexts[c - 'a'];
            if(next == null) return 0;
            node = next;
        }
        return node.pass;
    }

    public TrieTree() {
        root = new TrieNode();
    }
}

class Demo {
    public static void main(String[] args) {
        TrieTree trie = new TrieTree();
        System.out.println(trie.insert("abc"));
        System.out.println(trie.insert("abde"));
        System.out.println(trie.insert("aegfg"));
        System.out.println(trie.search_prefix("a"));
        System.out.println(trie.search_word("abc"));
        System.out.println(trie.delete("abc"));
        System.out.println(trie.search_word("abc"));
    }
}

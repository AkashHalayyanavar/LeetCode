class TrieNode {
    TrieNode[] child = new TrieNode[26];
    boolean eow = false;
    int count = 0;
    char val;

    TrieNode (char ch) {
        val = ch;
    }
}

class Solution {

    void populate(TrieNode root, String str) {

        for (char ch: str.toCharArray()) {
            int index = ch - 'a';

            if (root.child[index] == null) {
                TrieNode node = new TrieNode(ch);
                root.child[index] = node;
                root.count++;
            }
            root = root.child[index];
        }

        root.eow = true;
    }

    String getCommonPrefix(TrieNode root) {
        StringBuilder sb = new StringBuilder();

        // no common prefix case
        if (root.count != 1)
            return "";

        while (root!=null && root.count == 1 && root.eow == false) {
            for (int i=0; i<26; i++) {
                if (root.child[i] != null) {
                    sb.append(root.child[i].val);
                    root = root.child[i];
                    break;
                }
            }
        }

        return sb.toString();
            
    }

    public String longestCommonPrefix(String[] strs) {
        
        TrieNode root = new TrieNode('/');

        for (String str: strs) {
            populate(root, str);
        }

        return getCommonPrefix(root);
    }
}
import java.util.Arrays;
import java.util.Comparator;

//给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
//例如，如果这个列表是 ["time", "me", "bell"]
// 我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。

/*
class Comp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int N1 = o1.length();
        int N2 = o2.length();
        for (int i = 0; i < Math.min(N1, N2); i++) {
            char c1 = o1.charAt(N1 - 1 - i);
            char c2 = o2.charAt(N2 - 1 - i);
            int c = Character.compare(c1, c2);
            if (c != 0) {
                return c;
            }
        }
        //一个单词中包含另一个单词
        return Integer.compare(N1, N2);
    }
}
public class MinimumLengthEncoding {
    public static int minimumLengthEncoding(String[] words) {
        int len=words.length;
        //逆序字典序排列  me time bell
        Arrays.sort(words,new Comp());

        int res = 0;
        for (int i = 0; i < len; i++) {
            if (i+1 < len && words[i+1].endsWith(words[i])) {
                // 当前单词是下一个单词的后缀，丢弃
            } else {
                res += words[i].length() + 1; // 单词加上一个 '#' 的长度
            }
        }
        return res;
    }
    */


class TrieNode {
    char val;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
}

public class MinimumLengthEncoding {
    public static int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }
    public static void main(String[] args) {
        String[] words={"time","me","bell"};
        System.out.println(minimumLengthEncoding(words));
    }
}

// 定义tire
class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode cur = root;
        boolean isNew = false;
        // 倒着插入单词
        for (int i = word.length() - 1; i >= 0; i--) {
            //e:101     101-97=5
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                isNew = true; // 是新单词
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew? word.length() + 1: 0;
    }
}

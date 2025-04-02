package labuladong._1_经典数据结构算法.手把手刷数组算法.数组双指针经典题;

// https://leetcode.cn/problems/reverse-words-in-a-string/description/
public class _151_反转字符串中的单词 {

    // 思路：先把整个字符串进行翻转，再把每个单词中的字母翻转
    public String reverseWords11(String s) {
        // 多余的空格删掉，单词之间保留一个空格
        // 末尾有空格删掉
        // 先整体翻转
        // 再把每个单词翻转

        // 因此我们需要一个函数，对一个字符串[i, j]范围内的字符串翻转
        return null;
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 先清洗一下数据，把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                // 单词中的字母/数字
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 单词之间保留一个空格
                sb.append(' ');
            }
        }
        if (sb.isEmpty()) {
            return "";
        }
        
        // 末尾如果有空格，清除之
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 清洗之后的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n; ) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    // chars[i..j] 是一个单词，翻转之
                    reverse(chars, i, j);
                    // 把 i 置为下一个单词的首字母
                    i = j + 2;
                    break;
                }
            }
        }
        // 最后得到题目想要的结果
        return new String(chars);
    }

    // 翻转 arr[i..j]
    void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}

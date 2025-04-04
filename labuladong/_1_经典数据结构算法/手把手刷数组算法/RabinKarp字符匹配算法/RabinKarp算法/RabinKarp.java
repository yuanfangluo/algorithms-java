package labuladong._1_经典数据结构算法.手把手刷数组算法.RabinKarp字符匹配算法.RabinKarp算法;

public class RabinKarp {
    // Rabin-Karp 指纹字符串查找算法
    int rabinKarp(String txt, String pat) {
        // 位数
        int L = pat.length();
        // 进制（只考虑 ASCII 编码）
        int R = 256;
        // 取一个比较大的素数作为求模的除数
        long Q = 1658598167;
        // R^(L - 1) 的结果
        long RL = 1;
        for (int i = 1; i <= L - 1; i++) {
            // 计算过程中不断求模，避免溢出
            RL = (RL * R) % Q;
        }
        // 计算模式串的哈希值，时间 O(L)
        long patHash = 0;
        for (int i = 0; i < pat.length(); i++) {
            patHash = (R * patHash + pat.charAt(i)) % Q;
        }

        // 滑动窗口中子字符串的哈希值
        long windowHash = 0;

        // 滑动窗口代码框架，时间 O(N)
        int left = 0, right = 0;
        while (right < txt.length()) {
            // 扩大窗口，移入字符
            windowHash = ((R * windowHash) % Q + txt.charAt(right)) % Q;
            right++;

            // 当子串的长度达到要求
            if (right - left == L) {
                // 根据哈希值判断是否匹配模式串
                if (windowHash == patHash) {
                    // 当前窗口中的子串哈希值等于模式串的哈希值
                    // 还需进一步确认窗口子串是否真的和模式串相同，避免哈希冲突
                    if (pat.equals(txt.substring(left, right))) {
                        return left;
                    }
                }
                // 缩小窗口，移出字符
                windowHash = (windowHash - (txt.charAt(left) * RL) % Q + Q) % Q;
                // X % Q == (X + Q) % Q 是一个模运算法则
                // 因为 windowHash - (txt[left] * RL) % Q 可能是负数
                // 所以额外再加一个 Q，保证 windowHash 不会是负数

                left++;
            }
        }
        // 没有找到模式串
        return -1;
    }
}

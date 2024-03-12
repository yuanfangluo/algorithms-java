package LeetCode._2_数组._1_双指针._1_快慢指针._2_滑动窗口;

/*
* https://leetcode.cn/problems/longest-repeating-character-replacement/description/?show=1
* 1. 什么时候扩大窗口？
* 当可替换次数大于0，扩大窗口，所有进入窗口的字符都进行替换，使得窗口内的所有元素都是重复的
* 2. 什么时候缩小窗口？
* 当可替换次数小于0时，缩小窗口，空余出可替换次数，以便扩大窗口
* 3. 什么时候得到一个合法的答案？
* 只要可替换次数大于等于0，窗口中的字符串都是重复的，我们想求的是一个最大窗口长度
* */
public class _424_替换后的最长重复字符 {
    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));
    }
    public static int characterReplacement(String s, int k) {
        // 统计窗口中每个字符的出现次数
        int[] windowCharCount = new int[26];
        // 记录窗口中字符的最多重复次数

        // 记录这个值的意义在于，最划算的替换方法肯定是把其他字符替换成出现次数最多的那个字符

        // 所以窗口大小减去 windowMaxCount 就是所需的替换次数
        int windowMaxCount = 0;
        // 记录结果长度
        int res = 0;

        int left = 0, right = 0;
        // 开始滑动窗口模板

        while (right < s.length()) {
            // 扩大窗口
            int index = s.charAt(right) - 'A';
            windowCharCount[index]++;
            windowMaxCount = Math.max(windowMaxCount, windowCharCount[index]);
            right++;

            while (right - left - windowMaxCount > k) {
                // 缩小窗口
                int idx = s.charAt(left) - 'A';
                windowCharCount[idx]--;
                left++;
                // 这里不用更新 windowMaxCount
                // 因为只有 windowMaxCount 变得更大的时候才可能获得更长的重复子串，才会更新 res
            }
            // 此时一定是一个合法的窗口
            res = Math.max(res, right - left);
        }
        return res;
    }
}

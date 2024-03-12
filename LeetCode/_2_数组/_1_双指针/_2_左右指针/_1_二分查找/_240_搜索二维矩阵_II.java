package LeetCode._2_数组._1_双指针._2_左右指针._1_二分查找;

/*
* https://leetcode.cn/problems/search-a-2d-matrix-ii/?show=1
* 如果真从左上角开始的话，就会发现无论向右还是向下走，元素大小都会增加，那么到底向右还是向下？
* 不确定，那只好用类似 动态规划算法 的思路穷举了。
*
* 但实际上不用这么麻烦，我们不要从左上角开始，而是从右上角开始，规定只能向左或向下移动。
* 你注意，如果向左移动，元素在减小，如果向下移动，元素在增大，
* 这样的话我们就可以根据当前位置的元素和 target 的相对大小来判断应该往哪移动，不断接近从而找到 target 的位置。
* 当然，如果你想从左下角开始，规定只能向右或向上移动也可以
* */
public class _240_搜索二维矩阵_II {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 初始化在右上角
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] < target) {
                // 需要大一点，往下移动
                i++;
            } else {
                // 需要小一点，往左移动
                j--;
            }
        }
        // while 循环中没有找到，则 target 不存在
        return false;
    }

}

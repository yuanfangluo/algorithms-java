package LeetCode._2_数组._1_双指针._2_左右指针._1_二分查找;

/*
* https://leetcode.cn/problems/search-a-2d-matrix/description/?show=1
*
* */
public class _74_搜索二维矩阵 {

    /*
    * 知识准备：根据二维数组的行数 m 和列数 n，二维数组的坐标 (i, j) 可以映射成一维的 index = i * n + j
    * 反过来也可以通过一维 index 反解出二维坐标 i = index / n, j = index % n
    *
    * 然后就可以根据二分搜索就可以了
    *
    * */

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 把二维数组映射到一维
        int left = 0, right = m * n - 1;
        // 前文讲的标准的二分搜索框架
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(get(matrix, mid) == target)
                return true;
            else if (get(matrix, mid) < target)
                left = mid + 1;
            else if (get(matrix, mid) > target)
                right = mid - 1;
        }
        return false;
    }

    // 通过一维坐标访问二维数组中的元素
    int get(int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        // 计算二维中的横纵坐标
        int i = index / n, j = index % n;
        return matrix[i][j];
    }

}

package huawei;

import java.util.Scanner;

public class 天然蓄水库 {
    /*
     * 1 8 6 2 5 4 8 3 7
     * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            String[] strs = line.split(" ");
            int[] heights = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                heights[i] = Integer.parseInt(strs[i]);
            }
            solution(heights);
        }
    }

    private static void solution(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int[] result = new int[3];

        int capacity = 0;
        while (left < right){
            int sum = 0;
            int lower = Math.min(heights[left], heights[right]);

            for (int i = left; i <= right; i++) {
                sum += Math.max(0, lower - heights[i]);
            }

            if (sum >= capacity){
                result = new int[]{left, right, sum};
                capacity = sum;
            }

            if (heights[right - 1] >= heights[left] && heights[right - 1] >= heights[right]) {
                right--;
            } else if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left + 1] >= heights[right] && heights[left + 1] >= heights[left]) {
                left++;
            }else {
                right--;
            }


        }

        if (result[2] == 0){
            System.out.println(0);
        } else {
            System.out.println(result[0] + " " + result[1] + ":" + result[2]);
        }
    }
}

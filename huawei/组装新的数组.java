package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class 组装新的数组 {
    /*
    * 2
    * 5
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            Integer[] arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]:: new);

            int m = Integer.parseInt(scanner.nextLine());
            System.out.println(solution(arr, m));
        }
    }

    private static int solution(Integer[] arr, int m) {
        Integer[] newArr = Arrays.stream(arr).filter(val -> val <= m).toArray(Integer[]::new);

        int min = newArr[0];
        return  dfs(newArr, 0, 0, min, m, 0);
    }

    private static int dfs(Integer[] arr, int index, int sum, int min, int m, int count) {
        if (sum > m){
            return count;
        }
        if (sum == m || (m - sum < min && m - sum >0)) {
            return count + 1;
        }

        for (int i = index; i < arr.length; i++) {
            count = dfs(arr, i, sum + arr[i], min, m, count);
        }
        return count;
    }


}

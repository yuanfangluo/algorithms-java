package huawei;

import java.util.*;

public class 找等值元素 {

    /*
    * 3
    * 5
    * 0 3 5 4 2
    * 2 5 7 8 3
    * 2 5 4 2 4
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int[][] matrix = new int[n][m];

            Map<Integer, List<int[]>> num_map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int num = scanner.nextInt();
                    matrix[i][j] = num;

                    // 将坐标转为数组
                    int[] pos = {i, j};
                    List<int[]> tmpList;
                    if (num_map.containsKey(num)){
                        tmpList = num_map.get(num);
                    } else {
                        tmpList = new ArrayList<>();
                    }
                    tmpList.add(pos);
                    num_map.put(num, tmpList);
                }
            }

            List<List<Integer>> resList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> tmp_list = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    int num = matrix[i][j];
                    List<int[]> pos_list = num_map.get(num);

                    if (pos_list.size() == 1) { // 无相等值
                        tmp_list.add(-1);
                        continue;
                    }

                    int min_dis = Integer.MAX_VALUE;

                    for (int k = 0; k < pos_list.size(); k++) {
                        int[] pos = pos_list.get(k);
                        int distance = Math.abs(pos[0] - i) + Math.abs(pos[1] - j);

                        // 距离为0则跳过
                        if (distance == 0){
                            continue;
                        }
                        min_dis = Math.min(min_dis, distance);
                    }
                    tmp_list.add(min_dis);
                }
                resList.add(tmp_list);
            }
            System.out.println(resList);
        }
    }
}

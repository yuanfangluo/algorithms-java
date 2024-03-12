package huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class 无向图染色 {

    /*
    * 4 4
    * 1 2
    * 2 4
    * 3 4
    * 1 3
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt(); // 节点数
            int n = scanner.nextInt(); // 边数

            // 构造输入数据结构
            ArrayList<ArrayList<Integer>> edgeArray = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> singleEdge = new ArrayList<>();
                singleEdge.add(scanner.nextInt());
                singleEdge.add(scanner.nextInt());
                edgeArray.add(singleEdge);
            }

            int count = 0;
            // 遍历所有可能的组合，举例：10001 ： i的二进制表达
            for (int i = 0; i < (1 << m); i++) {
                boolean flag = true;

                for (int j = 0; j < n; j++) {
                    // 检测所有的边相连的是否同为红色
                    if (((i >> edgeArray.get(j).get(0)) & 1) == 1 && ((i >> edgeArray.get(j).get(1)) & 1) == 1){
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    count++;
                }

            }
            System.out.println(count);
        }
    }

    private static boolean checkRed(int p) {
        return (p & 1) == 1;
    }

}

package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 静态扫描最优成本 {
    /*
    * 5
    * 1 2 2 1 2 3 4
    * 1 1 1 1 1 1 1
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            int m = scanner.nextInt();
            scanner.nextLine();
            String idsStr = scanner.nextLine();
            String sizesStr = scanner.nextLine();
            int res = solution(m, idsStr, sizesStr);
            System.out.println(res);

        }
    }

    private static int solution(int m, String idsStr, String sizesStr) {
        // 扫描文件id的次数
        Map<Integer, Integer> idCost = new HashMap<>();
        // 扫描文件id的size
        Map<Integer, Integer> idSize = new HashMap<>();
        String[] ids = idsStr.split(" ");
        String[] sizes = sizesStr.split(" ");
        for (int i = 0; i < ids.length; i++) {
            int id = Integer.parseInt(ids[i]);
            int size = Integer.parseInt(sizes[i]);

            idCost.put(id, idCost.getOrDefault(id, 0) + 1);
            idSize.put(id, size);
        }

        int sum = 0;
        for (Integer id: idCost.keySet()) {

            int total = idCost.get(id) * idSize.get(id);

            idCost.put(id, Math.min(total, m + idSize.get(id)));

            sum += idCost.get(id);
        }
        return sum;
    }

}

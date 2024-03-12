package huawei;

import java.util.*;

public class 快递投放 {
    /*
    * 4 2
    * 1 a c
    * 2 a c
    * 3 b c
    * 4 a c
    * a b 1
    * a c 2
    * */
    public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)){
        int m = scanner.nextInt(); // 包裹数量
        int n = scanner.nextInt(); // 两个道路之间不能送的包裹
        scanner.nextLine();
        String[] packages = new String[m];
        for (int i = 0; i < m; i++) {
            packages[i] = scanner.nextLine();
        }

        String[] noPackages = new String[n];

        for (int i = 0; i < n; i++) {
            noPackages[i] = scanner.nextLine();
        }

        List<String> res = solution(m, n, packages, noPackages);
        System.out.println(res);
    }
    }

    private static List<String> solution(int m, int n, String[] packages, String[] noPackages) {
        /*
         * key: 包裹
         * value：运输路径
         * */
        Map<String, String> mapPackage = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String[] pkgs = packages[i].split(" ");
            mapPackage.put(pkgs[0], pkgs[1] + pkgs[2]);
        }
        /*
         * key: 路径
         * value：被拦截的包裹组
         * */
        Map<String, List<String>> mapNo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 运输路径
            String[] strs = noPackages[i].split(" ");
            // 包裹
            List<String> noList = new ArrayList<>();
            for (int j = 2; j < strs.length; j++) {
                noList.add(strs[j]);
            }
            mapNo.put(strs[0] + strs[1], noList);
        }

        List<String> resList = new ArrayList<>();

        for (Map.Entry<String, List<String>> map: mapNo.entrySet()
        ) {
            String key = map.getKey();
            List<String> list = map.getValue();
            for (String s: list
            ) {
                if (key.equals(mapPackage.get(s))) { // 被拦截的包裹
                    resList.add(s);
                }

            }
        }
         return resList;
    }

}

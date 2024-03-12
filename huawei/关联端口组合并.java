package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class 关联端口组合并 {
    /*
    *
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();
            scanner.nextLine();
            String[] portGroups = new String[m];
            for (int i = 0; i < m; i++) {
                portGroups[i] = scanner.nextLine();
            }
            System.out.println(solution(m, portGroups));
        }
    }

    private static List solution(int m, String[] portGroups) {
        List<TreeSet<Integer>> list = new ArrayList<>();
        for (String portGroup: portGroups
             ) {
            String[] split = portGroup.split(",");
            TreeSet<Integer> ports = new TreeSet<>();
            for (String s: split
                 ) {
                ports.add(Integer.parseInt(s));
            }
            list.add(ports);
        }

        // 检查合并
        while (merge(list));

        return list;

    }

    private static boolean merge(List<TreeSet<Integer>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                TreeSet<Integer> group1 = list.get(i);
                TreeSet<Integer> group2 = list.get(j);
                boolean same = checkSamePortGreaterTwo(group1, group2);
                if (same){
                    group1.addAll(group2);
                    list.remove(j);
                    return  true;
                }
            }
        }

        return false;
    }

    private static boolean checkSamePortGreaterTwo(TreeSet<Integer> group1, TreeSet<Integer> group2) {
    int count = 0;
        for (Integer i:
             group1) {
            if (group2.contains(i)){
                count ++;
            }
            if (count >= 2){
                return true;
            }
        }
    return false;
    }
}

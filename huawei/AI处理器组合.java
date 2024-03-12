package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AI处理器组合 {
    /*
    * [0,1,4,5,6,7]
    * 1
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
//            Integer[] arr = Arrays.stream(scanner.nextLine().split("[\\[\\],\\s]"))
//                    .filter(str -> !("".equals(str)))
//                    .map(Integer::parseInt)
//                    .toArray(Integer[]::new);

            String line = scanner.nextLine();
            String[] strs = line.substring(1, line.length() - 1).split(",");
            int[] ints = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                ints[i] = Integer.parseInt(strs[i]);
            }

            String num = scanner.next();
            System.out.println(solution(ints, num));
        }
    }

    private static String  solution(int[] arr, String num) {
        ArrayList<Integer> link1 = new ArrayList<>();
        ArrayList<Integer> link2 = new ArrayList<>();

        Arrays.sort(arr);

        for (Integer e:
             arr) {
            if (e < 4) {
                link1.add(e);
            } else {
                link2.add(e);
            }
        }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int len1 = link1.size();
        int len2 = link2.size();

        switch (num) {
            case "1":
                if (len1 == 1 || len2 == 1){
                    if (len1 == 1) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 1) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 3 || len2 == 3) {
                    if (len1 == 3) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 3) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 2 || len2 == 2) {
                    if (len1 == 2) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 2) dfs(link2, 0, 1, new ArrayList<>(), ans);
                } else if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) dfs(link1, 0, 1, new ArrayList<>(), ans);
                    if (len2 == 4) dfs(link2, 0, 1, new ArrayList<>(), ans);
                }
                break;
            case "2":
                if (len1 == 2 || len2 == 2) {
                    if (len1 == 2) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 2) dfs(link2, 0, 2, new ArrayList<>(), ans);
                } else if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 4) dfs(link2, 0, 2, new ArrayList<>(), ans);
                } else  if (len1 == 3 || len2 == 3) {
                    if (len1 == 3) dfs(link1, 0, 2, new ArrayList<>(), ans);
                    if (len2 == 3) dfs(link2, 0, 2, new ArrayList<>(), ans);
                }
                break;
            case "4":
                if (len1 == 4 || len2 == 4) {
                    if (len1 == 4) ans.add(link1);
                    if (len2 == 4) ans.add(link2);
                }
                break;
            case "8":
                if (len1 == 4 || len2 == 4) {
                    ans.add(Stream.concat(link1.stream(), link2.stream()).collect(Collectors.toCollection(ArrayList<Integer>::new)));
                }
                break;
        }
        return ans.toString();
    }

    private static void dfs(
            ArrayList<Integer> arr,
            int index,
            int level,
            ArrayList<Integer> path,
            ArrayList<ArrayList<Integer>> res) {
        if (path.size() == level){
            res.add((ArrayList<Integer>) path.clone());
        }

        for (int i = index; i < arr.size(); i++) {
            path.add(arr.get(i));
            dfs(arr, i + 1, level, path, res);
            path.remove(path.size() - 1);
        }

    }
}

package huawei;

import java.util.*;

public class 九宫格 {
    /*
    * 75 36 10 4 30 225 90 25 12
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            Integer[] arr = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt).toArray(Integer[]::new);
            solution(arr);
        }
    }

    private static void solution(Integer[] arr) {
        boolean[] used = new boolean[arr.length];
        LinkedList<Integer> path = new LinkedList<>();
        ArrayList<Integer[]> res = new ArrayList<>();

        dfs(arr, used, path, res);

        res.sort((a, b) -> {
            for (int i = 0; i < 9; i++) {
                if (!Objects.equals(a[i], b[i])) return a[i] - b[i];
            }
            return 0;
        });

        for (Integer[] re: res
             ) {
            StringJoiner joiner = new StringJoiner(" ");
            for (Integer i: re
                 ) {
                joiner.add(i + "");
            }
            System.out.println(joiner);
        }
    }

    private static void dfs(
            Integer[] arr,
            boolean[] used,
            LinkedList<Integer> path,
            ArrayList<Integer[]> res) {
        if (path.size() == arr.length) {
            if (check(path)) {
                Integer[] a = path.toArray(new Integer[0]);
                res.add(a);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {
                path.add(arr[i]);
                used[i] = true;
                dfs(arr, used, path, res);
                used[i] = false;
                path.removeLast();
            }
        }

    }

    private static boolean check(LinkedList<Integer> path) {
        Integer[] a = path.toArray(new Integer[0]);
        int r1 = a[0] * a[1] * a[2];
        int r2 = a[3] * a[4] * a[5];
        if (r1 != r2) return false;

        int r3 = a[6] * a[7] * a[8];
        if (r1 != r3) return false;

        int c1 = a[0] * a[3] * a[6];
        if (r1 != c1) return false;

        int c2 = a[1] * a[4] * a[7];
        if (r1 != c2) return false;

        int c3 = a[2] * a[5] * a[8];
        if (r1 != c3) return false;

        int s1 = a[0] * a[4] * a[8];
        if (r1 != s1) return false;

        int s2 = a[2] * a[4] * a[6];
        return r1 == s2;
    }
}

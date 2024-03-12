package huawei;

import java.util.*;

public class 字母组合 {

    /*
    * 78
    * ux
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            Integer[] arr = Arrays.stream(scanner.next().split(""))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            String filter = scanner.next();
            System.out.println(solution(arr, filter));
        }
    }

    private static final String[] KB = {"abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uv", "wx", "yz"};

    private static String solution(Integer[] arr, String filter) {
        String[] newArr = Arrays.stream(arr).map(val -> KB[val]).toArray(String[]::new);
//        System.out.println(Arrays.toString(newArr));

        char[] cArr = filter.toCharArray();
        Arrays.sort(cArr);
        filter = new String(cArr);

        ArrayList<String> res = new ArrayList<>();
        dfs(newArr, 0, new LinkedList<>(), res, filter);

        StringJoiner sj = new StringJoiner(" ", "","");

        for (String str: res
             ) {
            sj.add(str);
        }

        return sj.toString();
    }

    private static void dfs(String[] arr, int index, LinkedList<Character> path, ArrayList<String> res, String filter) {
        if (index == arr.length){
            if (!include(path, filter)){
                StringBuilder sb = new StringBuilder();
                for (Character c: path
                     ) {
                    sb.append(c);
                }
                res.add(sb.toString());
            }
            return;
        }

        for (int i = 0; i < arr[index].length(); i++) {
            path.addLast(arr[index].charAt(i));
            dfs(arr, index + 1, path, res, filter);
            path.removeLast();
        }

    }

    private static boolean include(LinkedList<Character> path, String filter) {
        StringBuilder sb = new StringBuilder();
        path.stream().sorted().forEach(sb::append);
        String src = sb.toString();
        if (filter.length() > src.length()) return false;

        int i = 0;
        int j = 0;
        while (i < src.length() && j < filter.length()) {
            if (src.charAt(i) == filter.charAt(j)) j++;
            i++;
        }

        return  j == filter.length();
    }

}
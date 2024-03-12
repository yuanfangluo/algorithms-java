package huawei;

import java.util.*;
import java.util.stream.Collectors;

public class 区间连接器 {

    /*
    * [1,10],[15,20],[18,30],[33,40]
    * [5,4,3,2]
    *
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){

            String f = scanner.nextLine();

            Integer[][] ranges = Arrays.stream(f.substring(1, f.length() - 1).split("],\\["))
                    .map(
                            str->Arrays.stream(str.split(",")).map(Integer::parseInt).toArray(Integer[]::new)
                    ).toArray(Integer[][]::new);
            String s = scanner.nextLine();
            List<Integer> connects = Arrays.stream(s.substring(1, s.length() - 1).split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println(solution(ranges, connects));

        }

    }

    private static int solution(Integer[][] ranges, List<Integer> connects) {
        Arrays.sort(ranges, Comparator.comparingInt(a->a[0]));

        LinkedList<Integer[]> mergeRanges = new LinkedList<>();
        mergeRanges.addLast(ranges[0]);

        LinkedList<Integer> diffs = new LinkedList<>();
        for (int i = 1; i < ranges.length; i++) {
            Integer[] last = mergeRanges.getLast();
            int s1 = last[0];
            int e1 = last[1];

            Integer[] range = ranges[i];
            int s2 = range[0];
            int e2 = range[1];

            if (s2 <= e1){
                mergeRanges.removeLast();
                mergeRanges.addLast(new Integer[]{s1, Math.max(e1, e2)});
            } else {
                diffs.addLast(s2 - e1);
                mergeRanges.addLast(range);
            }
        }

        diffs.sort((a, b) -> b-a);
        connects.sort((a, b) -> b -a);

        while (connects.size() >0 && diffs.size() >0){
            if (connects.remove(connects.size() -1) >= diffs.getLast()) {
                diffs.removeLast();
            }
        }
        return diffs.size() + 1;
    }
}

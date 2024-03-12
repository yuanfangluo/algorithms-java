package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 星际篮球争霸赛 {
    /*
    * 9
    * 5 2 1 5 2 1 5 2 1
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int t = scanner.nextInt(); // 得分的分钟数
            int[] scores = new int[t]; // 每一时刻的得分数
            for (int i = 0; i < scores.length; i++) {
                scores[i] = scanner.nextInt();
            }
            
            int score = solution(scores);
            System.out.println(score);
            
        }
    }

    private static int solution(int[] scores) {
        int sum = 0;
        List<Integer> myList = new ArrayList<>();
        for (int score: scores
             ) {
            sum += score;
            myList.add(score);
        }

        for (int i = scores.length; i > 0; i--) {
            if (sum % i == 0){
               if (exist(myList, sum / i, sum / i)){
                   return sum / i;
               }
            }
        }
        return sum;
    }

    private static boolean exist(List<Integer> rootList, int num, int orgNum) {
        if (rootList.size() == 0 && num == orgNum){
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < rootList.size(); i++) {
            List<Integer> subList = new ArrayList<>();

            for (int j = 0; j < rootList.size(); j++) {
                if (j != i){
                    subList.add(rootList.get(j));
                }
            }

            if (rootList.get(i) == num){
                flag = flag || exist(subList, orgNum, orgNum);
            } else if (rootList.get(i) < num) {
                flag = flag || exist(subList, num - rootList.get(i), orgNum);
            }
        }
        return flag;
    }


}

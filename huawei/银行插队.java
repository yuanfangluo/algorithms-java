package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 银行插队 {
    /*
    * 4
    * a 1 3
    * a 2 2
    * a 3 2
    * p
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){

            int n = scanner.nextInt();

            List<List<Integer>> a = new ArrayList<>();

            for (int i = 0; i < 6; i++) {
                List<Integer> b = new ArrayList<>();
                a.add(b);
            }

            for (int i = 0; i < n; i++) {
                String op = scanner.next();
                if (op.equals("a")){
                    int x, y;
                    x = scanner.nextInt(); // 客户编号
                    y = scanner.nextInt(); // 优先级
                    a.get(y).add(x);
                }else {
                    for (int j = 1; j <= 5; j++) {
                        if (a.get(j).size() != 0){
                            System.out.println(a.get(j).remove(0));
                            break;
                        }
                    }
                }
            }
        }
    }
}

package huawei;

import java.util.*;

public class 最小调整顺序次数 {
    /*
    * 可以从头部添加，也可以尾部添加，但是删除必须是头部删除
    * 求最小调整次数
    * 5
    * h a 1
    * t a 2
    * r
    * h a 3
    * t a 4
    * h a 5
    * r
    * r
    * r
    * r
    * */
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt(); // 数字范围1-n，添加n次，只不过不知道三头部添加还是尾部添加
            String[] ops = new String[n << 1];
            scanner.nextLine();
            for (int i = 0; i < (n << 1); i++) {
                ops[i] = scanner.nextLine();
            }

            Deque<Integer> deque = new LinkedList<>();
            int start = 1; // 开始
            int count = 0; // 移动次数
            for (int i = 0; i < ops.length; i++) {
                String str = ops[i];
                // 如果是移除
                if (str.equals("r")){
                    if (!deque.isEmpty()){
                        if (deque.peekFirst() == start) {
                            // 如果队列不为空，且移除来的就是start，那么可以移除
                            deque.removeFirst();
                        } else {
                            // 此时需要调整顺序了
                            // tmp用来存放头部需要调整的元素
                            List<Integer> tmp = new ArrayList<>();
                            while (!deque.isEmpty()){
                                tmp.add(deque.removeFirst());
                            }

                            Collections.sort(tmp);

                            for (Integer integer: tmp
                                 ) {
                                deque.addLast(integer);
                            }
                            deque.removeFirst();
                            count++;
                        }
                        start++;
                    }
                    continue;

                }

                // 添加指令
                String[] strs = str.split(" ");

                if (strs[1].equals("a")){
                    if (strs[0].equals("h")){
                        deque.addFirst(Integer.parseInt(strs[2]));
                    } else {
                        // 尾部
                        deque.addLast(Integer.parseInt(strs[2]));
                    }
                }
                System.out.println(deque);
            }
            System.out.println(count);
        }
    }
}

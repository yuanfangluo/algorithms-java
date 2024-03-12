package huawei;

import java.util.*;

public class 连接器 {
    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
   static ArrayList<Node> a = new ArrayList<>();
    static ArrayList<Node> b = new ArrayList<>();

    /*
    * 使用连接器后，最少的区间数
    * [1,10],[15,20],[18,30],[33,40]
    * [5,4,3,2]
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            String s = scanner.nextLine();
            s = s.substring(1, s.length() - 1);
            System.out.println(s);
            String[] sp = s.split("\\]\\,\\["); // 以 ],[ 为分割点
            System.out.println(Arrays.toString(sp));
            for (String value: sp
                 ) {
                String[] ss = value.split(",");
                int start = Integer.parseInt(ss[0]);
                int end = Integer.parseInt(ss[1]);
                a.add(new Node(start, end));
            }

            a.sort((o1, o2) -> {
                if (o1.start == o2.start){
                    return o1.end - o2.end;
                }
                return o1.start - o2.start;
            });

            Node cur = new Node(a.get(0).start, a.get(0).end);

            for (int i = 1; i < a.size(); i++) {
                if (a.get(i).start <= cur.end){
                    cur.end = Math.max(cur.end, a.get(i).end);
                 } else {
                    b.add(new Node(cur.start, cur.end));
                    cur = new Node(a.get(i).start, a.get(i).end);
                }
            }
            b.add(new Node(cur.start, cur.end));

            a = b;

            // 处理输入的第二行字符串
            s = scanner.nextLine();
            s = s.substring(1, s.length() -1);
            sp = s.split(",");

            // 连接器
            ArrayList<Integer> c = new ArrayList<>();
            for (String value: sp
                 ) {
                c.add(Integer.parseInt(value));
            }
            Collections.sort(c);

            // 后一个点的开始 - 前一个点的结束
            ArrayList<Integer> d = new ArrayList<>();
            for (int i = 0; i < a.size() - 1; i++) {
                d.add(a.get(i+1).start - a.get(i).end);
            }

            Collections.sort(d);

            LinkedList<Integer> connetcs = new LinkedList<>(c);

            LinkedList<Integer> gaps = new LinkedList<>(d);

            int res = gaps.size() + 1;

            while (true){
                if (connetcs.isEmpty()){
                    break;
                }

                if (gaps.isEmpty()){
                    break;
                }

                if (connetcs.peek() >= gaps.peek()){
                    connetcs.removeFirst();
                    gaps.removeFirst();
                    res--;
                } else {
                    connetcs.removeFirst();
                }
            }

            System.out.println(res);

        }
    }


}

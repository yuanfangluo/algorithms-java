package huawei;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最优高铁城市建设方案 {
    /*
    *
    * 3 3 0 // 城市数量、两城市间成本的数量，必建高铁的城市列表
    * 1 2 10
    * 1 3 100
    * 2 3 50
    *
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int k = scanner.nextInt();

            Edge[] edges = new Edge[m];

            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                int cost = scanner.nextInt();
                edges[i] = new Edge(from, to, cost);

                StringBuilder key = new StringBuilder();
                key.append(edges[i].from);
                key.append(edges[i].to);
                map.put(key.toString(), i);

                key = new StringBuilder();
                key.append(edges[i].to);
                key.append(edges[i].from);
                map.put(key.toString(), i);

            }

            // 然后是必须要选择的边(固定建设的两城市高铁)
            int res = 0;
            Uniform uf = new Uniform(n + 1);

            boolean[] visit = new boolean[n];

            int egs = 0;

            for (int j = 0; j < k; j++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                StringBuilder key = new StringBuilder();
                key.append(from);
                key.append(to);
                uf.union(from, to);

                int id = map.get(key.toString());
                res += edges[id].cost;
                visit[id] = true;
                egs++;
            }

            PriorityQueue<Edge> queue = new PriorityQueue<>((e1, e2) -> e1.cost - e2.cost);

            for (int i = 0; i < n; i++) {
                if (!visit[i]) queue.offer(edges[i]);
            }

            while (!queue.isEmpty()){
                Edge cur = queue.poll();
                if (uf.check(cur.from, cur.to)) continue;
                res += cur.cost;
                uf.union(cur.from, cur.to);
                egs++;
            }

            if (egs == n - 1){
                System.out.println(res);
            } else {
                System.out.println(-1);
            }
        }

    }

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static class Uniform{
        int[] root;

        public Uniform(int n) {
            root = new int[n];
            for (int i = 0; i < n; i++) {
                root[i] = i;
            }
        }

        public int find(int x) {
            if (root[x] == x) return root[x];
            return root[x] = find(root[x]);
        }

        public void union(int x, int y){
            int rx = find(x);
            int ry = find(y);
            if (rx != ry){
                root[rx] = ry;
            }
        }

        public boolean check(int x, int y) {
            return find(x) == find(y);
        }
    }

}

package huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 查找二叉树节点 {
    static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)){
        int size = Integer.parseInt(scanner.nextLine());
        int[][] nodes = new int[size][];

        for (int i = 0; i < size; i++) {
            int[] split = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(it -> it).toArray();
            nodes[i] = split;
        }

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        String res = solution(nodes, x, y);
        System.out.println(res);
    }
    }

    private static String solution(int[][] nodes, int x, int y) {
        if (x < 0 || y < 0) {
            return "{}";
        }
        Node root = createNode(nodes, 0);

        dfs(root, 0, x, y);

        if (y >= res.size()){
            return "{}";
        }

        return "{" + res.get(y) + "}";
    }

    private static void dfs(Node node, int height, int x, int y) {
        if (node == null){
            return;
        }

        if (height > x){
            return;
        }

        if (height == x){
            res.add(node.value);
        }

        for (int i = 0; i < node.nexts.size(); i++) {
            dfs(node.nexts.get(i), height + 1, x, y);
        }

    }

    private static Node createNode(int[][] nodes, int index) {
        Node node = new Node(nodes[index][0]);
        for (int i = 1; i < nodes[index].length; i++) {
            node.nexts.add(createNode(nodes, nodes[index][i]));
        }
        return node;
    }


    static class Node {
        int value;
        ArrayList<Node> nexts = new ArrayList<>();

        public Node(int vale){
            this.value = vale;
        }
    }
}

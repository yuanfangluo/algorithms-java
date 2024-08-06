package huawei;

import java.util.LinkedList;
import java.util.Scanner;

public class 计算网格信号 {
    /*
    * 6 5
    * 0 0 0 -1 0 0 0 0 0 0 0 0 -1 4 0 0 0 0 0 0 0 0 0 0 -1 0 0 0 0 0
    * 0 0 0 -1 0
    * 0 0 0 0 0
    * 0 0 -1 4 0
    * 0 0 0 0 0
    * 0 0 0 0 -1
    * 0 0 0 0 0
    * 1 4
    * */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] matrix = new int[m][n];
            int[] src = new int[2];
            int[] dst = new int[2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                    if (matrix[i][j] > 0){
                        src[0] = i;
                        src[1] = j;
                    }
                }
            }
            dst[0] = scanner.nextInt();
            dst[1] = scanner.nextInt();
            int res = solution(matrix, src, dst);
            System.out.println(res);
        }
    }

   static class Block {
       int x;
       int y;
       int d;

       public Block(int x, int y, int d) {
           this.x = x;
           this.y = y;
           this.d = d;
       }
   }

    static LinkedList<Block> blocks = new LinkedList<>();

    static int[][] dic = {{0, 1}, {0, -1}, {1, 0}, {-1,0}};

    private static int solution(int[][] matrix, int[] src, int[] dst) {
        int x = src[0];
        int y = src[1];

        blocks.add(new Block(x, y, matrix[x][y]));

        while (blocks.size() > 0){
            Block block = blocks.removeFirst();
            diffuse(matrix, block.x, block.y, block.d);
        }

        return matrix[dst[0]][dst[1]];
    }

    private static void diffuse(int[][] matrix, int x, int y, int d) {
        for (int[] di: dic) {
            int newX = x + di[0], newY = y + di[1];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length) {
                int next = matrix[newX][newY];
                if (next == 0){
                    matrix[newX][newY] = d - 1;
                }
                if (d > 2 && next != -1){
                    blocks.add(new Block(newX, newY, d - 1));
                }
            }
        }
    }
}

package tesla;
import java.util.*;

class Solution {
    public boolean solution(String[] B) {
        int N = B.length;         // Number of rows
        int M = B[0].length();    // Number of columns
        
        // Directions for guards and movements
        int[][] DIRECTIONS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // Left, Right, Up, Down
        char[] GUARDS = {'<', '>', '^', 'v'};
        
        // Step 1: Create a board to mark watched cells
        boolean[][] watched = new boolean[N][M];
        int assassinRow = -1, assassinCol = -1; // Assassin's position
        
        // Parse the board
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char cell = B[i].charAt(j);
                if (cell == 'A') {
                    assassinRow = i;
                    assassinCol = j;
                } else if (cell == '<') {
                    markWatchedCells(watched, B, i, j, DIRECTIONS[0]); // Left
                } else if (cell == '>') {
                    markWatchedCells(watched, B, i, j, DIRECTIONS[1]); // Right
                } else if (cell == '^') {
                    markWatchedCells(watched, B, i, j, DIRECTIONS[2]); // Up
                } else if (cell == 'v') {
                    markWatchedCells(watched, B, i, j, DIRECTIONS[3]); // Down
                }
            }
        }
        
        // Step 2: Check if the assassin's starting position is already watched
        if (watched[assassinRow][assassinCol]) {
            return false; // Assassin is immediately spotted
        }
        
        // Step 3: BFS to check if the assassin can reach the bottom-right cell
        return bfs(B, watched, assassinRow, assassinCol, N, M);
    }
    
    private void markWatchedCells(boolean[][] watched, String[] B, int row, int col, int[] direction) {
        int N = B.length, M = B[0].length();
        int dr = direction[0], dc = direction[1];
        int r = row + dr, c = col + dc;
        while (r >= 0 && r < N && c >= 0 && c < M && B[r].charAt(c) != 'X' && B[r].charAt(c) != '<' && B[r].charAt(c) != '>' && B[r].charAt(c) != '^' && B[r].charAt(c) != 'v') {
            watched[r][c] = true;
            r += dr;
            c += dc;
        }
    }
    
    private boolean bfs(String[] B, boolean[][] watched, int startRow, int startCol, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        
        int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // Left, Right, Up, Down
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1];
            
            // If we've reached the bottom-right cell
            if (r == N - 1 && c == M - 1) {
                return true;
            }
            
            // Explore neighboring cells
            for (int[] move : moves) {
                int nr = r + move[0], nc = c + move[1];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && B[nr].charAt(nc) == '.' && !watched[nr][nc]) {
                    queue.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }
        
        return false; // Target not reachable
    }
}

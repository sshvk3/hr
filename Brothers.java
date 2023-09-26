import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Brothers {
    
    public static List<int[]> findNeighbors(int x, int y, int R, int C) {
        List<int[]> neighbors = new ArrayList<>();
        if (x > 0) {
            neighbors.add(new int[]{x - 1, y});
        }
        if (x < R - 1) {
            neighbors.add(new int[]{x + 1, y});
        }
        if (y > 0) {
            neighbors.add(new int[]{x, y - 1});
        }
        if (y < C - 1) {
            neighbors.add(new int[]{x, y + 1});
        }
        return neighbors;
    }

    public static int[][] simulateBattles(int N, int R, int C, int K, int[][] land) {
        for (int k = 0; k < K; k++) {
            int[][] newLand = new int[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    newLand[r][c] = land[r][c];
                }
            }

            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    List<int[]> neighbors = findNeighbors(r, c, R, C);
                    int attacker = land[r][c];
                    for (int[] neighbor : neighbors) {
                        int nr = neighbor[0];
                        int nc = neighbor[1];
                        if ((attacker + 1) % N == land[nr][nc]) {
                            newLand[nr][nc] = attacker;
                        }
                    }
                }
            }

            land = newLand;
        }

        return land;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int N = scanner.nextInt();
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int K = scanner.nextInt();
            if (N == 0) {
                break;
            }

            int[][] land = new int[R][C];
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    land[r][c] = scanner.nextInt();
                }
            }

            int[][] result = simulateBattles(N, R, C, K, land);

            for (int[] row : result) {
                for (int value : row) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}

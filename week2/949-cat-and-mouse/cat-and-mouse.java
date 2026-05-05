import java.util.*;

class Solution {

    int MOUSE_TURN = 0, CAT_TURN = 1;
    int DRAW = 0, MOUSE_WIN = 1, CAT_WIN = 2;

    public int catMouseGame(int[][] graph) {
        int n = graph.length;

        int[][][] color = new int[n][n][2];
        int[][][] degree = new int[n][n][2];

        Queue<int[]> q = new LinkedList<>();

        // compute degree
        for (int m = 0; m < n; m++) {
            for (int c = 0; c < n; c++) {
                degree[m][c][MOUSE_TURN] = graph[m].length;
                degree[m][c][CAT_TURN] = graph[c].length;

                for (int nei : graph[c]) {
                    if (nei == 0) {
                        degree[m][c][CAT_TURN]--; // cat cannot go to hole
                        break;
                    }
                }
            }
        }

        // terminal states
        for (int i = 1; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                color[0][i][t] = MOUSE_WIN;
                q.offer(new int[]{0, i, t, MOUSE_WIN});
            }
        }

        for (int i = 1; i < n; i++) {
            for (int t = 0; t < 2; t++) {
                color[i][i][t] = CAT_WIN;
                q.offer(new int[]{i, i, t, CAT_WIN});
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int m = cur[0], c = cur[1], t = cur[2], result = cur[3];

            for (int[] prev : getParents(m, c, t, graph)) {
                int pm = prev[0], pc = prev[1], pt = prev[2];

                if (color[pm][pc][pt] != 0) continue;

                if (pt == MOUSE_TURN && result == MOUSE_WIN ||
                    pt == CAT_TURN && result == CAT_WIN) {

                    color[pm][pc][pt] = result;
                    q.offer(new int[]{pm, pc, pt, result});
                } else {
                    degree[pm][pc][pt]--;
                    if (degree[pm][pc][pt] == 0) {
                        color[pm][pc][pt] = (pt == MOUSE_TURN) ? CAT_WIN : MOUSE_WIN;
                        q.offer(new int[]{pm, pc, pt, color[pm][pc][pt]});
                    }
                }
            }
        }

        return color[1][2][MOUSE_TURN];
    }

    private List<int[]> getParents(int m, int c, int t, int[][] graph) {
        List<int[]> res = new ArrayList<>();

        if (t == 0) { // mouse just moved
            for (int pc : graph[c]) {
                if (pc == 0) continue;
                res.add(new int[]{m, pc, 1});
            }
        } else { // cat just moved
            for (int pm : graph[m]) {
                res.add(new int[]{pm, c, 0});
            }
        }

        return res;
    }
}
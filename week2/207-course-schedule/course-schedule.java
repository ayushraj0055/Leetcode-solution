import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // build graph
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int req = pre[1];
            graph.get(req).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        // add all nodes with indegree 0
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            count++;

            for (int nei : graph.get(node)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}
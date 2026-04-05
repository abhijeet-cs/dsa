/*
Pattern: Topological Sort(Kahn's algorithm)
Problem: https://leetcode.com/problems/course-schedule-ii/
*/
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> finalOrder = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] inD = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) inD[prerequisites[i][0]]++;
        for (int i = 0; i < numCourses; i++) if (inD[i] == 0) q.add(i);

        while (!q.isEmpty()) {
            int u = q.poll();
            finalOrder.add(u);
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == u) {
                    inD[prerequisites[i][0]]--;
                    if (inD[prerequisites[i][0]] == 0) q.add(prerequisites[i][0]);
                }
            }
        }

        if (numCourses == finalOrder.size()) return finalOrder.stream().mapToInt(Integer::intValue).toArray();
        return new int[0];
    }
}

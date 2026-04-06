/*
Pattern: Min/Max heap
Problem: https://leetcode.com/problems/top-k-frequent-elements/
*/
class Solution {
    public static class Pair {
        int num;
        int f;
        Pair(int num, int f) {
            this.num = num;
            this.f = f;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.f - y.f);
        HashMap<Integer, Integer> m = new HashMap<>();

        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> e : m.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
            if (pq.size() > k) pq.poll();
        }

        int[] ans = new int[k];
        while (!pq.isEmpty()) ans[--k] = pq.poll().num;

        return ans;
    }
}

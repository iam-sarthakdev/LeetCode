import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        union(0, firstPerson, parent, rank);

        int i = 0;
        while (i < meetings.length) {
            int time = meetings[i][2];
            List<int[]> batch = new ArrayList<>();

            while (i < meetings.length && meetings[i][2] == time) {
                batch.add(meetings[i]);
                i++;
            }

            for (int[] m : batch) {
                union(m[0], m[1], parent, rank);
            }

            for (int[] m : batch) {
                if (find(m[0], parent) != find(0, parent)) {
                    parent[m[0]] = m[0];
                    parent[m[1]] = m[1];
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (find(j, parent) == find(0, parent)) res.add(j);
        }
        return res;
    }

    int find(int x, int[] parent) {
        if (parent[x] != x) parent[x] = find(parent[x], parent);
        return parent[x];
    }

    void union(int x, int y, int[] parent, int[] rank) {
        int px = find(x, parent);
        int py = find(y, parent);
        if (px == py) return;
        if (rank[px] < rank[py]) parent[px] = py;
        else if (rank[px] > rank[py]) parent[py] = px;
        else {
            parent[py] = px;
            rank[px]++;
        }
    }
}

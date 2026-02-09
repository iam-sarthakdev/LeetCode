class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int preres = pre[1];

            adj.get(preres).add(course);

            indegree[course]++;
        }
        int courseCompleted = 0;
        int[] res = new int[numCourses];
        int idx = 0;
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int course = q.poll();
            courseCompleted++;
            res[idx++] = course;

            for(int nextCourse : adj.get(course)){
                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0) q.add(nextCourse);
            }
        }
        return courseCompleted == numCourses ? res : new int[0];
    }
}
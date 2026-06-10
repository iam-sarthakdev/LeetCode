class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i= 0 ; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prereq = pre[1];

            adj.get(prereq).add(course);
            indegree[course]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0) q.add(i);
        }

        int completedCourse = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            completedCourse++;

            for(int nextCourse : adj.get(course)){
                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0) q.add(nextCourse);
            }
        }
        return completedCourse == numCourses;
    }
}
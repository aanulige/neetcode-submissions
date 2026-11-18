class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i  = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int finish = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            finish++;
            for(int nums : graph.get(cur)){
                if(--indegree[nums] == 0){
                    queue.offer(nums);
                }
            }
        }
        return finish == numCourses;
    }
}

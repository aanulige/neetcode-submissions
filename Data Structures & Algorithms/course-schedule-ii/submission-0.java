class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            res[index++] = cur;

            for(int num : graph.get(cur)){
                if(--indegree[num] == 0){
                    queue.offer(num);
                }
            }
        }

        if(index != numCourses){
            return new int[0];
        }

        return res;
    }
}

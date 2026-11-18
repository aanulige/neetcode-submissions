class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length) return false;


        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();



        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
            indegree[e[1]]++;
        }

        for(int i = 0; i < n; i++){
            if(indegree[i] <= 1){
                queue.offer(i);
            }
        }

        int index = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            index++;

            for(int num : graph.get(cur)){
                if(--indegree[num] == 1){
                    queue.offer(num);
                }
            }
        }

        if(index != n){
            return false;
        }

        return true;
    }
}

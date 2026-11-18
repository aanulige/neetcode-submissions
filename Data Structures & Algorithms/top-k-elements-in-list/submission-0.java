class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(
            (a, b) -> freq.get(a) - freq.get(b));
        
        for (Integer key : freq.keySet()){
            minHeap.offer(key);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = minHeap.poll();
        }
        return ans;
    }
}

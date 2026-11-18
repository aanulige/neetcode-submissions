class Twitter {

    private Map<Integer, Tweet> twitter;

    private Map<Integer, Set<Integer>> followings;

    private static int timestamp = 0;

    public Twitter() {
        followings = new HashMap<>();
        twitter = new HashMap<>();
        //maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        if(twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        }else{
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((o1, o2) -> o2.timestamp - o1.timestamp);
        if(twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }

        Set<Integer> followingList = followings.get(userId);
        if(followingList != null && followingList.size() > 0){
            for(int id : followingList){
                Tweet t = twitter.get(id);
                if(t != null){
                    maxHeap.offer(t);
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        int cnt = 0;
        while(!maxHeap.isEmpty() && cnt < 10){
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if(head.next != null){
                maxHeap.add(head.next);
            } 
            cnt++;
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }

        Set<Integer> followList = followings.get(followerId);
        if(followList == null){
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        }else{
            if(followList.contains(followeeId)){
                return;
            }
            followList.add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        Set<Integer> followList = followings.get(followerId);
        if(followList == null){
            return;
        }
        followList.remove(followeeId);
    }

    private class Tweet{
        private int id;
        private int timestamp;
        private String context;
        private Tweet next;

        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }
    }
}

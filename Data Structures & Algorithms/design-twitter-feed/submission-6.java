class Twitter {
    HashMap<Integer, Set<Integer>> following = null;
    HashMap<Integer, Tweet> tweets = null;
    Long time = null;

    public Twitter() {
        following = new HashMap<>();
        tweets = new HashMap<>();
        time = 0L;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>((a, b) -> Long.compare(b.timestamp, a.timestamp));
        List<Integer> ans = new ArrayList<>();
        following.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followee: following.get(userId)) {
            Tweet tweet = tweets.get(followee);
            if(tweet != null) {
                q.offer(tweet);
            }
        }

        while(!q.isEmpty() && ans.size() < 10) {
            Tweet tweet = q.poll();
            ans.add(tweet.id);
            if(tweet.next != null) {
                q.offer(tweet.next);
            }
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        Integer id = null;
        Long timestamp = null;
        Tweet next = null;

        public Tweet(Integer id, Long timestamp) {
            this.id = id;
            this.timestamp = timestamp;
            this.next = null;
        }
    }
}

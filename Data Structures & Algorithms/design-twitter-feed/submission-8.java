class Twitter {
    Map<Integer, Set<Integer>> following = new HashMap<>();
    Map<Integer, Tweet> tweets = new HashMap<>();
    Long time;

    public Twitter() {
        this.time = 0L;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = tweets.get(userId);
        tweets.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>((a, b) -> Long.compare(b.timeStamp, a.timeStamp));
        List<Integer> ans = new ArrayList<>();
        following.computeIfAbsent(userId, k-> new HashSet<>()).add(userId);
        for(int followee: following.get(userId)) {
            Tweet tweet = tweets.get(followee);
            if(tweet != null){
                q.offer(tweet);
            }
        }

        while(!q.isEmpty() && ans.size() <  10) {
            Tweet tweet = q.poll();
            ans.add(tweet.tweetId);
            if(tweet.next != null) {
                q.offer(tweet.next);
            }
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        following.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

class Tweet {
    int tweetId;
    long timeStamp;
    Tweet next;

    Tweet(int tweetId, long timeStamp) {
        this.tweetId = tweetId;
        this.timeStamp = timeStamp;
        this.next = null;
    } 
}

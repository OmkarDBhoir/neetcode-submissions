class Twitter {

    Map<Integer, Set<Integer>> following = new HashMap<>();
    Map<Integer, Tweet> posts = new HashMap<>();
    Long timestamp;

    public Twitter() {
        this.timestamp = 0L;    
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet post = new Tweet(tweetId, timestamp++);
        post.next = posts.get(userId);
        posts.put(userId, post);   
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> q = new PriorityQueue<>((a, b) -> Long.compare(b.timestamp, a.timestamp));
        List<Integer> ans = new ArrayList<>();
        following.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId: following.get(userId)) {
            Tweet post = posts.get(followeeId);
            if(post != null) {
                q.offer(post);
            }
        }

        while(!q.isEmpty() && ans.size() < 10) {
            Tweet post = q.poll();
            ans.add(post.id);
            if(post.next != null) {
                q.offer(post.next);
            }
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        following.computeIfAbsent(followerId, k-> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId) {
            return;
        }
        if(following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}

class Tweet {
    Integer id;
    Long timestamp;
    Tweet next;

    Tweet(int id, Long timestamp) {
        this.id = id;
        this.timestamp = timestamp;
        this.next = null;
    }
}

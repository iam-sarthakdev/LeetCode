class Twitter {

    private int time;

    // user -> set of followees
    private Map<Integer, Set<Integer>> followMap;

    // user -> list of tweets
    private Map<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        time = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    // Tweet structure
    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> res = new ArrayList<>();

        // max heap based on time
        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> Integer.compare(b.time, a.time));

        // add user's tweets
        if (tweetMap.containsKey(userId)) {
            maxHeap.addAll(tweetMap.get(userId));
        }

        // add followees' tweets
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());
        for (int followee : followees) {
            if (tweetMap.containsKey(followee)) {
                maxHeap.addAll(tweetMap.get(followee));
            }
        }

        // get top 10 recent tweets
        int count = 0;
        while (!maxHeap.isEmpty() && count < 10) {
            res.add(maxHeap.poll().id);
            count++;
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
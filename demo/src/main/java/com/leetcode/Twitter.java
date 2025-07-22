package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Twitter {
    // the classical problem of twitter
    // We do the hardwork during the read or write. Depending on the
    // traffic pattern. If there are celebrity use cases, hardwork on
    // read would be preferrable. For the rest hardwork on write is
    // preferrable for the lower latency.

    Map<Integer, Set<Integer>> followedBy;
    Map<Integer, TreeSet<Tweet>> newsFeed;
    Map<Integer, List<Tweet>> selfTweets;
    int sequenceNumber;

    public Twitter() {
        followedBy = new HashMap<>();
        newsFeed = new HashMap<>();
        selfTweets = new HashMap<>();
        sequenceNumber = 0;
    }

    public void postTweet(int userId, int tweetId) {
        sequenceNumber++;
        Tweet tweet = new Tweet(sequenceNumber, tweetId);
        List<Tweet> tweets = selfTweets.getOrDefault(userId, new ArrayList<>());
        tweets.add(tweet);
        selfTweets.put(userId, tweets);
        Set<Integer> followers = followedBy.getOrDefault(userId, new HashSet<>());
        followers.add(userId);
        followers.parallelStream().forEach( follower -> {
            TreeSet<Tweet> feed = newsFeed.getOrDefault(follower, new TreeSet<>(Comparator.comparingInt(Tweet::getSequenceId).reversed()));
            feed.add(tweet);
            newsFeed.put(follower, feed);
        });
    }

    public List<Integer> getNewsFeed(int userId) {
        TreeSet<Tweet> tweets = newsFeed.getOrDefault(userId, new TreeSet<>(Comparator.comparingInt(Tweet::getSequenceId).reversed()));
        List<Integer> feed = new ArrayList<>();
        int count = 0;
        for (Tweet tweet: tweets) {
            feed.add(tweet.getTweetId());
            count++;
            if (count == 10) {
                break;
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followers = followedBy.getOrDefault(followeeId, new HashSet<>());
        followers.add(followerId);
        followedBy.put(followeeId, followers);
        // update the news feed
        List<Tweet> tweets = selfTweets.getOrDefault(followeeId, new ArrayList<>());
        TreeSet<Tweet> feed = newsFeed.getOrDefault(followerId, new TreeSet<>(Comparator.comparingInt(Tweet::getSequenceId).reversed()));
        feed.addAll(tweets);
        newsFeed.put(followerId, feed);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followers = followedBy.get(followeeId);
        followers.remove(followerId);
        // remove the tweets
        List<Tweet> tweets = selfTweets.getOrDefault(followeeId, new ArrayList<>());
        TreeSet<Tweet> feed = newsFeed.getOrDefault(followerId, new TreeSet<>(Comparator.comparingInt(Tweet::getSequenceId).reversed()));
        tweets.forEach(feed::remove);
    }
}

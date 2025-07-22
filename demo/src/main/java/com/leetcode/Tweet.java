package com.leetcode;

public class Tweet {
    private int sequenceId;
    private int tweetId;

    public Tweet(int sequenceId, int tweetId) {
        this.sequenceId = sequenceId;
        this.tweetId = tweetId;
    }

    public int getTweetId() {
        return this.tweetId;
    }

    public int getSequenceId() {
        return this.sequenceId;
    }
}

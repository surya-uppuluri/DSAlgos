package surya.practice.misc.leetcode.contests.weekly175;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TweetCountsTest {

    @Test
    void recordTweet() {
    }

    @Test
    void getTweetCountsPerFrequency() {
    }

    @Test
    void testThatGetTweetWorks() {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);                             // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
        assertEquals("[2]", tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59).toString()); // return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
        tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
        tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.
    }

    /*
     ["TweetCounts","recordTweet","recordTweet","recordTweet","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency"]
             [[],["tweet0",13],["tweet1",16],["tweet2",12],["tweet3",18],["tweet4",82],["tweet3",89],["day","tweet0",89,9471],["hour","tweet3",13,4024]]*/
    @Test
    void testThatGetTweetWorksTest2() {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet0", 13);
        tweetCounts.recordTweet("tweet1", 16);
        tweetCounts.recordTweet("tweet2", 12);
        tweetCounts.recordTweet("tweet3", 18);
        tweetCounts.recordTweet("tweet4", 82);
        tweetCounts.recordTweet("tweet3", 89);

        assertEquals("[0]", tweetCounts.getTweetCountsPerFrequency("day", "tweet0", 89, 9471).toString());
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 13, 4024));
    }


}
package surya.practice.misc.leetcode.contests.weekly175;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TweetCounts {

    HashMap<String, ArrayList<Integer>> tmap = new HashMap();

    public TweetCounts() {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void recordTweet(String tweetName, int time) {
        ArrayList<Integer> templ = tmap.get(tweetName);
        if (null == templ)
            templ = new ArrayList();
        templ.add(time);
        tmap.put(tweetName, templ);
    }
//@formatter:off
    /**
     *
     * ----------PROBLEM STATEMENT-----------
     *LC1348. Tweet Counts Per Frequency
     * Medium
     *
     * Implement the class TweetCounts that supports two methods:
     *
     * 1. recordTweet(string tweetName, int time)
     *
     *     Stores the tweetName at the recorded time (in seconds).
     *
     * 2. getTweetCountsPerFrequency(string freq, string tweetName, int startTime, int endTime)
     *
     *     Returns the total number of occurrences for the given tweetName per minute, hour, or day (depending on freq) starting from the startTime (in seconds) and ending at the endTime (in seconds).
     *     freq is always minute, hour or day, representing the time interval to get the total number of occurrences for the given tweetName.
     *     The first time interval always starts from the startTime, so the time intervals are [startTime, startTime + delta*1>,  [startTime + delta*1, startTime + delta*2>, [startTime + delta*2, startTime + delta*3>, ... , [startTime + delta*i, min(startTime + delta*(i+1), endTime + 1)> for some non-negative number i and delta (which depends on freq).
     *
     *
     *
     * Example:
     *
     * Input
     * ["TweetCounts","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency","recordTweet","getTweetCountsPerFrequency"]
     * [[],["tweet3",0],["tweet3",60],["tweet3",10],["minute","tweet3",0,59],["minute","tweet3",0,60],["tweet3",120],["hour","tweet3",0,210]]
     *
     * Output
     * [null,null,null,null,[2],[2,1],null,[4]]
     *
     * Explanation
     * TweetCounts tweetCounts = new TweetCounts();
     * tweetCounts.recordTweet("tweet3", 0);
     * tweetCounts.recordTweet("tweet3", 60);
     * tweetCounts.recordTweet("tweet3", 10);                             // All tweets correspond to "tweet3" with recorded times at 0, 10 and 60.
     * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59); // return [2]. The frequency is per minute (60 seconds), so there is one interval of time: 1) [0, 60> - > 2 tweets.
     * tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60); // return [2, 1]. The frequency is per minute (60 seconds), so there are two intervals of time: 1) [0, 60> - > 2 tweets, and 2) [60,61> - > 1 tweet.
     * tweetCounts.recordTweet("tweet3", 120);                            // All tweets correspond to "tweet3" with recorded times at 0, 10, 60 and 120.
     * tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);  // return [4]. The frequency is per hour (3600 seconds), so there is one interval of time: 1) [0, 211> - > 4 tweets.
     * ----------
     * ALGORITHM
     * ----------
     * 1.
     * =========================
     * Time Complexity - O()
     * Space Complexity - O()
     * =========================
     */
//@formatter:on
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> res = new ArrayList();
        res.add(0, 0);
        int mod;
        if (freq.equals("minute"))
            mod = 60;
        else if (freq.equals("hour"))
            mod = 3600;
        else
            mod = 86400;
        ArrayList<Integer> fl = tmap.get(tweetName);
        if (fl != null) {
            for (int num : fl) {
                if (startTime <= num && endTime >= num) {
                    if (res.size() >= num / mod + 1) {
                        int val = res.get(num / mod);
                        // System.out.println("putting " + num / mod + " as " + (val + 1));
                        res.set(num / mod, val + 1);
                    } else
                        res.add(num / mod, 1);

                }
            }
        }
        while (endTime > mod) {
            res.add(0);
            endTime = endTime - mod;
        }
        return res;
    }
}
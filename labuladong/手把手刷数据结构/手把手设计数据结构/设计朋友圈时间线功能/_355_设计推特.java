package labuladong.手把手刷数据结构.手把手设计数据结构.设计朋友圈时间线功能;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.cn/problems/design-twitter/
public class _355_设计推特 {
    class Twitter {
        // 全局时间戳
        int globalTime = 0;
        // 记录用户 ID 到用户示例的映射
        HashMap<Integer, User> idToUser = new HashMap<>();

        // Tweet 类
        class Tweet {
            private int id;
            // 时间戳用于对信息流按照时间排序
            private int timestamp;
            // 指向下一条 tweet，类似单链表结构
            private Tweet next;

            public Tweet(int id) {
                this.id = id;
                // 新建一条 tweet 时记录并更新时间戳
                this.timestamp = globalTime++;
            }

            public int getId() {
                return id;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public Tweet getNext() {
                return next;
            }

            public void setNext(Tweet next) {
                this.next = next;
            }
        }

        // 用户类
        class User {
            // 记录该用户的 id 以及发布的 tweet
            private int id;
            private Tweet tweetHead;
            // 记录该用户的关注者
            private HashSet<User> followedUserSet;

            public User(int id) {
                this.id = id;
                this.tweetHead = null;
                this.followedUserSet = new HashSet<>();
            }

            public int getId() {
                return id;
            }

            public Tweet getTweetHead() {
                return tweetHead;
            }

            public HashSet<User> getFollowedUserSet() {
                return followedUserSet;
            }

            public boolean equals(User other) {
                return this.id == other.id;
            }

            // 关注其他人
            public void follow(User other) {
                followedUserSet.add(other);
            }

            // 取关其他人
            public void unfollow(User other) {
                followedUserSet.remove(other);
            }

            // 发布一条 tweet
            public void post(Tweet tweet) {
                // 把新发布的 tweet 作为链表头节点
                tweet.setNext(tweetHead);
                tweetHead = tweet;
            }
        }

        public void postTweet(int userId, int tweetId) {
            // 如果这个用户还不存在，新建用户
            if (!idToUser.containsKey(userId)) {
                idToUser.put(userId, new User(userId));
            }
            User user = idToUser.get(userId);
            user.post(new Tweet(tweetId));
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> res = new LinkedList<>();
            if (!idToUser.containsKey(userId)) {
                return res;
            }
            // 获取该用户关注的用户列表
            User user = idToUser.get(userId);
            Set<User> followedUserSet = user.getFollowedUserSet();

            // 每个用户的 tweet 是一条按时间排序的链表
            // 现在执行合并多条有序链表的逻辑，找出时间线中的最近 10 条动态
            PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> {
                // 按照每条 tweet 的发布时间降序排序（最近发布的排在事件流前面）
                return b.timestamp - a.timestamp;
            });

            // 该用户自己的 tweet 也在时间线内
            if (user.getTweetHead() != null) {
                pq.offer(user.getTweetHead());
            }
            for (User other : followedUserSet) {
                if (other.getTweetHead() != null) {
                    pq.offer(other.tweetHead);
                }
            }
            // 合并多条有序链表
            int count = 0;
            while (!pq.isEmpty() && count < 10) {
                Tweet tweet = pq.poll();
                res.add(tweet.getId());
                if (tweet.getNext() != null) {
                    pq.offer(tweet.getNext());
                }
                count++;
            }
            
            return res;
        }

        public void follow(int followerId, int followeeId) {
            // 如果用户还不存在，则新建用户
            if (!idToUser.containsKey(followerId)) {
                idToUser.put(followerId, new User(followerId));
            }
            if (!idToUser.containsKey(followeeId)) {
                idToUser.put(followeeId, new User(followeeId));
            }

            User follower = idToUser.get(followerId);
            User followee = idToUser.get(followeeId);
            // 关注者关注被关注者
            follower.follow(followee);
        }

        public void unfollow(int followerId, int followeeId) {
            if (!idToUser.containsKey(followerId) || !idToUser.containsKey(followeeId)) {
                return;
            }
            User follower = idToUser.get(followerId);
            User followee = idToUser.get(followeeId);
            // 关注者取关被关注者
            follower.unfollow(followee);
        }
    }
}

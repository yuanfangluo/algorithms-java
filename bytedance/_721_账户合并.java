// https://leetcode.cn/problems/accounts-merge/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Algorithms.Base.UF;

public class _721_账户合并 {
    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // 构建 email -> index 的映射表
            Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
            // 构建 email -> name 的映射表
            Map<String, String> emailToName = new HashMap<String, String>();
            int emailsCount = 0;

            for (List<String> account : accounts) {
                String name = account.get(0);
                int size = account.size();
                // 遍历每个账户的每一个邮箱
                for (int i = 1; i < size; i++) {
                    String email = account.get(i);
                    if (!emailToIndex.containsKey(email)) {
                        emailToIndex.put(email, emailsCount++);
                        emailToName.put(email, name);
                    }
                }
            }

            return null;
        }
    }
}

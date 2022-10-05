package com.wbchao.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount811 {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String line : cpdomains) {
            String[] tmp = line.split(" ");
            int cnt = Integer.parseInt(tmp[0]);
            String domain = "." + tmp[1];
            for (int i = domain.length() - 1; i >= 0; i--) {
                if (domain.charAt(i) == '.') {
                    String sub = domain.substring(i + 1);
                    if (!map.containsKey(sub)) {
                        map.put(sub, cnt);
                    } else {
                        map.put(sub, map.get(sub) + cnt);
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key) + " " + key);
        }
        return ans;
    }
}

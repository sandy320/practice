package com.wbchao.leetcode;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class UniqueEmailAddresses929 {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] tmp = email.split("@");
            String name = tmp[0];
            String domain = tmp[1];
            char[] nameStr = name.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nameStr.length; i++) {
                if (nameStr[i] == '.') {
                    continue;
                } else if (nameStr[i] == '+') {
                    break;
                } else {
                    sb.append(nameStr[i]);
                }
            }
            String newName = sb.toString();
            set.add(newName + "@" + domain);
        }
        return set.size();
    }
}

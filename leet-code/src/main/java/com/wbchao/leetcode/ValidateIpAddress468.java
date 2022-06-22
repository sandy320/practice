package com.wbchao.leetcode;

import java.util.Locale;

public class ValidateIpAddress468 {

    public static void main(String[] args) {
        String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        System.out.println(validIPAddress(queryIP));
    }

    public static String validIPAddress(String queryIP) {
        if (queryIP.startsWith(".") || queryIP.startsWith(":") || queryIP.endsWith(".") || queryIP.endsWith(":")) {
            return NEITHER;
        }
        String[] str = queryIP.split("\\.");

        if (str.length == 4) {
            return validateIpv4(str);
        }
        str = queryIP.split(":");
        if (str.length == 8) {
            return validateIpv6(str);
        }
        return NEITHER;
    }

    public static final String NEITHER = "Neither";

    public static String validateIpv4(String[] str) {
        for (String num : str) {
            if (num.isEmpty()) {
                return NEITHER;
            }
            if (num.length() > 1 && num.startsWith("0")) {
                return NEITHER;
            }
            char[] chars = num.toCharArray();
            if (chars.length > 3) {
                return NEITHER;
            }
            int val = 0;
            for (char c : chars) {
                if (c > '9' || c < '0') {
                    return NEITHER;
                }
                val = 10 * val + (c - '0');
            }
            if (val > 255) {
                return NEITHER;
            }
        }
        return "IPv4";
    }

    public static String validateIpv6(String[] str) {
        for (String num : str) {
            if (num.isEmpty() || num.length() > 4) {
                return NEITHER;
            }
            char[] chars = num.toLowerCase()
                              .toCharArray();
            for (char c : chars) {
                if (!(c <= '9' && c >= '0') && !(c >= 'a' && c <= 'f')) {
                    return NEITHER;
                }
            }
        }
        return "IPv6";
    }
}

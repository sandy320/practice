package com.wbchao.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeAndDecodeTinyurl535 {

    public static class Codec {

        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Map<String, String> short2Long = new HashMap<>();
        Map<String, String> long2Short = new HashMap<>();
        int size = 6;
        Random random = new Random();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (!long2Short.containsKey(longUrl)) {
                String shortUrl = getRandomUrl();
                while (short2Long.containsKey(shortUrl)) {
                    shortUrl = getRandomUrl();
                }
                long2Short.put(longUrl, shortUrl);
                short2Long.put(shortUrl, longUrl);
            }
            return long2Short.get(longUrl);
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return short2Long.get(shortUrl);
        }

        public String getRandomUrl() {
            char[] chars = new char[size];
            for (int i = 0; i < size; i++) {
                chars[i] = str.charAt(random.nextInt(str.length()));
            }
            return String.valueOf(chars);
        }
    }
}

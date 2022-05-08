package com.wbchao;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray442 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int toIndex = nums[i] - 1;
            if (toIndex == i) {
                i++;
                continue;
            }
            if (nums[i] == nums[toIndex]) {
                ans.add(nums[i]);
                nums[i++] = -1;
            } else {
                nums[i] = nums[i] ^ nums[toIndex];
                nums[toIndex] = nums[i] ^ nums[toIndex];
                nums[i] = nums[i] ^ nums[toIndex];
                if (nums[i] == -1) {
                    i++;
                }
            }
        }
        return ans;
    }
}

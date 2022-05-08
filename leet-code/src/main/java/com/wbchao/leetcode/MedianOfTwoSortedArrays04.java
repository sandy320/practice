package com.wbchao.leetcode;

import javax.security.auth.login.CredentialNotFoundException;

public class MedianOfTwoSortedArrays04 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{4, 5, 6};
        int N = nums1.length;
        //  System.out.println(findUpMidValue(nums1, nums2, 0, N - 1, 0, N - 1));
        //System.out.println(findKth(nums1, nums2, 3));
          System.out.println(findMedianSortedArrays(nums1,nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int M = nums1.length;
        int N = nums2.length;
        int k = (M + N + 1) / 2;
        if ((M + N) % 2 == 0) {
            int v1 = getKth(nums1, 0, nums2, 0, k);
            int v2 = getKth(nums1, 0, nums2, 0, k + 1);
            return (v1 + v2) * 0.5;

        } else {
            return getKth(nums1, 0, nums2, 0, k);

        }
    }

    // nums1,nums2等长
    // [1 ,2 ,3 ,4 ]
    //     ^
    // [1`,2`,3`,4`]
    // 若2` > 2,则3`,4`不可能，3`最小也是第5小。
    //           1,2 不可能，2最大也是第3小。
    public static int findUpMidValue(int[] nums1, int[] nums2, int L1, int R1, int L2, int R2) {
        if (L1 == R1 && L2 == R2) {
            return Math.min(nums1[L1], nums2[L2]);
        }
        int N = R1 - L1 + 1;
        int mid1 = (R1 + L1) / 2;
        int mid2 = (R2 + L2) / 2;
        if (N % 2 == 0) {
            if (nums1[mid1] == nums2[mid2]) {
                return nums1[mid1];
            } else if (nums1[mid1] < nums2[mid2]) {
                // 求第4小
                // [1 ,2 ,3 ,4 ]
                //     ^
                // [1`,2`,3`,4`]
                // 若2` > 2,则3`,4`不可能，3`最小也是第5小。
                //           1,2 不可能，2最大也是第3小。
                return findUpMidValue(nums1, nums2, mid1 + 1, R1, L2, mid2);
            } else {
                return findUpMidValue(nums1, nums2, L1, mid1, mid2 + 1, R2);
            }
        } else {
            if (nums1[mid1] == nums2[mid2]) {
                return nums1[mid1];
            } else if (nums1[mid1] < nums2[mid2]) {
                // 求第5小
                // [1 ,2 ,3 ,4 ,5 ]
                //        ^
                // [1`,2`,3`,4`,5`]
                // 若3` > 3,则3`,4`,5`不可能，3`最小也是第6小。(大于1`,2`,3,2,1)
                //           1,2 不可能，2最大也是第4小。
                // 如果3 > 2`,则3就是第5小，否则3不可能
                if (nums1[mid1] > nums2[mid2 - 1]) {
                    return nums1[mid1];
                } else {
                    // 3不可能
                    return findUpMidValue(nums1, nums2, mid1 + 1, R1, L2, mid2 - 1);
                }
            } else {
                if (nums2[mid2] > nums1[mid1 - 1]) {
                    return nums2[mid2];
                } else {
                    return findUpMidValue(nums1, nums2, L1, mid1 - 1, mid2 + 1, R2);
                }
            }
        }
    }

    // 找2个不等长有序数组总体第k小的数值
    public static int findKth(int[] nums1, int[] nums2, int k) {
        int[] shorts = nums1.length < nums2.length ? nums1 : nums2;
        int[] big = shorts == nums1 ? nums2 : nums1;
        //下面都用longs和shorts
        int sLen = shorts.length;
        int bLen = big.length;

        //如果长度相等
        //[1, 2, 3, 4, 5, 6 ]
        //[1`,2`,3`,4, 5`,6`]
        //求第k小
        //        if (sLen == bLen) {
        //            int start = k > sLen ? k - sLen : 0;
        //            int end = k < sLen ? k : sLen - 1;
        //            return findUpMidValue(shorts, big, start, end, start, end);
        //        }

        //分情况讨论 k取值范围0~sLen+bLen
        //1. k<=短数组长度，求整体第k小，相当于求两个数组各取前k个，然后求中位数
        if (k <= sLen) {
            return findUpMidValue(shorts, big, 0, k - 1, 0, k - 1);
        }
        //2. 如果k> 长数组长度，假设求第8小
        //   [1 ,2 ,3 ]
        //
        //   [1`,2`,3`,4`,5`,6`]
        //总共9个数，长数组为6，k = 8
        //则1`,2`,3`,4`不可能
        //若5`>3，则5`就是第k小, 否则 5`不可能
        //1不可能，因为1最大也是第7小，2如果大于6`，就是第8小
        if (k > bLen) {
            if (big[k - sLen - 1] > shorts[sLen - 1]) {
                return big[k - sLen - 1];
            } else if (shorts[k - bLen - 1] > big[bLen - 1]) {
                return shorts[k - bLen - 1];
            } else {
                //1,2,1`,2`,3`,4`,5`均不可能;
                //相当于求剩下可能的里面第1小的,即求剩下的中位数
                //[3],[6`]
                return findUpMidValue(shorts, big, k - bLen, sLen - 1, k - sLen, bLen - 1);
            }
        }
        // sLen<k<=bLen
        // [1, 2, 3, 4, 5, 6]
        // [1`, 2`, 3`, 4`, 5`, 6`,7`,8`,9`,10`,11`]
        // k=10，求整体第10小
        // 1`,2`,3`不可能
        // 11`不可能
        if (k > sLen && k <= bLen) {
            //若4`>6则4`是第10小
            if (big[k - sLen - 1] > shorts[sLen - 1]) {
                return big[k - sLen - 1];
            } else {
                return findUpMidValue(shorts, big, 0, sLen - 1, k - sLen, k - 1);
            }
        }
        return 0;
    }

    public static int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int length1 = nums1.length - start1;
        int length2 = nums2.length - start2;
        if (length2 < length1) {
            return getKth(nums2, start2, nums1, start1, k);
        }

        if (length1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }

        int newStart1 = start1 + Math.min(length1, k / 2) - 1;
        int newStart2 = start2 + Math.min(length2, k / 2) - 1;
        if (nums1[newStart1] < nums2[newStart2]) {
            return getKth(nums1, newStart1 + 1, nums2, start2, k - (newStart1 - start1 + 1));
        } else {
            return getKth(nums1, start1, nums2, newStart2 + 1, k - (newStart2 - start2 + 1));
        }
    }

}

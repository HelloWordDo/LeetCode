package com.leetcode.dynamic.programming.middle;

/**
 * 1191. K 次串联后最大子数组之和
 */
public class KConcatenationMaxSum_1191 {

    /**
     * 内存超出限制
     *
     * @param arr
     * @param k
     * @return
     */
    public static int kConcatenationMaxSum(int[] arr, int k) {

        int mod = 1000000007;
        int[][] m = new int[k][arr.length];

        int max = arr[0] < 0 ? 0 : arr[0];
        for (int i = 0; i < k; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (i == 0 && j == 0) {
                    m[i][j] = (arr[j] < 0 ? 0 : arr[j]) % mod;
                    max = Math.max(max, m[i][j]);
                    continue;
                }

                if (j == 0)
                    m[i][j] = (arr[j] + m[i - 1][arr.length - 1]) % mod;
                else
                    m[i][j] = (arr[j] + m[i][j - 1]) % mod;

                if (m[i][j] < 0) {
                    m[i][j] = 0;
                }

                max = Math.max(max, m[i][j]);
            }
        }
        return max;
    }


    /**
     * 时间超出限制
     *
     * @param arr
     * @param k
     * @return
     */
    public static int kConcatenationMaxSum2(int[] arr, int k) {

        int mod = 1000000007;
        int[] m = new int[arr.length];

        int max = arr[0] < 0 ? 0 : arr[0];
        m[0] = max;
        int last = 0;
        for (int i = 0; i < k; i++) {

            for (int j = 0; j < arr.length; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                if (j == 0)
                    m[j] = (arr[j] + last) % mod;
                else
                    m[j] = (arr[j] + m[j - 1]) % mod;

                if (m[j] < 0) {
                    m[j] = 0;
                }

                if (j == arr.length - 1) {
                    last = m[j];
                }

                max = Math.max(max, m[j]);
            }
        }
        return max;
    }

    public static int kConcatenationMaxSum3(int[] arr, int k) {

        int mod = 1000000007;

        int max = 0;
        //数组的所有值总和
        int sum = 0;

        //数组最大子前缀
        int maxpre = 0;

        //数组最大子后缀
        int maxlast = 0;

        //数组最大连续和
        int num = 0;

        //正序求最大子前缀
        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
            maxpre = Math.max(maxpre, sum);
        }

        //倒序求最大子后缀
        int a = 0;
        for (int i = arr.length - 1; i >= 0; i--) {

            a += arr[i];
            maxlast = Math.max(maxlast, a);
        }

        //连续最大子数组和
        int[] count = new int[arr.length];
        count[0] = arr[0] > 0 ? arr[0] : 0;
        num = count[0];
        for (int i = 1; i < arr.length; i++) {

            if (count[i - 1] + arr[i] < 0) {
                count[i] = 0;
            } else {
                count[i] = count[i - 1] + arr[i];
            }
            num = Math.max(num, count[i]);
        }

        if (k == 1) {
            //如果k=1，即只有一个数组的时候，返回数组的连续子字符串之和最大值num；
            return num % mod;
        }
        if (k >= 2) {
            if (sum < 0) {
                //如果k>=2，同时数组之和sum<=0，则取max(num,end+begin)；也就是相当于只有两节数组拼起来，找其中和最大的连续子字符串；
                int max1 = (Math.max(num, maxlast + maxpre)) % mod;
                return max1;
            } else {
                //如果k>=2，同时数组之和sum>0，则取max(num,sum*(k-2)+end+begin)；也就是相当于把k节字符串拼接起来，中间的k-2节取k-2个sum之和，同时考虑第一段的后缀加上最后一节的前缀的最大值；然后和num的值进行比较；
                long max2 = (Math.max(num, (long) sum * (k - 2) + maxlast + maxpre)) % mod;
                return (int) max2;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("结果：" + kConcatenationMaxSum3(new int[]{1, -1}, 1));
    }
}

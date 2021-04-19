package com.leetcode.backtracking.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * <p>
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * <p>
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RestoreIpAddresses_93 {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        if (s.length() < 4 || s.length() > 12) {
            return Collections.EMPTY_LIST;
        }

        LinkedList ip = new LinkedList();
        backtrack(s, 0, ip, 0);
        return res;
    }

    private void backtrack(String s, int index, LinkedList ip, int segment) {

        if (index == s.length() && segment == 4) {
            res.add(String.join(".", ip));
            return;
        }
        if (s.length() - index < 4 - segment || s.length() - index > 12 - 3 * segment) {
            return;
        }
        for (int i = 0; i < 3; i++) {

            if (index + i >= s.length()) {
                break;
            }

            if (i != 0 && s.charAt(index) == '0') {
                continue;
            }

            String c = s.substring(index, index + i + 1);
            Integer integer = Integer.valueOf(c);
            if (integer > 255) {
                return;
            }
            ip.add(c);
            backtrack(s, index + i + 1, ip, segment + 1);
            ip.removeLast();
        }
    }


    public static void main(String[] args) {

        RestoreIpAddresses_93 method = new RestoreIpAddresses_93();

        List<String> list = method.restoreIpAddresses("101023");
        System.out.println("结果：" + list);
    }
}

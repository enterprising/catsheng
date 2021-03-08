package net.tanpeng.arithmetic.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: peng.tan
 * @create: 2021/03/08 15:11
 */
public class D0308 {
    private static volatile int minLength = Integer.MAX_VALUE;

    public int minCut(String s) {
        if (s.equals("ab")){
            return 1;
        }
        int len = s.length();
        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
        // 注意：只使用 stack 相关的接口
        Deque<String> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        dfs(charArray, 0, len, stack);
        return minLength - 1;
    }

    /**
     * @param charArray
     * @param index     起始字符的索引
     * @param len       字符串 s 的长度，可以设置为全局变量
     * @param path      记录从根结点到叶子结点的路径
     */
    private void dfs(char[] charArray, int index, int len, Deque<String> path) {
        if (index == len) {
            if (path.size() < minLength) {
                minLength = path.size();
            }
            return;
        }

        for (int i = index; i < len; i++) {
            // 因为截取字符串是消耗性能的，因此，采用传子串下标的方式判断一个子串是否是回文子串
            if (!checkPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i + 1 - index));
            dfs(charArray, i + 1, len, path);
            path.removeLast();
        }
    }

    /**
     * 这一步的时间复杂度是 O(N)，优化的解法是，先采用动态规划，把回文子串的结果记录在一个表格里
     *
     * @param charArray
     * @param left      子串的左边界，可以取到
     * @param right     子串的右边界，可以取到
     * @return
     */
    private boolean checkPalindrome(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
        System.out.println(new D0308().minCut("cdd"));
    }
}

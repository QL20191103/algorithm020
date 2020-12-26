package com.jkdx.practice;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 * 题目数据保证答案肯定是一个 32 位的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 示例 4：
 *
 * 输入：s = "1"
 * 输出：1
 * 示例 5：
 *
 * 输入：s = "2"
 * 输出：1
 *
 *
 *
 *
 */
public class NumDecodings {
    public static void main(String[] args) {

        System.out.println(numDecodings("12"));
    }
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] str = s.toCharArray();
        int crr = 1,pre = 1;
        for (int i = 1;i < s.length();i++){
            int tmp = crr;
            if (str[i]=='0'){
                if (str[i-1]=='1'||str[i-1]=='2') {
                    crr=pre;
                }
                else{
                    return 0;
                }
            }
            else if (str[i-1]=='1'||(str[i-1]=='2'&&str[i]>='1'&&str[i]<='2')){
                crr = crr + pre;
            }
            pre = tmp;
        }


        return crr;
    }

}

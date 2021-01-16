package com.jkdx.homework;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个不重复的字符
 *
 * 思想：
 * 暴力：
 * 1.将字符串转换成一个字符数组
 * 2.遍历数组，将字符和出现的次数保存到一个Map集合中
 * 3.遍历集合。找到第一个Key所对应的值为1的下标返回
 *
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        Map<Character,Integer> map = new HashMap<>();
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length();i++) {
            map.put(str[i],map.getOrDefault(str[i],0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            int sum = map.get(str[i]);

            if (sum == 1){
                return i;
            }
        }
        return -1;

    }

}

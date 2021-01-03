package com.jkdx.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 思路：
 * 本题的难点就在于对于n对括号可能出现的情况有多少种，然后从里面找出合法的组合
 * 然后对于这种情况，首先应该考虑如何将所有的组合给找出来，再筛选这些组合，或者说
 * 在生成的时候就进行判断。
 * 1。找到所有的组合：
 * 对于n对括号，也就是说，存在2*n个字符，然后每个位置可能出现“（” 或者 “）”，针对这种情况，采用递归的方式
 * 1）在递归函数中首先声明终止条件
 * if(level==2*n) {
 *     System.out.println(s);
 *     return;
 * }
 * 2）处理当前字符串的逻辑：在当前位置添加左括号，或者右括号
 * String s1 = s + "(";
 * String s2 = s + ")";
 * 3）处理下一层，也就是下一个位置的括号；
 * generate(level+1;2*n;s1);
 * generate(level+1;2*n;s2);
 *
 *
 * 通过以上方法，便能将所有的可能找到
 *
 * 然而怎样才能找到合法的组合呢？
 * 在生成括号时，其实满足一个规律：
 * 左括号随便加，但是不能超过括号的对数，也就是n
 * 右括号添加的时候，必须满足，左括号的个数>=右括号的个数
 * 通过这个规律在，以上的条件上进行修改：
 * if(left<n) {
 *     String s1 = s + "(";
 *     generate(left+1,right,n,s1);
 * }
 * if(left>right) {
 *     String s2 = s + ")";
 *     generate(left,right+1,n,s2);
 * }
 * 通过这种方式就能递归的找到所有合法的括号组合了
 */


public class GenerateParenthesis {
    private static List<String> result;
    public static void main(String[] args) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        result = new ArrayList<String>();
        //第0层，有2n个格子，当前的字符串为“”
        generate(0,0, n,"");

        return result;
    }

    private static void generate(int left, int right,int n, String s) {
        //终止条件
        if (left == n && right == n) {
            //System.out.println(s);
            result.add(s);
            return;
        }

        //处理过程 逻辑：加左括号，或者加右括号
        //左括号随时可以加，但不能超过n，右括号必须之前有左括号，且，左括号的个数必须>=右括号
        if (left < n) {
            String s1 = s + "(";
            //对下一层进行处理
            generate(left+1,right,n,s1);
        }
        if (left > right) {
            String s2 = s + ")";
            //对下一层进行处理
            generate(left,right+1,n,s2);
        }



        //reverse states

    }
}

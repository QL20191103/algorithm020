package com.jkdx.homework;

import java.util.ArrayList;
import java.util.List;

/**
 *给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 思路：
 * 在本题中，可以联想到的题目是求子集的问题，子集，是所有属于该集合的组合
 * 而本题与子集不同之处在于，限制了子集的元素个数，因此可以在求子集的基础
 * 上进一步进行限制，将满足个数要求的组合添加到集合中去便可。
 * 1）定义一个结果集List<List<Integer>> ans = new ArrayList<>();用于
 * 添加满足元素个数要求的子集
 * 2）将n个整数存储到数组中去
 * for (int i = 0;i<n;i++) {
 *    nums[i] = i + 1;
 * }
 * 3）调用递归函数体
 *ff(ans,nums,new ArrayList<Integer>(),0,k);
 * ans：结果集
 * new ArrayList<Integer>()：将每一步递归的结果存储到该集合中
 * 0：递归起始遍历的数组位置下标为0
 * k：满足集合中元素个数为k个时添加到结果集中去
 * 4）编写递归函数：ff(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index,int k)
 * 终止判断：
 * 已经遍历了所有数组的所有位置
 * if(index == nums.length) {
 *     如果集合中元素个数等于要求的个数k则添加到结果集
 *     if(list.size()==k) {
 *         ans.add(new ArrayList<>(list));
 *         return;
 *     }
 * }
 * 中间处理：
 * 不选中当前位置的元素到集合中去
 * ff(ans,nums,list,index+1,k);
 * 选中当前位置的元素添加到集合中去
 * list.add(nums[index]);
 * ff(ans,nums,list,index+1,k);
 *
 * 恢复原点：因为list是全局的变量，这一步的改变会影响到前面几步的结果
 * list.remove(list.size()-1);将之前添加的元素删除掉
 *
 */

public class Combine {
    public static void main(String[] args) {
        List<List<Integer>> list = combine(2,1);
        System.out.println(list);

    }
    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0;i<n;i++) {
            nums[i] = i + 1;
        }
        ff(ans,nums,new ArrayList<Integer>(),0,k);
        return ans;
    }

    private static void ff(List<List<Integer>> ans, int[] nums, ArrayList<Integer> list, int index,int k) {
        if (index == nums.length) {
            if (list.size() == k) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        ff(ans,nums,list,index+1,k);
        list.add(nums[index]);
        ff(ans,nums,list,index+1,k);

        list.remove(list.size()-1);
    }
}

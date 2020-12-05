package com.jkdx.homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 思路：
 * 本题的解法采用搜索回溯的思想：每一个数都会出现在n个不同的位置，而问题就在于如何使他们出现在不同的位置
 * 因此可以想到使用动态维护一个数组的方式，也就是说，将该位置的数和后面每一个数的位置进行交换后再进行下一
 * 层搜索遍历，与此同时，由于数组是全局变量，所以在每一次进行交换后，必须将该数组还原，也就是恢复原点，从
 * 而不影响上面几层的函数体.
 *
 * 编写递归函数
 * 1）终止条件：搜索遍历到最后一个数first = length
 * if(first == length) {
 *     //将数组添加到集合中去
 *     res.add(new ArrayList(list));
 *     return;
 * }
 * 2）中间处理：动态维护一个数组
 *      for (int i = first; i < n; i++) {
 *             //动态维护一个数组
 *             Collections.swap(output,i,first);
 *             3）//继续处理下一层
 *             backtrack(n,output,lists,first+1);
 *             4）//撤销上一步操作
 *             Collections.swap(output,first,i);
 *         }
 *例如：当i=0时；原数组：1 2 3
 * 1:first = 0 ,i = 0，swap: 1 2 3   first = 1
 * 2:first = 1,i = 1,swap: 1 2 3 first = 2
 * 3:first = 2 ,i = 2,swap 1 2 3 first = 3
 * first == length :将数组添加到集合中[1,2,3]回到3
 * 4：first =2,i = 2 撤销交换 swap  1 2 3 i=3 跳出循环 回到 2
 * 5：first =1，i = 1 撤销交换 swap  1 2 3 i=2
 * 6:fist = 1 ,i = 2 swap 1 3 2 first = 2
 * 7:first = 2,i = 2 swap 1 3 2 first =3
 * first == length :将数组添加到集合中[1,3,2]回到7
 * 8:first = 2,i=2,撤销交换 swap 1 3 2 i = 3 跳出循环 回到6
 * 9：first = 1,i =2 撤销交换 swap 1 2 3 i=3 跳出循环
 * 所以当 i = 0 时，获得的数组有：
 * [1 2 3],[1 3 2]
 *
 *
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums= {1,2,3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num:nums) {
            output.add(num);
        }
        int n = nums.length;
        backtrack(n,output,lists,0);
        return lists;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> lists, int first) {
        //递归终止条件
        if (first == n){
            lists.add(new ArrayList<>(output));
            return;
        }
        //中间处理过程
        for (int i = first; i < n; i++) {
            //动态维护一个数组
            Collections.swap(output,i,first);
            //继续处理下一层
            backtrack(n,output,lists,first+1);
            //撤销上一步操作
            Collections.swap(output,first,i);
        }

    }


}

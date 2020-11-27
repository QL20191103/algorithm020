package com.jkdx.homework;

import java.util.PriorityQueue;

/**
 * 滑动窗口最大值
 *给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *
 *  思路：
 *  利用优先队列的思想，也就是堆
 *  1）定义一个优先队列，PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
 *  2）定义一个数组用来接收每组数中最大的那个值，由数学公式可知大小为length-k+1(length为数组长度，k为局部数组的大小)
 *      int[] result = new int[length-k+i];
 *  3）定义一个局部数组的队首标记start=i-k，start由于最开始局部数组的元素个数为0，start<0;当start >=0时数组里有k+1个数
 *  超出了局部数组的大小，这时就得将数组的第一个元素从优先队列里移除heap.remove(nums[start]);
 *  4）将数组元素放入堆中，heap.offer(nums[i]) 大顶堆
 *  5）当heap.size()==k时，将堆里面最大的那个元素放入result数组中result[i-k+1]=heap.peek();
 *
 *
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums={1,3,-1,-3,5,3,6,7};
        int k=3;
        int a[] = maxSlidingWindow(nums,k);
        for (int i = 0;i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0||k==0) {
            return new int[0];
        }

        int[] result = new int[nums.length-k+1];

        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> (o2-o1)));
        int start = 0;
        for (int i = 0;i<nums.length;i++) {
            start=i-k;
            if(start>=0) {
                heap.remove(nums[start]);
            }
            heap.offer(nums[i]);
            if(heap.size()==k) {
                result[i-k+1]=heap.peek();
            }
        }
        return result;

    }
}

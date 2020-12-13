package com.jkdx.practice;

public class CanJump {
    public static void main(String[] args) {

        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        if (nums == null) {
            return false;
        }
        //获取能调到最后一个位置的下标
        int reach = nums.length - 1;
        //从后往前进行贪心
        for (int i = nums.length - 1;i >= 0;i--) {
            //如果当前位置的值加上下标所对应的值大于或等于能达到最后位置的下标值
            //将当前位置作为能达到的最后的那个位置继续向前进行贪心
            if(nums[i] + i >= reach) {
                reach = i;
            }
        }
        //如果能达到最后一个位置，那么最后一个位置将会是0
        return reach == 0;
    }
}

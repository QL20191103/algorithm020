package com.jkdx.homework;

/**
 * 本题利用双指针的想法
 * 即：定义两个下标，j=0，i=1
 * 判断a[j]是否等于a[i]:
 * 如果不等于并且i<length(防止只有一个元素时下标溢出),则将j++,然后将a[i]赋值给a[j]
 * 如果等于则将i++
 *
 * 处理最后一个元素：
 * 首先j++
 * 如果j<length(防止只有一个元素时出现溢出)
 * a[j]=nums[length-1];
 *
 *
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums={0};
        int length=removeDuplicates(nums);
        System.out.println(length);
    }

    public static int removeDuplicates(int[] nums) {


        int j=0;
        int length = nums.length;
        for (int i = 1 ; i<nums.length ; i++) {
            if(nums[j]!=nums[i]&&i<length){
                j++;
                nums[j]=nums[i];
            }
        }
        j++;
        if(j<length) {
            nums[j]=nums[length-1];
        }
        return j;
    }

}

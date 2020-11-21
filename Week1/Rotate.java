package com.jkdx.homework;


/**
 * 使用循环替换法：
 * 将同一个位置（start）的数进行循环替换，直到所替换的值和之前的值一样时就停止，那么如何直到替换的位置的值开始出现重复，因为可能
 * 出现一个数组里有相同的值，此时就应该定义一个current标记，用于标记依次要和start位置的值进行交换的位置，当current值和start相同时
 * 停止替换
 * 1.使用start标记所要进行循环替换的位置初始值为0,
 * 2.定义一个count，每次进行交换就+1一次，最多只能有length次，因为整个数组进行跳动时，最少会替换length次（O(n)）
 * 3.定义一个pre值，用于标记start位置的值，用于进行循环替换
 * 4.定义一个next值，用于进行标记旋转刻度，即循环进行替换的位置
 * 5.开始进行循环替换：
 *     1）next=（current+旋转的跨度）%nums.size()找到要循环进行替换的位置
 *     1）通过设置一个中间变量，temp，将nums[next]与pre的值进行交换
 *      temp=nums[next];
 *      nums[next]=pre;
 *      pre=temp;
 *     2）current移动到next的位置
 *      current=next;
 *     3）count++
 *     4）判断current是否等于start；等于的话，终止循环
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums={-1,-100,3,99};
        rotate(nums,2);
    }

    private static void rotate(int[] nums, int i) {
        i=i%nums.length;
        int count=0;
        int start=0;
        int pre=0;
        int temp;
        for (start=0;count<nums.length;start++) {
            int current=start;
            pre=nums[start];
            do{
                int next=(current+i)%nums.length;
                temp=nums[next];
                nums[next]=pre;
                pre=temp;
                current=next;
                count++;
            }while (start!=current);
        }
        System.out.print("[");
        for (int k=0;k<nums.length;k++) {
            if(k<nums.length-1) {
                System.out.print(nums[k]+",");
            }
            if (k==nums.length-1) {
                System.out.print(nums[k]+"]");
            }
        }
    }
    /*public static void rotate(int[] nums, int k) {
        int num=0;
        for (int i= 0;i<k;i++) {
            num=nums[nums.length-1];
            for (int j=nums.length-2;j>=0;j--){
                nums[j+1]=nums[j];
            }
            nums[0]=num;
        }

        System.out.print("[");
        for (int i=0;i<nums.length;i++) {
            if(i<nums.length-1) {
                System.out.print(nums[i]+",");
            }
            if (i==nums.length-1) {
                System.out.print(nums[i]+"]");
            }
        }
    }*/
}

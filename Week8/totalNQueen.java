package com.jkdx.practice;

public class totalNQueen {
    private int size;
    private int count;

    public static void main(String[] args) {
        totalNQueen queen = new totalNQueen();
        System.out.println(queen.totalNQueens(8));
    }
    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0);
    }

    public int solve(int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            return 1;
        }else {
            int count = 0;
            /**~(columns | diagonals1 | diagonals2):将列，左对角线，右对角线进行异或运算
             * 得到该行不能填皇后的位置，比如：
             * columns:00010100 表示第2列和第4列不能填
             * diagonals1:00110000 表示第4列和第5列不能填
             * diagonals2:00001001 表示第0列和第3列不能填
             * 异或运算得到：00111101，为1的位置是不能填的
             * 取反后得到：11000010，为1的位置是能填的
             * (1<<n)-1)：2^n-1 --> 11111111
             *
             * ((1<<n)-1) & (~(columns | diagonals1 | diagonals2))
             * 得到的结果便是：11000010
             * 即：第1,6，7列为可填位置
             **/
            int position = ((1<<n)-1) & (~(columns | diagonals1 | diagonals2));
            while (position != 0) {
                /**
                 * 11000010
                 * 得到最低位的1，也就是第一个能填的位置
                 * 也就是第1列
                 */
                int pos = position & (-position);
                /**
                 * 11000010
                 * 清零最低位的1，即：
                 * 11000000
                 */
                position = position & (position - 1);
                /**
                 * row + 1:选中当前要填的位置，走到下一层
                 * columns | pos:将列与当前位置进行异或得到下一层列已经填了的位置
                 * (diagonals1 | pos) << 1：将左对角线和当前已选位置进行异或得到下一层左对角线不能填的位置
                 * (diagonals2 | pos) >> 1：将右对角线和当前已选位置进行异或得到下一层右对角线不能填的位置
                 */
                count += solve(n,row+1,columns | pos,(diagonals1 | pos) << 1,(diagonals2 | pos) >> 1);
            }
            return count;
        }
    }
}

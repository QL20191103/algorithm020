学习笔记
位运算符：
<<:左移  0011=>0110
>>:右移  0110=>0011
|:按位或 0011 | 1011 =>1011
&:按位与 0011 & 1011 =>0011
~：按位取反 ~0011=>1100
^:按位异或（相同为零，不同为一） 0011 ^ 1011 =>1000

指定位置的位运算：
1.将x最右边的n位清零：x&(~0<<n)
假设n=3,~0=111,x=11111
~0<<n:111000
x&(~0<<n):11000
将最右边的三位清0
2.获取x的第n位值（0或者1）：(x>>n)&1
假设n=3，x=1010111
x>>n=>0001010
x>>n&1=>0
3.获取x的第n位的幂值:x&(1<<n)
4.将第n位，置为1：x|(1<<n)
5.将第n位，置为0：x&(~(1<<n))
6.将最高位至第n位(含)清零:x&((1<<n)-1)

判断奇偶：
x%2==1 --> (x&1)==1
x%2==0 --> (x&1)==0

x>>1-->x/2
即：x=x/2;-->x=x>>1;
	mid=(left+right)/2;-->mid=(left+right)>>1
	
x=x&(x-1)清零最低位的1
x&-x=>得到最低位的1
x&~x=>0


N皇后问题：
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
位1的个数：
* 思路：
 * 我们遍历数字的 32 位。如果某一位是 1 ，将计数器加一。
 *
 * 我们使用 位掩码 来检查数字的第 i位。
 * 一开始，掩码 m=1 因为 1 的二进制表示是
 *
 * 0000 0000 0000 0000 0000 0000 0000 0001
 *
 * 显然，任何数字跟掩码 1 进行逻辑与运算，都可以让我们获得这个数字的最低位。检查下一位时，我们将掩码左移一位。
 *
 * 0000 0000 0000 0000 0000 0000 0000 0010
 *
 * 并重复此过程。
 *
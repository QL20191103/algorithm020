package com.jkdx.practice;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *
 * 思路：
 * 通过该题目的描述可以想到用深度优先遍历的方式解决该问题，
 * 题目说有上下左右连续起来组成的1为一个岛屿，由0代表海水，
 * 那么可以想到，如果遍历这个二维数组时，碰到了1，就将它上
 * 下左右的1全部置为0即可，利用深度优先的方式即可做到
 *
 * 编写递归函数：
 * 1）终止条件：数组出现越界，或者碰到0的时候就终止循环
 * i代表行数，j代表列数
 * if (i>=n||i<0||j>=m||j<0||grid[i][j]=='0'){
 *    return;
 * }
 * 2）中间处理：将该位置的值置为0
 * grid[i][j]='0';
 * 3）向下旋转：去找该位置上下左右的值，是否为1，也就是重复
 * 调用该函数
 * 处理该位置的右边；
 * DFSmarker(grid,i,n,j+1,m);
 * 处理该位置的左边
 * DFSmarker(grid,i,n,j-1,m);
 * 处理该位置的上边
 * DFSmarker(grid,i-1,n,j,m);
 * 处理该位置的下边
 * DFSmarker(grid,i+1,n,j,m);
 *
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid={{'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {

        int count = 0,n,m;
        //行数
        n = grid.length;
        if(n==0){
            return 0;
        }
        //列数
        m = grid[0].length;
        //System.out.println(n+"==="+m);
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++) {
                if (grid[i][j] == '1') {
                    DFSmarker(grid,i,n,j,m);
                    count++;
                }
            }
        }
        return count;
    }

    private static void DFSmarker(char[][] grid, int i, int n, int j, int m) {
        if (i>=n||i<0||j>=m||j<0||grid[i][j]=='0'){
            return;
        }
        //将该位置的值置位0
        //System.out.println(grid[i][j]+" ");
        grid[i][j]='0';
        //处理该位置的右边；
        DFSmarker(grid,i,n,j+1,m);
        //处理该位置的左边
        DFSmarker(grid,i,n,j-1,m);
        //处理该位置的上边
        DFSmarker(grid,i-1,n,j,m);
        //处理该位置的下边
        DFSmarker(grid,i+1,n,j,m);
    }


}

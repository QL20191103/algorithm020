学习笔记
1.组合：
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
2.全排列
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
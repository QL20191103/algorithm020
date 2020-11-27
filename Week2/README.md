学习笔记
滑动窗口最大数：
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
前序遍历：
* 思路：
 * 对于二叉树儿前序，中序，后序遍历。就是对根节点的访问次序不一样
 * 前序：根左右
 * 中序：左根右
 * 后序：左右根
 * 知道这个顺序后，利用递归的方法遍历每个节点
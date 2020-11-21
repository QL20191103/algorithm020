package com.jkdx.homework;

public class MergeTwoLists {
    static class ListNode{
        int val;	//数值 data
        ListNode next;	// 结点 node

        ListNode(int x){	//可以定义一个有参构造方法，也可以定义一个无参构造方法
            val = x;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
        ListNode(){	//可以定义一个有参构造方法，也可以定义一个无参构造方法

        }
        // 添加新的结点
        public void add(int newval) {
            ListNode newNode = new ListNode(newval);
            if(this.next == null)
                this.next = newNode;
            else
                this.next.add(newval);
        }
        // 打印链表
        public void print() {
            System.out.print(this.val);
            if(this.next != null)
            {
                System.out.print("-->");
                this.next.print();
            }
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        l1.add(2);
        l1.add(4);
        l2.add(3);
        l2.add(4);
        ListNode l3 = mergeTwoLists(l1,l2);
        l1.print();
        System.out.println();
        l2.print();
        System.out.println();
        l3.print();
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*ListNode l;
        if (l1.val>=l2.val) {
            l = new ListNode(l2.val);
            l2=l2.next;
        }else{
            l = new ListNode(l1.val);
            l1=l1.next;
        }
        while (l1!=null&&l2!=null) {
            if (l1.val>=l2.val) {
                System.out.print(l2.val+" ");
                l.add(l2.val);
                l2=l2.next;
            } else {
                System.out.print(l1.val+" ");
                l.add(l1.val);
                l1=l1.next;
            }
        }
        while (l1!=null) {
            System.out.print(l1.val+" ");
            l.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null) {
            System.out.print(l2.val+" ");
            l.add(l2.val);
            l2=l2.next;
        }
        return l;*/
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

package com.lqs.unit1;


/**
 * @author polaris
 * @date 2021/2/3 1:07 下午
 * 递归反转链表的一部分
 * 实例：
 * 输入: 1->2->3->4->5->null ,m = 2,n = 4
 * 输出: 1->4->3->2->5->null
 */
public class ReverseSome {
    /**
     * 反转整个链表递归算法
     * @param head
     * @return
             */
    public ListNode reverse(ListNode head){
        //链表只有一个元素，直接返回
        if (head.next == null) return head;
        //输入1->2->3->4->5->null变成1->(null<-2<-3<-4<-5)
        ListNode last = reverse(head.next);
        //此时需要将2.next变成1,之后1->(1<-2<-3<-4<-5)
        head.next.next = head;
        //1.next变成null，即 null<-1<-2<-3<-4<-5
        head.next = null;
        //最后返回即可
        return last;
    }





    /**
     * 反转前n个节点
     *
     * @param head 链表
     * @param n 1 =< n < head.len
     * @return 反转结果
     */
    public static ListNode reverseFrontN(ListNode head,int n){
        //以1->2->3->4->5->6->null, n = 3为例子


        //定义后继节点
        ListNode successor = null;
        //链表只有一个元素，直接返回
        if(n == 1){
            //记录第n+1个节点
            successor = head.next;
            return head;
        }
        //以head.next为起点，只需要反转前n-1个节点
        //1<-2<-3< 4->5->6->null
        ListNode last = reverseFrontN(head.next,n-1);
        //反转节点
        head.next.next = head;
        //反转后的head节点和后面的节点连起来,即4为1的后继
        head.next = successor;
        return last;
    }

    /**
     * 反转部分算法
     *
     * @param head 非空链表
     * @param m 第一个输入, 1 ≤ m ≤ n ≤ 链表长度
     * @param n 第二个输入
     * @return
     */
    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseFrontN(head, n);
        }
        // 前进到反转的起点触发 base case
        // head为1，从m开始
        // head为2，从m-1开始
        // ……
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
}

/**
 * @author polaris
 * @date 2021/2/1 9:30 下午
 *
 * 递归反转链表的一部分
 * 实例：
 * 输入: 1->2->3->4->5->null ,m = 2,n = 4
 * 输出: 1->4->3->2->5->null
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    /**
     * 反转整个链表递归算法
     *
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
     * 反转部分算法
     *
     * @param listNode 非空链表
     * @param m 第一个输入, 1 ≤ m ≤ n ≤ 链表长度
     * @param n 第二个输入
     * @return
     */
    public ListNode reverseSome(ListNode listNode,int m,int n){
        return listNode;
    }

}

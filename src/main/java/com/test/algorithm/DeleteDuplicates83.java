package com.test.algorithm;

import java.util.List;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/27 15:56
 */
public class DeleteDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur!=null&&cur.next!=null){
            ListNode next = cur.next;
            if(next.val==cur.val){
                cur.next = next.next;
                next.next = null;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    public class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
  }
}

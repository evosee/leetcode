package com.test;

/**
 * @author chensai
 * @version 1.0
 * @date 2019/6/24 15:44
 */
public class TwoNumbers {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
   //     ListNode listNode2 = new ListNode(4);
   //     ListNode listNode3 = new ListNode(3);

    //    listNode.next = listNode2;
    //    listNode2.next = listNode3;


        ListNode listNode4 = new ListNode(5);
    //    ListNode listNode5 = new ListNode(6);
     //   ListNode listNode6 = new ListNode(4);

     //   listNode4.next = listNode5;
     //   listNode5.next = listNode6;

        TwoNumbers twoNumbers = new TwoNumbers();
        ListNode node = twoNumbers.addTwoNumbers2(listNode,listNode4);
        do {
            int x = node.val;
            node = node.next;
            System.out.println(x);
        } while (node != null);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = getInteger(l1);
        int b = getInteger(l2);
        int r = a + b;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(r));
        char[] x = stringBuilder.reverse().toString().toCharArray();
        ListNode result = new ListNode(Integer.parseInt(String.valueOf(x[0])));
        ListNode head = result;
        for (int i = 1; i < x.length; i++) {
            ListNode n = new ListNode(Integer.parseInt(String.valueOf(x[i])));
            result.next = n;
            result = n;
        }
        return head;
    }

    private int getInteger(ListNode l1) {
        StringBuilder stringBuilder = new StringBuilder();
        do {
            stringBuilder.append(l1.val);
            l1 = l1.next;
        } while (l1 != null);

        return Integer.parseInt(stringBuilder.reverse().toString());

    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while (p1!=null||p2!=null){
            int v1 = p1!=null?p1.val:0;
            int v2 = p2!=null?p2.val:0;
            int x = v1+v2+carry;
            carry = x/10;
            curr.next = new ListNode(x%10);
            curr = curr.next;
            if(p1!=null) p1 = p1.next;
            if(p2!=null) p2 = p2.next;
        }
        if(carry>0){
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}

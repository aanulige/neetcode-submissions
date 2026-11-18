/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode newHead = new ListNode();
        ListNode newPnt = newHead;

        while(cur1 != null && cur2 != null){
            if(cur1.val < cur2.val){
                newPnt.next = cur1;
                cur1 = cur1.next;
            }else{
                newPnt.next = cur2;
                cur2 = cur2.next;
            }
            newPnt = newPnt.next;
        }

        while(cur1 != null){
            newPnt.next = cur1;
            cur1 = cur1.next;
            newPnt = newPnt.next;
        }

        while(cur2 != null){
            newPnt.next = cur2;
            cur2 = cur2.next;
            newPnt = newPnt.next;
        }

        return newHead.next;
    }
}
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode front = head.next;
        int count = size(head);
        int steps = count - n;
        if(count == 1 && n == 1 ){
            return null;
        }

        while(steps!=0){
            prev = curr;
            curr = front;
            front = front.next;

            steps--;
        } 
        if(prev!= null){
            prev.next = front;
            curr.next = null;
        }else{
            head = front;
            curr.next = null;
        }

        return head;
    }
    public static int size(ListNode head){
        int size =0;
        ListNode temp = head;
        while(temp!=null){
            size++;
            temp = temp.next;
            
        }
        return size;
    }
}

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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list: lists){
            pq.offer(list);
        }
        ListNode res = new ListNode();
        ListNode curr = res;
        while(!pq.isEmpty()){
            ListNode newnode = pq.poll();
            curr.next = newnode;
            curr = curr.next;
            newnode = newnode.next;
            if(newnode!=null){
                pq.offer(newnode);
            }
        }

        return res.next;
    }
}

// using min heap where we add the first node of each list to the min heap and then we poll the minimum node and add it to our result list and then we add the next node of the polled node to the min heap until the min heap is empty.    
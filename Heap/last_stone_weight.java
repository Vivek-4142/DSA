class Solution {
    public int lastStoneWeight(int[] stones) {
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int num: stones ){
        pq.add(num);
       } 
       while(pq.size()>1){
            
            int left = pq.poll();
            int right = pq.poll();
            if(left != right){
               
                pq.add(left-right);
            }
       }
       if(pq.isEmpty()){
        return 0;
       }else{
        return pq.peek();
       }
    }
}

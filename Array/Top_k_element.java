class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map = new HashMap<>();

       for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       PriorityQueue<Integer> pq = new PriorityQueue<>(
          (a,b) -> map.get(a) - map.get(b));

       for(int num: map.keySet()){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
       }

       int [] arr = new int[k];
       for(int i =0;i<k;i++){
         arr[i] = pq.poll();
       }

       return arr;
    }
}
// Count frequencies using HashMap and maintain a Min Heap of size k
// to keep track of the top k most frequent elements.
// If heap size exceeds k, remove the least frequent element.
// Finally, extract elements from the heap into the result array.
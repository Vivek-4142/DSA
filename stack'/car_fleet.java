class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i = 0; i < speed.length; i++){
            mp.put(position[i], speed[i]);
        }

        Arrays.sort(position);

        Stack<Double> st = new Stack<>();

        for(int i = position.length - 1; i >= 0; i--){

            double time =
                (double)(target - position[i]) /
                mp.get(position[i]);

            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            }
        }

        return st.size();
    }
}
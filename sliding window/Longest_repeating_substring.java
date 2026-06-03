class Solution {
    public int characterReplacement(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < s.length(); right++) {

            map.put(s.charAt(right),
                    map.getOrDefault(s.charAt(right), 0) + 1);

            int maxval = 0;
            for (char ch : map.keySet()) {
                maxval = Math.max(maxval, map.get(ch));
            }

            while ((right - left + 1) - maxval > k) {

                map.put(s.charAt(left),
                        map.get(s.charAt(left)) - 1);

                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }

                left++;

                maxval = 0;
                for (char ch : map.keySet()) {
                    maxval = Math.max(maxval, map.get(ch));
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
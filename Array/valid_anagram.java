class Solution {    
    public boolean isAnagram(String s, String t) {  
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        for(int i = 0 ; i< s.length();i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i = 0 ; i< t.length();i++){
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
         
         return map1.equals(map2);
    }
        
 }

    
    // Problem: Valid Anagram
    // Topic: Strings, Hashing
    // Approach:
    // Use a HashMap to count character frequencies.
    // If both strings have the same character counts,
    // they are valid anagrams.

    // Time Complexity: O(n)
    // Space Complexity: O(n)

        

        
    



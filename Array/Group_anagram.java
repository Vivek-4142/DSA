 public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] arr = str.toCharArray();

            Arrays.sort(arr);

            String sorted = new String(arr);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }


       // Problem: Group Anagrams
    // Topic: Strings, HashMap, Sorting
    // Approach:
    // Sort each string and use the sorted string as a key.
    // Strings with the same sorted form are anagrams
    // and will be grouped together.

    // Time Complexity: O(n * k log k)
    // n = number of strings
    // k = maximum length of string

    // Space Complexity: O(n)
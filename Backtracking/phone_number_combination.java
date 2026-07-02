class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        if(digits.length() == 0){
            return res;
        }
        backtrack(0,digits,s,res,map);
        return res;
    }
    public void backtrack(int i, String digits,StringBuilder s, List<String> res,Map<Character,String> map ){
        if(s.length() ==  digits.length()){
            res.add(s.toString());
            return;
        }
        String cr = map.get(digits.charAt(i));
        for(char c: cr.toCharArray()){
            s.append(c);
            backtrack(i+1,digits,s,res,map);
            s.deleteCharAt(s.length()-1);
        }
    }
}

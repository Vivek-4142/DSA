class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backtrack(s, 0, new ArrayList<>(), ans);

        return ans;
    }

    public void backtrack(String s,
                          int start,
                          List<String> path,
                          List<List<String>> ans){

        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int end = start; end < s.length(); end++){

            if(isPali(s, start, end)){

                path.add(s.substring(start, end+1));

                backtrack(s, end+1, path, ans);

                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPali(String s,int i,int j){

        while(i<j){

            if(s.charAt(i)!=s.charAt(j))
                return false;

            i++;
            j--;
        }

        return true;
    }
}
//if we want to track a multiple element from start to end we should use for and under for backtrack we should use recursion and if we want to track a single element we can use recursion only.
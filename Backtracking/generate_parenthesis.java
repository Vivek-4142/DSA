class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        getPar(n, 0, 0, sb, list);

        return list;
    }

    public void getPar(int n, int open, int close,
                       StringBuilder sb, List<String> list) {

        if (open == n && close == n) {
            list.add(sb.toString());
            return;
        }


        if (open < n) {
            sb.append('(');
            getPar(n, open + 1, close, sb, list);
            sb.deleteCharAt(sb.length() - 1);   
        }

        if (close < open) {
            sb.append(')');
            getPar(n, open, close + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);   
        }
    }
}

//if there are two index to track then we should remove and backtrack the element 2 times and if we have only one indx to track then only one time to backtrack the element.
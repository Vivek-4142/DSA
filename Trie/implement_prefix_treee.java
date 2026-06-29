class PrefixTree {
    PrefixTree[] children;
    boolean eof;
  
    public PrefixTree() {
         children = new PrefixTree[26];
         for(int i =0;i<26;i++){
            children[i] = null;
         }
         eof = false;
        
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for(int i =0;i<word.length();i++){
        int idx = word.charAt(i)-'a';
        if(curr.children[idx] == null){
            curr.children[idx] = new PrefixTree();
        }
        if(i == word.length()-1){
            curr.eof = true;
        }
        curr = curr.children[idx];
        }
    }

    public boolean search(String word) {
            PrefixTree curr = this;
            for(int i =0;i<word.length();i++){
                int idx = word.charAt(i)-'a';
                if(curr.children[idx] == null){
                    return false;
                }
                if(i == word.length()-1 && curr.eof == false){
                    return false;
                }
                curr = curr.children[idx];
            }
            return true;
    }

    public boolean startsWith(String prefix) {
         PrefixTree curr = this;
            for(int i =0;i<prefix.length();i++){
                int idx = prefix.charAt(i)-'a';
                if(curr.children[idx] == null){
                    return false;
                }
            
                curr = curr.children[idx];
            }
            return true;
    }
}

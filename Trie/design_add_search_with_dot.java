class WordDictionary {

    WordDictionary[] child;
    boolean eof;

    public WordDictionary() {
        child = new WordDictionary[26];
        eof = false;
    }

    public void addWord(String word) {
        WordDictionary curr = this;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new WordDictionary();
            }

            curr = curr.child[idx];
        }

        curr.eof = true;
    }

    public boolean search(String word) {
        return helper(word, 0, this);
    }

    private boolean helper(String word, int index, WordDictionary curr) {

        if (index == word.length()) {
            return curr.eof;
        }

        char ch = word.charAt(index);

        if (ch == '.') {

            for (int i = 0; i < 26; i++) {
                if (curr.child[i] != null &&
                    helper(word, index + 1, curr.child[i])) {
                    return true;
                }
            }

            return false;
        }

        int idx = ch - 'a';

        if (curr.child[idx] == null) {
            return false;
        }

        return helper(word, index + 1, curr.child[idx]);
    }
}
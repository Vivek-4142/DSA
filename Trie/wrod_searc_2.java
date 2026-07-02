

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();
    int ROWS, COLS;

    public List<String> findWords(char[][] board, String[] words) {

        // Build Trie
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new TrieNode();
                }
                curr = curr.children[idx];
            }
            curr.word = word;
        }

        ROWS = board.length;
        COLS = board[0].length;

        List<String> result = new ArrayList<>();

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS)
            return;

        char ch = board[r][c];

        if (ch == '#')
            return;

        TrieNode next = node.children[ch - 'a'];

        if (next == null)
            return;

        if (next.word != null) {
            result.add(next.word);
            next.word = null; // avoid duplicates
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, next, result);
        dfs(board, r - 1, c, next, result);
        dfs(board, r, c + 1, next, result);
        dfs(board, r, c - 1, next, result);

        board[r][c] = ch;
    }
}
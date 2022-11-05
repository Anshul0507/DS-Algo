class TrieNode{
    String word;
    TrieNode[] children = new TrieNode[26];
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        makeTrie(root,words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++)
                dfs(board,i,j,root,res);
        }
        return res;
    }
    
    private void makeTrie(TrieNode root, String[] words){
        for(String w: words){
            TrieNode node = root;
            for(int i=0; i<w.length();i++){
                char ch = w.charAt(i);
                if(node.children[ch-'a']==null)
                    node.children[ch-'a'] = new TrieNode();
                node = node.children[ch-'a'];
            }
            node.word=w;
        }
    }
    
    
    
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.children[c - 'a'] == null) return;
        p = p.children[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }

}
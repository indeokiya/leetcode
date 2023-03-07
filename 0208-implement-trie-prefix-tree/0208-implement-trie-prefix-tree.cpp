class Trie {
private:
    Trie* next[26];
    bool existsEnd;
    
public:
    Trie() {
        fill(next, next+26, nullptr);
        existsEnd = false;
    }
    
    void insert(string word) {
        if (word == "") {
            existsEnd = true;
            return;
        }
        
        int c = ctoi(word[0]);
        if (!next[c]) next[c] = new Trie();
        next[c]->insert(word.length() == 1 ? "" : word.substr(1));
    }
    
    bool search(string word) {
        if (word == "") return existsEnd;
        
        int c = ctoi(word[0]);
        if (!next[c]) return false;
        
        return next[c]->search(word.length() == 1 ? "" : word.substr(1));
    }
    
    bool startsWith(string prefix) {
        if (prefix == "") return true;
        
        int c = ctoi(prefix[0]);
        if (!next[c]) return false;
        
        return next[c]->startsWith(prefix.length() == 1 ? "" : prefix.substr(1));
    }
    
    int ctoi(char c) {
        return c - 'a';
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
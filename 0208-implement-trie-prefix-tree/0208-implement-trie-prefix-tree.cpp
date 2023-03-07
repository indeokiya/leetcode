struct Node{
    Node* next[26];
    bool ExistsEnd;
    
};

class Trie {
private:
    Node* root;
    
public:
    Trie() {
        root = new Node();
    }
    
    void insert(string word) {
        Node* curr = root;
        for (int i=0; i<word.length(); i++) {
            if (curr->next[word[i]-'a'] == NULL) curr->next[word[i]-'a'] = new Node();
            curr = curr->next[word[i]-'a'];
        }
        curr->ExistsEnd = true;
    }
    
    bool search(string word) {
        Node* curr = root;
        for (char c : word) {
            if (curr->next[c-'a'] == NULL) return false;
            curr = curr->next[c-'a'];
        }
        return curr->ExistsEnd;
    }
    
    bool startsWith(string prefix) {
        Node* curr = root;
        for (char c : prefix) {
            if (curr->next[c-'a'] == NULL) return false;
            curr = curr->next[c-'a'];
        }
        return true;
    }
    
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
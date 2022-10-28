class LRUCache {
private:
    class Node {
    public:
        int key, val;
        Node* prev;
        Node* next;
        
        Node(){}
        Node(int key, int val) {
            this->key = key;
            this->val = val;
        }
    };
    
    int capacity;
    int size;
    unordered_map<int, Node*> myMap;
    Node* head = new Node();
    Node* tail = new Node();
    
    void insertHead (Node* node) {
        // cout << "inserHead " << node->key << endl;
        head->next->prev = node;
        node->next = head->next;
        node->prev = head;
        head->next = node;
    }
    
    void update (Node* node) {
        node->next->prev = node->prev;
        node->prev->next = node->next;
        insertHead(node);
    }
    
    void deleteTail () {
        myMap.erase(tail->prev->key);
        tail->prev = tail->prev->prev;
        tail->prev->next = tail;
    }
    
public:
    LRUCache(int capacity) {
        ios_base::sync_with_stdio(false);cin.tie(nullptr);cout.tie(nullptr);
        this->capacity = capacity;
        this->size = 0;
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        
        if (myMap.count(key)) {
            Node* node = myMap[key];
            update(node);
            return node->val;
        }
        return -1;
    }
    
    void put(int key, int value) {
        if (myMap.count(key)) {
            Node* node = myMap[key];
            node->val = value;
            update(node);
        } else if (size<capacity) {
            Node* node = new Node(key, value);
            myMap[key] = node;
            insertHead(node);
            size++;
            return;
        } else {
            deleteTail();
            Node* newNode = new Node(key, value);
            myMap[key] = newNode;
            insertHead(newNode);
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
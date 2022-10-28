class MedianFinder {
public: 
    MedianFinder() {
        size=0;
        mid=0;
        small.push(INT_MIN);
        big.push(INT_MAX);
    }
    
    void addNum(int num) {
        if (size==0) {
            mid = num;
            size++;
            return;
        }
        if (size%2==0) {
            if (num<=mid) {
                small.push(num);
            } else {
                small.push(mid);
                big.push(num);
                mid = big.top(); big.pop();
            }
        } else {
            if (num<=mid) {
                big.push(mid);
                small.push(num);
                mid = small.top(); small.pop();
            } else {
                big.push(num);   
            }
        }
        
        size++;
    }
    
    double findMedian() {
        if (size%2==1) {
            return (double)mid;
        } else {
            return (double)(mid+big.top())/2;
        }
    }
    
private:
    int mid;
    int size;
    priority_queue<int, vector<int>, less<int>> small;
    priority_queue<int, vector<int>, greater<int>> big;
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
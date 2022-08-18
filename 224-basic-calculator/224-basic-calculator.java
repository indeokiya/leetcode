class Solution {
    private int idx = 0;
    
    public int calculate(String s) {
        // time complexity : O(n)
        // space complexity : O(1)
        
        int sum = 0;
        int currNum = 0; // 가장 최근 num.
        int prevNum = 0; // currNum 이전까지 쌓아온 num
        char preOp = '+';  // 현재 연산자가 아니라 전 연산자를 들고 다녀야 함
        
        while (idx < s.length()) {
            char c = s.charAt(idx++);
            if (c == ' ') {
                continue;
            }
            
            if (c == '(') {
                // intuition: (1+2*3)는 7로 바꿀 수 있음
                // )를 만날때까지 calculate()하고 currNum으로 저장
                //System.out.println("go into");
                currNum = calculate(s); // idx는 알아서 indexOf(')') + 1 로 바뀜
            } else if (c >= '0' && c <= '9') {
                // if number
                currNum = currNum*10 + c - '0';
            } 
            
            //연산자이거나, )이거나, 마지막 숫자인 경우 연산 타이밍
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || idx == s.length()) { 
                switch(preOp) {                
                    // +, - : do NOT need prevNum anymore; add it to sum and keep currNum
                    case '+':
                        sum += prevNum;
                        prevNum = currNum;
                        break;
                    case '-':
                        // prevNum은 '-' 이전의 버퍼같은 느낌; '-' 이전의 합을 sum에 더해줌
                        sum += prevNum;
                        prevNum = -currNum;
                        break;
                    // *, / : need to keep prevNum; update it with currNum and search next operator
                    case '*':
                        prevNum *= currNum;
                        break;
                    case '/':
                        prevNum /= currNum;
                        break;
                }
                // after manipulation, update op
                currNum = 0; // 하지 않으면 currNum*10 + ~ 에서 문제생김
                preOp = c;
            }
            if (c == ')') {
                // System.out.println("go out");
                return prevNum + sum;  // 빠져나감
            }

            System.out.println("prev: " + prevNum + ", curr: " + currNum + ", sum: " + sum + ", preOp: " + preOp);
        }
        
        return prevNum + currNum + sum;
    }
}
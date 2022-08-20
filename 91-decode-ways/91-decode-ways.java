class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        
        int ans = 1;
        int f1=1, f0=1;
        int i= s.length()-1;
        char curr, prev=s.charAt(i);

        while (i>=1) {
            curr = prev;
            prev = s.charAt(i-1);
            
            if (curr == '0') {
                if (prev == '1' || prev == '2') {
                    i--;
                    if (i>0) prev = s.charAt(i-1);
                    f1=1; f0=1;
                } else {
                    return 0;
                }
            } else if (prev == '1' || (prev=='2' && curr<='6')) {
                int tmp = f1;
                f1 = f1 + f0;
                f0 = tmp;   
            } else {
                ans *= f1;
                f1=1; f0=1;
            }      
            i--;
        }
        
        return ans*f1;
    }
}

//1 2 3 5 8
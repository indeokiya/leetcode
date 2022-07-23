class Solution:
    def getSum(self, a: int, b: int) -> int:
        if a == 0:
            return b        
        if b == 0:
            return a
        
        sign = 1
        
        if a*b > 0:
            if a < 0 and b < 0:
                sign = -1
            x, y = abs(a), abs(b)
            while y:
                xor = x^y
                overflow = (x&y) << 1
                x, y = xor, overflow
        elif a*b < 0 : # 1-1, 0-0 = 0, 1-0 = 1, 0-1 = -1
            if abs(a) > abs(b):
                x, y = abs(a), abs(b)
            else:
                x, y = abs(b), abs(a)
            while y:
                
                tmp = x^y
                borrow = ((~x)&y) << 1
                x, y = tmp, borrow
            
        return sign*x
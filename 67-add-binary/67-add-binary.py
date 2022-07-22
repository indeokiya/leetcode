class Solution:
    def addBinary(self, a: str, b: str) -> str:
        # use XOR
        x, y = int(a, 2), int(b, 2)
        
        while y:
            ans = x^y
            goUp = (x&y) << 1 # left shift
            x, y = ans, goUp
            
        return bin(x)[2:]
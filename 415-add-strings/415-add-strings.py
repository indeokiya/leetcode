class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        #ascii code: ord('1') == 49
        ans = ""
        intSum = self.convertIntoNum(num1) + self.convertIntoNum(num2)
        print(intSum)
        if intSum == 0:
            return "0"
        while intSum > 0 :
            ans = chr(intSum%10+ord('0')) + ans
            intSum = intSum//10
        return ans
           
    def convertIntoNum(self, num: str) -> int:
        ans = 0
        len1 = len(num)
        while len1 > 0:
            ans += (ord(num[-len1]) - ord('0')) * (10**(len1-1))
            len1 -= 1
        return ans
            
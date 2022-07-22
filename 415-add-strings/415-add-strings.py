class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        #ascii code: ord('1') == 49
        ans = []
        p1, p2 = len(num1)-1, len(num2)-1
        res = 0
        while p1 >= 0 or p2 >= 0 :
            n1 = ord(num1[p1])-ord('0') if p1 >= 0 else 0
            n2 = ord(num2[p2])-ord('0') if p2 >= 0 else 0
            
            val = (n1 + n2 + res) % 10
            res = (n1 + n2 + res) // 10

            p1 -= 1
            p2 -= 1
            ans.append(val)
            

        if res:
            ans.append(res)
        return "".join(str(x) for x in ans[::-1])
           
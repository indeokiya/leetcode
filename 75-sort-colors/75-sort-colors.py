class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cnt0, cnt2 = 0, -1
        tmp = None
        i = 0
        while i < len(nums):
            if nums[i] == 0:
                if i == cnt0:
                    i += 1
                else:
                    tmp = nums[cnt0]
                    nums[cnt0] = 0
                    nums[i] = tmp
                cnt0 += 1
                
            elif nums[i] == 1:
                i += 1
            
            elif nums[i] == 2:
                if i - cnt2 > len(nums):
                    break
                else:
                    tmp = nums[cnt2]
                    nums[cnt2] = 2
                    nums[i] = tmp
                    cnt2 -= 1
            
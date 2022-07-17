class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        cnt0, cnt2 = 0, -1
        i = 0
        while i < len(nums):
            if nums[i] == 0:
                if i == cnt0:
                    i += 1
                else:
                    nums[cnt0], nums[i] = 0, nums[cnt0]
                cnt0 += 1
                
            elif nums[i] == 1:
                i += 1
            
            elif nums[i] == 2:
                if i - cnt2 > len(nums):
                    break
                else:
                    nums[cnt2], nums[i] = 2, nums[cnt2]
                    cnt2 -= 1
            
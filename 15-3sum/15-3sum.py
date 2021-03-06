class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        ans = []
        nums.sort()
        
        for i in range(len(nums)-2):
            if nums[-1] + nums[-2] + nums[i] < 0:
                continue
            if nums[i] + nums[i+1] + nums[i+2] > 0:
                break
            low, high = i+1, len(nums)-1
            while low < high:
                cur_2sum = nums[low] + nums[high]
                m = (low+high)//2
                if cur_2sum + nums[i] > 0:
                    high = m-1 if nums[low] + nums[m] > -nums[i] else high-1
                elif cur_2sum + nums[i] < 0:
                    low = m+1 if nums[m] + nums[high] < -nums[i] else low+1
                else:
                    tmp = [nums[i], nums[low], nums[high]]
                    if tmp not in ans:
                        ans.append(tmp)
                    low += 1
                    high -= 1
                    #while low < high and nums[low] == nums[low-1]:
                    #    low += 1
            
        return ans
                    
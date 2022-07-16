class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        limit = len(nums)//2
        return nums[limit]
        
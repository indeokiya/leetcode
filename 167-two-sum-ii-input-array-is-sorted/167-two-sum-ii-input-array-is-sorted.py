class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        low, high = 0, len(numbers)-1
        while low < high:
            cur_sum = numbers[low] + numbers[high]
            m = (low+high)//2
            if cur_sum > target:
                high = m-1 if numbers[low] + numbers[m] > target else high-1
            elif cur_sum < target:
                low = m+1 if numbers[m] + numbers[high] < target else low+1
            else:
                return [low+1, high+1]
            
        return [0, 0]
    
    # time: O(n)
    # space: O(1)
        
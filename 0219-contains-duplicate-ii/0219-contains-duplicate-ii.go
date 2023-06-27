func containsNearbyDuplicate(nums []int, k int) bool {
    seen := make(map[int]int, len(nums))
    
    for i:=0; i<len(nums); i++ {
        if index, ok := seen[nums[i]]; ok && i - index <= k {
            return true
        }
        seen[nums[i]] = i
    }
    
    return false
}
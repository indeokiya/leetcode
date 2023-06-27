func containsNearbyDuplicate(nums []int, k int) bool {
    seen := map[int]int{}
    
    for i:=0; i<len(nums); i++ {
        index, ok := seen[nums[i]]
        if !ok {
            seen[nums[i]] = i
            continue
        }
        if i - index <= k {
            return true
        } 
        seen[nums[i]] = i
    }
    
    return false
}
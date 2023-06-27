func containsNearbyDuplicate(nums []int, k int) bool {
    seen := make(map[int]int, len(nums))
    
    for i, num := range nums {
        if index, ok := seen[num]; ok && i - index <= k {
            return true
        }
        seen[num] = i
    }
    
    return false
}
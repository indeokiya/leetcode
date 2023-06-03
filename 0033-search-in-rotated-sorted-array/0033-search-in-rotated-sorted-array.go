func search(nums []int, target int) int {
    lo, hi := 0, len(nums)
    
    for lo < hi {
        mid := (lo + hi) >> 0x1
        if nums[mid] == target {
            return mid
        }
        
        if nums[lo] < nums[mid] {
            if target > nums[mid] || target < nums[lo] {
                lo = mid + 1    
            } else {
                hi = mid
            }
        } else {
            if target > nums[hi-1] || target < nums[mid] {
                hi = mid
            } else {
                lo = mid + 1
            }
        }
        
    }
    
    return -1
}
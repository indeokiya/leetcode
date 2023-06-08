func subArrayRanges(nums []int) int64 {
    total := int64(0)
    MAX := int(^uint32(0)>>1)
    MIN := -MAX-1
    
    for i:=0; i<len(nums); i++ {
        largest, smallest := MIN, MAX
        for j:=i; j<len(nums); j++ {
            if largest < nums[j] {
                largest = nums[j]
            }
            if smallest > nums[j] {
                smallest = nums[j]
            }
            total += int64(largest - smallest)
        }
    }
    
    return total
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func max(a, b int) int {
    if a < b {
        return b
    }
    return a
}
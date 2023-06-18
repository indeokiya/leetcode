func summaryRanges(nums []int) []string {
    ret := make([]string, 0, 0)
    if len(nums) == 0 {
        return ret
    }
    
    from := nums[0]
    
    for i:=1; i<len(nums); i++ {
        if nums[i-1]+1 < nums[i] {
            if from < nums[i-1] {
                ret = append(ret, strconv.Itoa(from) + "->"+ strconv.Itoa(nums[i-1]))        
            } else {
                ret = append(ret, strconv.Itoa(from))     
            }
            
            from = nums[i]
        }
    }
    
    if nums[len(nums)-1] != from {
        ret = append(ret, strconv.Itoa(from) + "->"+ strconv.Itoa(nums[len(nums)-1]))    
    } else {
        ret = append(ret, strconv.Itoa(nums[len(nums)-1]))    
    }
    
    return ret
}
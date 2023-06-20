func removeElement(nums []int, val int) int {
    k, n := 0, len(nums)
    if n==0 {
        return 0
    }
    for i:=0; i<n-k; i++{
        if nums[i] != val {
            continue   
        }
        
        for i < n-1-k && nums[n-1-k] == val {
            k++
        }
        nums[i] = nums[n-1-k]
        k++
    }
    
    
    return n-k
}
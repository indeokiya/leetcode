func removeDuplicates(nums []int) int {
    insertIdx, appear := 1, 1
    for i:=1; i<len(nums); i++ {
        if nums[i-1] == nums[i] {
            if appear == 2 {
                continue
            }
            appear++
        } else {
            appear = 1
        }
        
        nums[insertIdx] = nums[i]
        insertIdx++
    }
    
    return insertIdx
}
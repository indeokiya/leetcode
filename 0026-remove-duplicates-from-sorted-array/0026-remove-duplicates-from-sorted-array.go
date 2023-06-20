func removeDuplicates(nums []int) int {
    k := 0
    exist := make([]bool, 201, 201)
    for _, num := range nums {
        exist[num+100] = true
    }
    for i:=0; i<=200; i++ {
        if exist[i] {
            nums[k] = i-100
            k++
        }
    }
    
    return k
}
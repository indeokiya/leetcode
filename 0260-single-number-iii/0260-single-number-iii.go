func singleNumber(nums []int) []int {
    mask := 0
    for _, num := range nums {
        mask ^= num
    }
    
    lsb := mask & (-mask)
    x := 0
    for _, num := range nums {
        if lsb & num != 0 {
            x ^= num
        }
    }
    return []int{x, x^mask}
}
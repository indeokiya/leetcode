func singleNumber(nums []int) int {
    one, two := 0x0, 0x0
    
    for _, num := range nums {
        one = one^num & ^two
        two = two^num & one
    }
    
    return one
}
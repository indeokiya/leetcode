func singleNumber(nums []int) int {
    seenOnce, seenTwice := 0, 0
    
    for _, num := range nums {
        seenOnce = seenOnce^num & ^seenTwice
        seenTwice = seenTwice^num & ^seenOnce
    }
    
    return seenOnce
}
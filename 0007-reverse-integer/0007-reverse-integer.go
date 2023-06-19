func reverse(x int) int {
    INT_MAX := int(^uint32(0) -1)
    if x == -INT_MAX-1 {
        return 0
    }
    if x < 0 {
        return -1 * reverse(-x)
    }
    
    answer := 0
    
    for x > 0 {
        if answer >= 214748365 {
            return 0
        }
        answer *= 10
        answer += x%10
        x /= 10
    }

    
    return answer
}

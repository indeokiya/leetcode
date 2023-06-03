func validateStackSequences(pushed []int, popped []int) bool {
    stack := []int{}
    i, j, size := 0, 0, 0
    
    for i < len(pushed) {
        stack = append(stack, pushed[i])
        i++
        size++
        for size > 0 && stack[size-1] == popped[j] {
            stack = stack[:size-1]
            size--
            j++
        }
    }
    
    for size > 0 {
        if stack[size-1] != popped[j] {
            return false
        }
        size--
        j++
    }
    
    return true
}
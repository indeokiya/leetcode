func canSeePersonsCount(heights []int) []int {
    N := len(heights)
    queue := make([]int, 0, 0)
    answer := make([]int, N, N)
    queue = append(queue, heights[N-1])
    answer[N-1] = 0
    
    for i:=N-2; i>=0; i-- {
        
        for len(queue) > 0 {
            answer[i]++
            if heights[i] < queue[len(queue)-1] {
                break
            }           
            queue = queue[:len(queue)-1]
        }
    
        queue = append(queue, heights[i])
        
    }
    
    
    
    
    
    return answer
}
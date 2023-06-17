func findSmallestSetOfVertices(n int, edges [][]int) []int {
    to := make([]int, n, n)
    answer := make([]int, 0, 0)
    
    for _, edge := range edges {
        to[edge[1]]++    
    }
    
    for i:=0; i<n; i++ {
        if to[i] == 0 {
            answer = append(answer, i)
        }
    }
    
    return answer
}
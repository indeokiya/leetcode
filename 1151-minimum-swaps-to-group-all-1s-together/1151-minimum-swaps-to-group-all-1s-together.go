func minSwaps(data []int) int {
    ones, out := 0, len(data)
    for _, num := range data {
        if num == 1 {
            ones++
        }
    }
    
    zeros := 0
    for i:=0; i<ones; i++ {
        if data[i] == 0 {
            zeros++
        }
    }
    out = zeros
    
    for i:=ones; i<len(data); i++ {
        if data[i] == 0 {
            zeros++
        }
        if data[i-ones] == 0 {
            zeros--
        }
        out = min(out, zeros)
    }
    
    return out
}

func min(lhs, rhs int) int {
    if lhs < rhs {
        return lhs
    }
    return rhs
}
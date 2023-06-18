func coinChange(coins []int, amount int) int {
    money := make([]int, amount+1, amount+1)
    MAX := 99999
    for i:=0; i<amount; i++ {
        money[i] = MAX
    }
    
    for _, coin := range coins {
        for i:=amount; i>=coin; i-- {
            if money[i] != MAX {
                money[i-coin] = min(money[i-coin], money[i]+1)
            }
        }
    }
    
    
    if money[0] != MAX {
        return money[0]
    }
    return -1
}

func min(a, b int) int {
    if a < b {
        return a
    }    
    return b
}
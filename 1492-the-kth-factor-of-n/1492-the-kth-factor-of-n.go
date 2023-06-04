func kthFactor(n int, k int) int {
    factors := []int{}
    
    i := 1
    cnt := 0
    for i*i < n {
        if n%i == 0 {
            factors = append(factors, i)
            cnt += 2
        }
        i++
    }
    if i*i == n {
        factors = append(factors, i)
        cnt++
    }
    
    if k > cnt {
        return -1
    }
    
    if k <= cnt/2 {
        return factors[k-1]    
    }
    
    return n / factors[cnt-k]
}
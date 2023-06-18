func mySqrt(x int) int {
    lo, hi := 0, 1<<16
    for lo + 1 < hi {
        mid := (lo + hi) >> 1
        if mid * mid > x {
            hi = mid
        } else {
            lo = mid
        }
    }
    
    return lo
}
func minEatingSpeed(piles []int, h int) int {
    
    var lo, hi int = 0, maxElem(piles)

	for lo + 1 < hi {
		var mid int = (lo + hi) >> 1
		var hour int
        
		for _, pile := range piles {
			hour += pile / mid
			if pile%mid > 0 {
				hour++
			}

			if hour > h {
				break
			}
		}
        
		if hour > h {
			lo = mid
		} else {
			hi = mid
		}
	}

	return hi
}

func maxElem(nums []int) int {
    max := -1
    
    for _, e := range nums {
        if e > max {
            max = e
        }
    }
    
    return max
}
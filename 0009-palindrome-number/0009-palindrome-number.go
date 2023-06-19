func isPalindrome(x int) bool {
	if x < 0 {
		return false
	}

	mask := int(1e9)
	for mask > 9 {
		if x/mask > 0 {
			break
		}
		mask /= 10
	}

	for x > 0 {
		q, r := x/mask, x%10
		if q != r {
			return false
		}
		x %= mask
        x /= 10
		mask /= 100
	}

	return true
}
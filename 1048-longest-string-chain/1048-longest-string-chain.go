func longestStrChain(words []string) int {
	ans := 1
	m := make(map[string]int)
	buckets := make([][]string, 17, 17)
	for i := 0; i <= 16; i++ {
		buckets[i] = make([]string, 0, 0)
	}

	for _, word := range words {
		buckets[len(word)] = append(buckets[len(word)], word)
	}

	for i := 1; i <= 16; i++ {
		for _, curr := range buckets[i] {
			m[curr] = 1
			for _, prev := range buckets[i-1] {
				if IsPredecessor(prev, curr) {
					m[curr] = max(m[curr], m[prev]+1)
					ans = max(m[curr], ans)
				}
			}
		}
	}

	return ans
}

func IsPredecessor(a, b string) bool {
    i := 0
	for ; i<len(a); i++ {
		if a[i] != b[i] {
			break
		}
	}

    return a[i:] == b[i+1:]
}

func max(a, b int) int {
    if a < b {
        return b
    }
    return a
}
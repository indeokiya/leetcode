func romanToInt(s string) int {
	m := map[byte]int{
		"I"[0]: 1, "V"[0]: 5, "X"[0]: 10, "L"[0]: 50, "C"[0]: 100, "D"[0]: 500, "M"[0]: 1000,
	}

	sum := 0

	for i := 0; i < len(s); {
		if i == len(s)-1 {
			sum += m[s[i]]
			break
		}

		if m[s[i]] >= m[s[i+1]] {
			sum += m[s[i]]
			i++
			continue
		}

		sum += m[s[i+1]] - m[s[i]]
		i += 2

	}

	return sum
}
type Pair struct {
	word string
	freq int
}

func topKFrequent(words []string, k int) []string {
	m := map[string]int{}
	out := []string{}

	for _, word := range words {
		m[word]++
	}

	slice := make([]Pair, 0)

	for k, v := range m {
		newPair := Pair{}
		newPair.word = k
		newPair.freq = v
		slice = append(slice, newPair)
	}

	sort.Slice(slice, func(i, j int) bool {
		if slice[i].freq == slice[j].freq {
			return slice[i].word < slice[j].word
		}
		return slice[i].freq > slice[j].freq
	})

	for i := 0; i < k; i++ {
		out = append(out, slice[i].word)
	}

	return out
}
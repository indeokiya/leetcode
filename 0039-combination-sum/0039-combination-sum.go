func combinationSum(candidates []int, target int) [][]int {
	answers := [][]int{}
	currSlice := []int{}

	backTracking(0, &candidates, 0, target, &answers, &currSlice)

	return answers
}

func backTracking(index int, candidates *[]int, sum int, target int, answers *[][]int, currSlice *[]int) {
	if index >= len(*candidates) || sum+2 > target {
		return
	}

	backTracking(index+1, candidates, sum, target, answers, currSlice)

	sum += (*candidates)[index]
	*currSlice = append(*currSlice, (*candidates)[index])

	if sum == target {
		newSlice := make([]int, len(*currSlice))
		copy(newSlice, *currSlice)
		*answers = append(*answers, newSlice)
	}

	backTracking(index, candidates, sum, target, answers, currSlice)
	*currSlice = (*currSlice)[:len(*currSlice)-1]
}
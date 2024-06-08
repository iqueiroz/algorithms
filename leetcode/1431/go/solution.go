package solution

func kidsWithCandies(candies []int, extraCandies int) []bool {
	result := make([]bool, len(candies))

	maxCandies := candies[0]
	for i := 0; i < len(candies); i++ {
		if candies[i] > maxCandies {
			maxCandies = candies[i]
		}
	}
	for i := 0; i < len(candies); i++ {
		result[i] = (candies[i] + extraCandies) >= maxCandies
	}
	return result
}

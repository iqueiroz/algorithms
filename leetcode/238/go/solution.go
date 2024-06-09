package solution

func productExceptSelf(nums []int) []int {
	auxl := make([]int, len(nums))
	auxr := make([]int, len(nums))
	result := make([]int, len(nums))

	auxl[0] = 1
	auxr[len(nums)-1] = 1

	for i := 1; i < len(nums); i++ {
		j := len(nums) - i - 1
		auxl[i] = nums[i-1] * auxl[i-1]
		auxr[j] = nums[j+1] * auxr[j+1]
	}

	for i := 0; i < len(nums); i++ {
		result[i] = auxl[i] * auxr[i]
	}

	return result
}

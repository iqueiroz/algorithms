package solution

func findIntersectionValues(nums1 []int, nums2 []int) []int {
	result := []int{0, 0}

	//find answers
	r0 := make(chan int)
	r1 := make(chan int)

	go intersectCounter(nums1, nums2, r0)
	go intersectCounter(nums2, nums1, r1)

	result[0] = <-r0
	result[1] = <-r1
	return result
}

func intersectCounter(nums1 []int, nums2 []int, result chan int) {
	map2 := buildMap(nums2)
	counter := 0
	for i := 0; i < len(nums1); i++ {
		_, exists := map2[nums1[i]]
		if exists {
			counter++
		}
	}
	result <- counter
}

func buildMap(nums []int) map[int]int {
	resultMap := make(map[int]int)
	for i := 0; i < len(nums); i++ {
		resultMap[nums[i]]++
	}
	return resultMap
}

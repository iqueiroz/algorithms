package solution

func canPlaceFlowers(flowerbed []int, n int) bool {
	planted := 0
	flowerbedSize := len(flowerbed)
	for i := 0; i < flowerbedSize && planted < n; i++ {
		if flowerbed[i] == 1 {
			i++
			continue
		}

		if i+1 < flowerbedSize {
			if flowerbed[i+1] == 1 {
				i = i + 2
				continue
			}
		}

		planted++
		i++
	}
	return planted >= n
}

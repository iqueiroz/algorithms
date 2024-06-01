package solution

func numSteps(s string) int {
	offset := 1
	steps := 0

	bitArray := make([]bool, len(s)+offset)
	for i := 0; i < len(s); i++ {
		bitArray[i+offset] = s[i] == '1'
	}

	for len(bitArray)-offset > 1 {
		steps++
		if isOdd(&bitArray) {
			offset = sumOne(&bitArray, offset)

		} else {
			offset = divideByTwo(&bitArray, offset)
		}
	}
	return steps
}

func isOdd(bitArray *[]bool) bool {
	return (*bitArray)[len(*bitArray)-1]
}

func sumOne(bitArray *[]bool, offset int) int {
	for i := len(*bitArray) - 1; i >= 0 && i >= offset-1; i-- {
		if i < offset {
			offset = i
		}
		currentPosition := (*bitArray)[i]
		(*bitArray)[i] = !currentPosition
		if !currentPosition {
			break
		}
	}
	return offset
}

func divideByTwo(bitArray *[]bool, offset int) int {
	*bitArray = (*bitArray)[:len(*bitArray)-1]
	return offset
}

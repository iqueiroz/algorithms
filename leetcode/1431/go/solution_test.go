package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestKidsWithCandies_Case1(t *testing.T) {
	// prepare
	candies := []int{2, 3, 5, 1, 3}
	extraCandies := 3
	expected := []bool{true, true, true, false, true}

	// act
	result := kidsWithCandies(candies, extraCandies)

	// assert
	assert.Equal(t, expected, result)

}

func TestKidsWithCandies_Case2(t *testing.T) {
	// prepare
	candies := []int{4, 2, 1, 1, 2}
	extraCandies := 1
	expected := []bool{true, false, false, false, false}

	// act
	result := kidsWithCandies(candies, extraCandies)

	// assert
	assert.Equal(t, expected, result)

}

func TestKidsWithCandies_Case3(t *testing.T) {
	// prepare
	candies := []int{12, 1, 12}
	extraCandies := 10
	expected := []bool{true, false, true}

	// act
	result := kidsWithCandies(candies, extraCandies)

	// assert
	assert.Equal(t, expected, result)

}

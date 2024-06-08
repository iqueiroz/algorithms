package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestCanPlaceFlowers_Case1(t *testing.T) {
	// prepare
	flowerbed := []int{1, 0, 0, 0, 1}
	n := 1
	expected := true

	// act
	result := canPlaceFlowers(flowerbed, n)

	// assert
	assert.Equal(t, expected, result)

}

func TestCanPlaceFlowers_Case2(t *testing.T) {
	// prepare
	flowerbed := []int{1, 0, 0, 0, 1}
	n := 2
	expected := false

	// act
	result := canPlaceFlowers(flowerbed, n)

	// assert
	assert.Equal(t, expected, result)

}
func TestCanPlaceFlowers_Case3(t *testing.T) {
	// prepare
	flowerbed := []int{1, 0, 0, 0, 0, 1}
	n := 2
	expected := false

	// act
	result := canPlaceFlowers(flowerbed, n)

	// assert
	assert.Equal(t, expected, result)

}

func TestCanPlaceFlowers_Case4(t *testing.T) {
	// prepare
	flowerbed := []int{0, 1, 0}
	n := 1
	expected := false

	// act
	result := canPlaceFlowers(flowerbed, n)

	// assert
	assert.Equal(t, expected, result)
}

// []
func TestCanPlaceFlowers_Case5(t *testing.T) {
	// prepare
	flowerbed := []int{0, 1, 0, 1, 0, 1, 0, 0}
	n := 1
	expected := true

	// act
	result := canPlaceFlowers(flowerbed, n)

	// assert
	assert.Equal(t, expected, result)
}

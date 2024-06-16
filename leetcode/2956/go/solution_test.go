package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestFindIntersectionValues_Case1(t *testing.T) {
	// prepare
	nums1 := []int{2, 3, 2}
	nums2 := []int{1, 2}
	expected := []int{2, 1}

	// act
	result := findIntersectionValues(nums1, nums2)

	// assert
	assert.Equal(t, expected, result)

}

func TestFindIntersectionValues_Case2(t *testing.T) {
	// prepare
	nums1 := []int{4, 3, 2, 3, 1}
	nums2 := []int{2, 2, 5, 2, 3, 6}
	expected := []int{3, 4}

	// act
	result := findIntersectionValues(nums1, nums2)

	// assert
	assert.Equal(t, expected, result)

}

func TestFindIntersectionValues_Case3(t *testing.T) {
	// prepare
	nums1 := []int{3, 4, 2, 3}
	nums2 := []int{1, 5}
	expected := []int{0, 0}

	// act
	result := findIntersectionValues(nums1, nums2)

	// assert
	assert.Equal(t, expected, result)

}

package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestProductExceptSelf_Case1(t *testing.T) {
	// prepare
	nums := []int{1, 2, 3, 4}
	expected := []int{24, 12, 8, 6}

	// act
	result := productExceptSelf(nums)

	// assert
	assert.Equal(t, expected, result)

}

func TestProductExceptSelf_Case2(t *testing.T) {
	// prepare
	nums := []int{-1, 1, 0, -3, 3}
	expected := []int{0, 0, 9, 0, 0}

	// act
	result := productExceptSelf(nums)

	// assert
	assert.Equal(t, expected, result)

}

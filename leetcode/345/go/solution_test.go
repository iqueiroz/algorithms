package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestReverseVowels_Case1(t *testing.T) {
	// prepare
	s := "hello"
	expected := "holle"

	// act
	result := reverseVowels(s)

	// assert
	assert.Equal(t, expected, result)

}

func TestReverseVowels_Case2(t *testing.T) {
	// prepare
	s := "leetcode"
	expected := "leotcede"

	// act
	result := reverseVowels(s)

	// assert
	assert.Equal(t, expected, result)

}

func TestReverseVowels_Case3(t *testing.T) {
	// prepare
	s := "a."
	expected := "a."

	// act
	result := reverseVowels(s)

	// assert
	assert.Equal(t, expected, result)

}

func TestReverseVowels_Case4(t *testing.T) {
	// prepare
	s := "zzz"
	expected := "zzz"

	// act
	result := reverseVowels(s)

	// assert
	assert.Equal(t, expected, result)

}

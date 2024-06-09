package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestReverseWords_Case1(t *testing.T) {
	// prepare
	s := "the sky is blue"
	expected := "blue is sky the"

	// act
	result := reverseWords(s)

	// assert
	assert.Equal(t, expected, result)

}

func TestReverseWords_Case2(t *testing.T) {
	// prepare
	s := " hello world "
	expected := "world hello"

	// act
	result := reverseWords(s)

	// assert
	assert.Equal(t, expected, result)

}

func TestReverseWords_Case3(t *testing.T) {
	// prepare
	s := "a good example"
	expected := "example good a"

	// act
	result := reverseWords(s)

	// assert
	assert.Equal(t, expected, result)

}

func TestReverseWords_Case4(t *testing.T) {
	// prepare
	s := "zzz"
	expected := "zzz"

	// act
	result := reverseWords(s)

	// assert
	assert.Equal(t, expected, result)

}

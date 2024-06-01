package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestMergeAlternately_Case1_ShouldMerge(t *testing.T) {
	// prepare
	word1 := "abc"
	word2 := "pqr"
	expected := "apbqcr"

	// act
	result := mergeAlternately(word1, word2)

	// assert
	assert.Equal(t, expected, result, "The merged string should be as: "+expected)

}

func TestMergeAlternately_Case2_ShouldMerge(t *testing.T) {
	// prepare
	word1 := "ab"
	word2 := "pqrs"
	expected := "apbqrs"

	// act
	result := mergeAlternately(word1, word2)

	// assert
	assert.Equal(t, expected, result, "The merged string should be as: "+expected)
}

func TestMergeAlternately_Case3_ShouldMerge(t *testing.T) {
	// prepare
	word1 := "abcd"
	word2 := "pq"
	expected := "apbqcd"

	// act
	result := mergeAlternately(word1, word2)

	// assert
	assert.Equal(t, expected, result, "The merged string should be as: "+expected)
}

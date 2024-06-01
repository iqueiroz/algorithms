package solution

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestNumSteps_Case1_ShouldReturn_6(t *testing.T) {
	// prepare
	s := "1101"
	expected := 6

	// act
	result := numSteps(s)

	// assert
	assert.Equal(t, expected, result, "1101 should calculate 6 steps")

}

func TestNumSteps_Case2_ShouldReturn_1(t *testing.T) {
	// prepare
	s := "10"
	expected := 1

	// act
	result := numSteps(s)

	// assert
	assert.Equal(t, expected, result, "10 should calculate 1 steps")

}

func TestNumSteps_Case3_ShouldReturn_0(t *testing.T) {
	// prepare
	s := "1"
	expected := 0

	// act
	result := numSteps(s)

	// assert
	assert.Equal(t, expected, result, "1 should calculate 0 steps")

}

func TestNumSteps_Case4_ShouldReturn_4(t *testing.T) {
	// prepare
	s := "111"
	expected := 4

	// act
	result := numSteps(s)

	// assert
	assert.Equal(t, expected, result, "111 should calculate 0 steps")

}

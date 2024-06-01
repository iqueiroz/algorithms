namespace Solution.Tests;

public class SolutionTests
{
    [Theory]
    [InlineData("1101", 6)]
    [InlineData("10", 1)]
    [InlineData("1", 0)]
    [InlineData("111", 4)]
    public void NumSteps_Should_Calculate_StepsToReduceTo1(string s, int expected)
    {
        //setup
        var solution = new Solution();

        //act
        var result = solution.NumSteps(s);

        //assert
        Assert.Equal(expected, result);
    }
}
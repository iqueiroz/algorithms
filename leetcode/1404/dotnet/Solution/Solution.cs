using System.Collections;

namespace Solution;

public class Solution
{
    public int NumSteps(string s)
    {
        int offset = 1;
        int steps = 0;
        
        BitArray bitArray = this.InitializeBitArray(s, offset);
        
        while (bitArray.Count - offset > 1)
        {
            steps++;
            if (this.IsOdd(bitArray))
                offset = this.SumOne(bitArray, offset);
            else
            {
                offset = this.DivideByTwo(bitArray, offset);
            }
        }
        return steps;
    }

    private int DivideByTwo(BitArray bitArray, int offset)
    {
        bitArray.LeftShift(1);
        return ++offset;
    }

    private BitArray InitializeBitArray(string s, int offset)
    {
        var bitArray = new BitArray(s.Length + offset);
        for (var i = 0; i < s.Length; i++)
        {
            bitArray.Set(i + offset, s[i] == '1');
        }

        return bitArray;
    }

    private bool IsOdd(BitArray bitArray)
    {
        return bitArray.Get(bitArray.Count - 1);
    }
    private int SumOne(BitArray bitArray, int offset)
    {

        for (var i = bitArray.Count - 1; i >= 0 && i >= offset - 1; i--)
        {
            if (i < offset)
                offset = i;
            var currentPosition = bitArray.Get(i);
            bitArray.Set(i, !currentPosition);
            if (!currentPosition)
                break;
        }
        return offset;
    }
}
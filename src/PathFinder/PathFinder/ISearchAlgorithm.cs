using System;
using System.Collections.Generic;
using System.Linq;

namespace PathFinder
{
    public interface ISearchAlgorithm
    {
        bool IsReacheable(Node start, Node goal);
    }
}
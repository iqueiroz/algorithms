using System;
using System.Collections.Generic;
using System.Linq;

namespace PathFinder.Client
{
    public struct Point
    {
        public int Row { get; private set; }
        public int Column { get; private set; }

        public Point(int row, int column)
        {
            this.Row = row;
            this.Column = column;
        }
    }
}
using System;

namespace PathFinder
{
    public class Node
    {
        public int Row { get; private set; }
        public int Column { get; private set; }
        public int Id { get; private set; }
        public Node(int id, int row, int column)
        {
            this.Row = row;
            this.Column = column;
            this.Id = id;
        }

        public override bool Equals(object obj)
        {
            
            if (obj == null || ! (obj is Node))
            {
                return false;
            }
            
            return this.Id == ((Node)obj).Id;
        }
        
        public override int GetHashCode()
        {
            return this.Id;
        }
        public override string ToString()
        {
            return this.Id.ToString();
        }
    }
}

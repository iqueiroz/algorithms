using System;
using System.Collections.Generic;

namespace PathFinder
{
    public class Graph
    {
        private readonly IDictionary<int, IList<Node>> _adjacencyList;
        private readonly IDictionary<int, Node> _nodes;
        private readonly int _totalRows;
        private readonly int _totalColumns;

        public ICollection<Node> Vertices
        {
            get
            {
                return this._nodes.Values;
            }
        }

        public Graph(int totalRows, int totalColumns)
        {
            this._nodes = new Dictionary<int, Node>();
            this._adjacencyList = new Dictionary<int, IList<Node>>();
            this._totalRows = totalRows;
            this._totalColumns = totalColumns;
        }


        public Node AddNode(int row, int column)
        {
            Node node = new Node(CalculateNodeIndex(row, column, this._totalColumns), row, column);

            this._nodes.Add(node.Id, node);
            this._adjacencyList.Add(node.Id, new List<Node>(4));
            return node;

        }

        public void AddEdge(Node nodeA, Node nodeB)
        {
            this._adjacencyList[nodeA.Id].Add(nodeB);
            this._adjacencyList[nodeB.Id].Add(nodeA);
        }

        public Node GetNode(int id)
        {
            return this._nodes[id];
        }

        public Node GetNode(int row, int column)
        {
            return this._nodes[this.CalculateNodeIndex(row, column, this._totalColumns)];
        }

        public ICollection<Node> GetNeighbors(Node node)
        {
            return this._adjacencyList[node.Id];
        }

        private int CalculateNodeIndex(int row, int column, int totalColumns)
        {
            return (row*totalColumns)+(column+1);
        }
    }

}

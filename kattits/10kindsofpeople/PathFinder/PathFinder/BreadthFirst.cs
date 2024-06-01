using System;
using System.Collections.Generic;
using System.Linq;

namespace PathFinder
{
    public class BreadthFirst : ISearchAlgorithm
    {
        private readonly Graph _graph;
        public BreadthFirst(Graph graph)
        {
            this._graph = graph;
        }

        public bool IsReacheable(Node start, Node goal)
        {
            var openSet = new Queue<Node>();
            var closedSet = new HashSet<Node>();
    
            var root = start;
            openSet.Enqueue(root);
            while(openSet.Count>0)
            {
                var subtreeRoot = openSet.Dequeue();

                if(goal.Id == subtreeRoot.Id)
                    return true;

                foreach(var neighbor in this._graph.GetNeighbors(subtreeRoot))
                {
                    if(closedSet.Contains(neighbor))
                        continue;
                    if(!openSet.Contains(neighbor))
                        openSet.Enqueue(neighbor);
                }
                closedSet.Add(subtreeRoot);
            }
            return false;
        }
    }
}
using System;
using System.Collections.Generic;
using System.Linq;

namespace PathFinder
{
    public class AStar : ISearchAlgorithm
    {
        private readonly Graph _graph;
        public AStar(Graph graph)
        {
            this._graph = graph;
        }

        public bool IsReacheable(Node start, Node goal)
        {
            var closedSet = new HashSet<Node>();
            var openSet = new HashSet<Node>();
            openSet.Add(start);

            var gScore = new Dictionary<Node, int>();
            gScore.Add(start, 0);

            var fScore = new Dictionary<Node, double>();
            fScore.Add(start, HeuristicEstimate(start, goal));
            

            while(openSet.Count > 0)
            {
                var current = fScore.Where(x=>openSet.Contains(x.Key))
                                    .OrderBy(x=>x.Value)
                                    .Select(x=>x.Key)
                                    .First();
                openSet.Remove(current);

                if(current.Equals(goal))
                    return true;

                closedSet.Add(current);

                foreach (var neighbor in this._graph.GetNeighbors(current))
                {
                    if(closedSet.Contains(neighbor))
                        continue;

                    if(!openSet.Contains(neighbor))
                    {
                        openSet.Add(neighbor);

                        var tentativegScore = gScore[current];
                        if(gScore.ContainsKey(neighbor) && tentativegScore >= gScore[neighbor])
                            continue;

                        gScore.Add(neighbor, tentativegScore);
                        fScore.Add(neighbor, gScore[neighbor] + HeuristicEstimate(neighbor, goal));
                    }
                }
            }
            return false;
            
        }

        private double HeuristicEstimate(Node start, Node goal)
        {
            return (Math.Abs(start.Column - goal.Column) + Math.Abs(start.Row - goal.Row));
        }
    }
}
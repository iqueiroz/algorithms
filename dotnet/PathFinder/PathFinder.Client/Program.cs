using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading;

namespace PathFinder.Client
{
    class Program
    {
        private static ISearchAlgorithm CreateSearchAlgorithm(Graph graph)
        {
            return new AStar(graph);
        }
        static void Main(string[] args)
        {
            Stopwatch sw = new Stopwatch();
            sw.Start();

            int totalRows, totalColumns;
            var input = Console.ReadLine().Split(' ');
            totalRows = Convert.ToInt32(input[0]);
            totalColumns = Convert.ToInt32(input[1]);
            
            var lines = ReadMazeLines(totalRows, totalColumns);


            var graphs = new Graph[2];
            WaitHandle[] waitHandles = new WaitHandle[graphs.Length];

            for (int i = 0; i < graphs.Length; i++)
            {
                var index = i;
                var handle = new EventWaitHandle(false, EventResetMode.ManualReset);
                var thread = new Thread(() =>
                                {
                                    graphs[index] = ParseGraph(lines, totalRows, totalColumns, index.ToString()[0]);
                                    handle.Set();
                                });
                waitHandles[i] = handle;
                thread.Start();
            }
            WaitHandle.WaitAll(waitHandles);
            Console.WriteLine("Parse: {0}", sw.ElapsedMilliseconds);

            int totalSamples = Convert.ToInt32(Console.ReadLine());
                        
            for (int i = 0; i < totalSamples; i++)
            {
                var sample = Console.ReadLine().Split(' ');
                var pointA = new Point(Convert.ToInt32(sample[0])-1, Convert.ToInt32(sample[1])-1);
                var pointB = new Point(Convert.ToInt32(sample[2])-1, Convert.ToInt32(sample[3])-1);
                bool found = false;
                for(var j = 0; j < graphs.Length; j++)
                {
                    if(found)
                        continue;
                    var algorithm = CreateSearchAlgorithm(graphs[j]);
                    Node start = Node.None, goal = Node.None;
                    try
                    {
                        start = graphs[j].GetNode(pointA.Row, pointA.Column);
                        goal = graphs[j].GetNode(pointB.Row, pointB.Column);
                    }
                    catch(KeyNotFoundException)
                    {

                    }
                    if(!start.Equals(Node.None) && !goal.Equals(Node.None))
                    {
                        var reachable = algorithm.IsReacheable(start, goal);
                        if(reachable)
                        {
                            switch(j)
                            {
                                case 0:
                                    Console.WriteLine("binary");
                                    found = true;
                                    break;
                                case 1:
                                    Console.WriteLine("decimal");
                                    found = true;
                                    break;
                            }
                        }
                    }
                }
                if(!found)
                    Console.WriteLine("neither");
            }

            sw.Stop();
            Console.WriteLine("Enlapsed: {0}", sw.ElapsedMilliseconds);

            

        }

        private static string[] ReadMazeLines(int totalRows, int totalColumns)
        {
            string[] lines = new string[totalRows];
            for (int i = 0; i < totalRows; i++)
            {
                lines[i] = Console.ReadLine();
                if(lines[i].Length > totalColumns)
                    lines[i] = lines[i].Substring(0, totalColumns);
            }
            return lines;
        }
        private static void PrintResolution(string[] lines, int totalRows, int totalColumns, ICollection<Node> path)
        {
            var defaultColor = Console.ForegroundColor;
            for (int i = 0; i < totalRows; i++)
            {
                for (int j = 0; j < totalColumns; j++)
                {
                    var isMatch = path.Any(x=>x.Row == i && x.Column == j);

                    if(isMatch)
                        Console.ForegroundColor = ConsoleColor.Green;
                    else
                        Console.ForegroundColor = defaultColor;
                    Console.Write(lines[i][j]);
                }
                Console.WriteLine();
            }
            Console.ForegroundColor = defaultColor;
        }
        private static Graph ParseGraph(string[] lines, int totalRows, int totalColumns, char path)
        {
            Graph graph = new Graph(totalRows, totalColumns);

            for (int i = 0; i < totalRows; i++)
            {
                for (int j = 0; j < totalColumns; j++)
                {
                    if(lines[i][j] == path)
                    {
                        var node = graph.AddNode(i, j);
                        if(i > 0 && lines[i-1][j] == path)
                            graph.AddEdge(node, graph.GetNode(i-1, j));
                        if(j > 0 && lines[i][j-1] == path)
                            graph.AddEdge(node, graph.GetNode(i, j-1));
                    }
                }
            }

            return graph;
        }

        private static void PrintGraph(Graph graph)
        {
            foreach(var vertex in graph.Vertices)
            {
                Console.WriteLine("{0}: {1}",
                    vertex.Id,
                    string.Join(
                        ',',
                        graph.GetNeighbors(vertex)));
                
            }
        }

    }
}

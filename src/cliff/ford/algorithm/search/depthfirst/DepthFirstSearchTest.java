package cliff.ford.algorithm.search.depthfirst;


import cliff.ford.data.structure.graph.adjacencylist.AdjacencyListGraph;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class DepthFirstSearchTest {
    @Test
    public void test(){
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addVector(1);
        graph.addVector(2);
        graph.addVector(3);
        graph.addVector(4);
        graph.addVector(5);
        //孤立点6
        graph.addVector(6);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,5);
        System.out.println(DepthFirstSearch.search(graph, 2).key);
        System.out.println(DepthFirstSearch.search(graph, 8));
        System.out.println(DepthFirstSearch.search(graph, null));
        System.out.println(DepthFirstSearch.search(null, 2));
        System.out.println(DepthFirstSearch.search(graph, 1).key);
        System.out.println(DepthFirstSearch.search(graph, 3).key);
        System.out.println(DepthFirstSearch.search(graph, 4).key);
        System.out.println(DepthFirstSearch.search(graph, 5).key);
        System.out.println(DepthFirstSearch.search(graph, 6).key);
    }
}

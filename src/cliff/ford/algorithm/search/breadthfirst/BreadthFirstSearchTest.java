package cliff.ford.algorithm.search.breadthfirst;

import cliff.ford.data.structure.graph.adjacencylist.AdjacencyListGraph;
import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class BreadthFirstSearchTest {
    @Test
    public void test(){
        AdjacencyListGraph graph = new AdjacencyListGraph();
        graph.addVector(1);
        graph.addVector(2);
        graph.addVector(3);
        graph.addVector(4);
        graph.addVector(5);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(2,4);
        System.out.println(BreadthFirstSearch.search(graph, 2).key);
        System.out.println(BreadthFirstSearch.search(graph, 2).reachAbleNodes.size());
        System.out.println(BreadthFirstSearch.search(graph, 8));
        System.out.println(BreadthFirstSearch.search(graph, null));
        System.out.println(BreadthFirstSearch.search(null, 2));
    }
}

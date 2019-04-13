package cliff.ford.algorithm.search.dijkstra;

import cliff.ford.data.structure.graph.adjacencylistwithweight.adjacencylist.AdjacencyListGraphWithWeight;
import org.junit.Test;

import java.util.List;

/**
 * @author Cliff_Ford
 */
public class DijkstraSearchTest {
    @Test
    public void test(){
        AdjacencyListGraphWithWeight graph = new AdjacencyListGraphWithWeight();
        graph.addVector(1);
        graph.addVector(2);
        graph.addVector(3);
        graph.addVector(4);
        graph.addVector(5);
        graph.addEdge(1,2,3);
        graph.addEdge(1,3,2);
        graph.addEdge(1,5,6);
        graph.addEdge(2,3,1);
        graph.addEdge(2,5,3);
        graph.addEdge(3,5,4);
        List<String> paths = DijkstraSearch.shortestPaths(graph,1,5);
        for(String path : paths){
            System.out.println(path);
        }
    }

    @Test
    public void test2(){
        AdjacencyListGraphWithWeight graph = new AdjacencyListGraphWithWeight();
        graph.addVector(1);
        graph.addVector(2);
        graph.addVector(3);
        graph.addVector(4);
        graph.addVector(5);
        graph.addVector(6);
        graph.addVector(7);
        graph.addEdge(1,2,2);
        graph.addEdge(1,3,5);
        graph.addEdge(2,3,6);
        graph.addEdge(2,4,1);
        graph.addEdge(2,5,3);
        graph.addEdge(3,6,8);
        graph.addEdge(4,5,4);
        graph.addEdge(5,7,9);
        graph.addEdge(6,7,7);
        List<String> paths = DijkstraSearch.shortestPaths(graph,1,7);
        for(String path : paths){
            System.out.println(path);
        }
    }
}

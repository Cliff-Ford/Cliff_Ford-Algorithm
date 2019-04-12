package cliff.ford.algorithm.search.bellmanford;


import cliff.ford.data.structure.graph.adjacencylistwithweight.adjacencylist.AdjacencyListGraphWithWeight;
import org.junit.Test;

import java.util.List;

/**
 * @author Cliff_Ford
 */
public class BellmanFordSearchTest {
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
        List<String> paths = BellmanFordSearch.shortestPaths(graph,1,5);
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
        graph.addEdge(1,2,1);
        graph.addEdge(1,4,4);
        graph.addEdge(2,3,2);
        graph.addEdge(3,4,1);
        List<String> paths = BellmanFordSearch.shortestPaths(graph,1,4);
        for(String path : paths){
            System.out.println(path);
        }
    }

}

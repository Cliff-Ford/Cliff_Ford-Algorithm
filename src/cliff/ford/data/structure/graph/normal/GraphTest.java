package cliff.ford.data.structure.graph.normal;

import org.junit.Test;

/**
 * @author Cliff_Ford
 */
public class GraphTest {
    @Test
    public void test(){
        Graph graph = new Graph();
        graph.addVector(1);
        graph.addVector(2);
        graph.addVector(3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1, 3);
        graph.get(3);
        graph.check();
        graph.deleteVector(3);
        graph.get(3);
        graph.check();
        graph.change(2,4);
        graph.check();
        graph.deleteVector(1);
        graph.deleteVector(4);
        //重建图,该图没有边
        graph.addVector(7);
        graph.addVector(8);
        graph.check();
    }
}

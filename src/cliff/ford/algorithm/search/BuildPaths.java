package cliff.ford.algorithm.search;

import cliff.ford.data.structure.graph.adjacencylist.Vector;
import cliff.ford.data.structure.graph.adjacencylistwithweight.adjacencylist.AdjacencyListGraphWithWeight;

import java.util.List;

/**
 * @author Cliff_Ford
 */
public class BuildPaths {
    /**
     * 构建最短路径
     * @param graph 起点 终点 所在图
     * @param minDistance 距离终点的最小距离
     * @param paths 所有可能路径
     * @param startPoint 起始点
     */
    public static void buildPaths(AdjacencyListGraphWithWeight graph,
                                   int minDistance,
                                   List<String> paths,
                                   Integer startPoint,
                                   Integer endPoint) {
        boolean[] flag = new boolean[graph.vectors.size()];
        int indexForStartPoint = indexOfVectorByKey(graph, startPoint);
        for(int i = 0, len = graph.vectors.get(indexForStartPoint).reachAbleNodes.size(); i < len; i++){
            //一步到达终点
            if(minDistance == graph.weights.get(indexForStartPoint).get(i)){
                if(endPoint.equals(graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key)){
                    paths.add(startPoint+"->"+graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key);
                    flag[indexForStartPoint] = true;
                }

            }else if(minDistance > graph.weights.get(indexForStartPoint).get(i)){
                //两步以上
                StringBuilder path = new StringBuilder();
                //第一步
                path.append(startPoint).append("->");
                flag[indexForStartPoint] = true;
                //剩下的步
                restPath(graph,
                        minDistance-graph.weights.get(indexForStartPoint).get(i),
                        graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key,
                        path, flag, paths,endPoint);
            }
        }
    }

    private static void restPath(AdjacencyListGraphWithWeight graph, int minDistance, Integer startPoint, StringBuilder path, boolean[] flag, List<String> paths, Integer endPoint) {
        StringBuilder newPath = new StringBuilder();
        newPath.append(path);
        boolean[] newFlag = new boolean[flag.length];
        System.arraycopy(flag,0,newFlag,0,flag.length);
        int indexForStartPoint = indexOfVectorByKey(graph, startPoint);
        Vector cur = graph.vectors.get(indexForStartPoint);
        for(int i = 0, len = graph.vectors.get(indexForStartPoint).reachAbleNodes.size(); i < len; i++){

            //一步到达终点
            if(minDistance == graph.weights.get(indexForStartPoint).get(i) && !newFlag[indexOfVectorByKey(graph, cur.reachAbleNodes.get(i).key)]){
                if(endPoint.equals(graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key)){
                    newFlag[indexForStartPoint] = true;
                    String s = ""+newPath+cur.key+"->"+graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key;
                    paths.add(s);
                }
            }else if(minDistance >= graph.weights.get(indexForStartPoint).get(i) && !newFlag[indexOfVectorByKey(graph, cur.reachAbleNodes.get(i).key)]){
                String s = startPoint+"->";
                newPath.append(s);

                newFlag[indexForStartPoint] = true;
                //剩下的步
                restPath(graph,minDistance-graph.weights.get(indexForStartPoint).get(i),
                        graph.vectors.get(indexForStartPoint).reachAbleNodes.get(i).key,newPath,newFlag,paths,endPoint);
                //回溯
                newFlag[indexForStartPoint] = false;
                newPath = new StringBuilder().append(newPath.substring(0, newPath.length()-s.length()));

            }
        }
    }

    public static int indexOfVectorByKey(AdjacencyListGraphWithWeight graph, Integer key) {
        for(int i = 0, len = graph.vectors.size(); i < len; i++){
            if(graph.vectors.get(i).key.equals(key)){
                return i;
            }
        }
        return -1;
    }

    public static boolean isTwoPointConnected(AdjacencyListGraphWithWeight graph, Integer startPoint, Integer endPoint) {
        int i = indexOfVectorByKey(graph, startPoint);
        int j = indexOfVectorByKey(graph, endPoint);
        if(i != -1 && j != -1){
            return (graph.vectors.get(i).reachAbleNodes.size()>0) && (graph.vectors.get(j).reachAbleNodes.size()>0);
        }
        return false;
    }
}

package cliff.ford.algorithm.sort;

/**
 * 用于输出检查
 * @author Cliff_Ford
 */
public interface Check {
    /**
     * 输出检查
     * @param list 待检查序列
     */
    static void check(int[] list){
        if(list != null && list.length >= 1){
            for(int t : list){
                System.out.print(t+" ");
            }
            System.out.println();
        }else if(list == null){
            System.out.println("null");
        }else{
            System.out.println("[]");
        }
    }
}

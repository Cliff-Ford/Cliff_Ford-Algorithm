package cliff.ford.algorithm.search.linear;

import cliff.ford.algorithm.search.Search;

/**
 * 线性查找
 * @author Cliff_Ford
 */
public class LinearSearch implements Search {

    @Override
    public int search(int[] list, int target) {
        if(list == null || list.length == 0){
            return -1;
        }
        int len = list.length;
        for(int i = 0; i < len; i++){
            if(list[i] == target){
                return i;
            }
        }
        return -1;
    }
}

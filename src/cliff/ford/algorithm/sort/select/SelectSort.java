package cliff.ford.algorithm.sort.select;

import cliff.ford.algorithm.sort.Sort;

/**
 * 选择排序
 * @author Cliff_Ford
 */

public class SelectSort implements Sort {
    /**
     * 排序接口
     *
     * @param list 待排序序列
     */
    @Override
    public void sort(int[] list) {
        if(list == null || list.length == 0 || list.length == 1){
            return;
        }
        int len = list.length;
        for(int i = 0; i < len-1; i++){
            int index = i;
            for(int j = i+1; j < len; j++){
                //选出最小的数对应的下标
                if(list[index] > list[j]){
                    index = j;
                }
            }
            int t = list[i];
            list[i] = list[index];
            list[index] = t;
        }
    }
}
